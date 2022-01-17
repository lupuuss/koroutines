@file:Suppress("FunctionName")
@file:OptIn(ExperimentalStdlibApi::class, ExperimentalCoroutinesApi::class)
package com.daftmobile.koroutines

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withTimeout
import kotlin.concurrent.thread
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException


fun `4 Coroutines API`() = runBlocking {
    withTimeout(700) {
        println(coRequest(2))
        println(coRequest(1))
    }
}

suspend fun coRequest(input: Int): Int = suspendCancellableCoroutine { continuation ->
    val disposable = request(
        input,
        onSuccess = { continuation.resume(it) },
        onError = { continuation.resumeWithException(it) }
    )
    continuation.invokeOnCancellation { disposable.interrupt() }
}

fun request(input: Int, onSuccess: (Int) -> Unit, onError: (Exception) -> Unit): Thread {
    return thread {
        runCatching {
            Thread.sleep(1000)
            if (input == 1)  {
                onError(IllegalStateException("BOOM!"))
            } else {
                onSuccess(input * 37)
            }
        }
    }
}