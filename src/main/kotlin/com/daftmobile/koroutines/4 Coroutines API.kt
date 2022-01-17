@file:Suppress("FunctionName")
@file:OptIn(ExperimentalStdlibApi::class, ExperimentalCoroutinesApi::class)
package com.daftmobile.koroutines

import kotlinx.coroutines.*
import java.lang.IllegalStateException
import kotlin.concurrent.thread
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine


fun `4 Coroutines API`() = runBlocking<Unit> {
    withTimeout(700) {
        println(coRequest(2))
        println(coRequest(1))
    }
}

suspend fun coRequest(input: Int): Int = suspendCoroutine { continuation ->
    request(
        input,
        onSuccess = { continuation.resume(it) },
        onError = { continuation.resumeWithException(it) }
    )
}

fun request(input: Int, onSuccess: (Int) -> Unit, onError: (Exception) -> Unit) {
    thread {
        Thread.sleep(1000)
        if (input == 1)  {
            onError(IllegalStateException("BOOM!"))
        } else {
            onSuccess(input * 37)
        }
    }
}