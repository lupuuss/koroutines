@file:Suppress("FunctionName")
@file:OptIn(ExperimentalStdlibApi::class, ExperimentalCoroutinesApi::class)
package com.daftmobile.koroutines

import kotlinx.coroutines.*

fun `4 Coroutines API`() = runBlocking {
    val job = launch(start = CoroutineStart.ATOMIC) {
        print("Hello ")
        delay(100)
        println(" world!")
    }
    println("JOB SCHEDULED")
    job.cancel()
}