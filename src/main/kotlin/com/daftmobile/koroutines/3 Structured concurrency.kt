@file:Suppress("FunctionName")
@file:OptIn(ExperimentalStdlibApi::class)
package com.daftmobile.koroutines

import kotlinx.coroutines.*

fun `3 Structured concurrency`() = runBlocking(Dispatchers.Default) {
    val job = launch {
        launch {
            println(1)
        }
        launch(Job()) {
            delay(1000)
            println(2)
        }
    }
    delay(500)
    job.cancel()
}