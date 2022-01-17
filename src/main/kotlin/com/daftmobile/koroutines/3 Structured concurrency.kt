@file:Suppress("FunctionName")
@file:OptIn(ExperimentalStdlibApi::class)
package com.daftmobile.koroutines

import kotlinx.coroutines.*

fun `3 Structured concurrency`() = runBlocking<Unit>(Dispatchers.Default) {
    launch {
        launch {
            delay(100)
            throw IllegalStateException("BOOOOOOOOOOM!")
        }

        launch {
            delay(1000)
            println("Ready!")
        }
        delay(1000)
        println("Done!")
    }
    launch {
        delay(1000)
        println("ACK!")
    }
}