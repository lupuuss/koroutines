@file:Suppress("FunctionName")
@file:OptIn(ExperimentalStdlibApi::class)
package com.daftmobile.koroutines

import kotlinx.coroutines.*

fun `2 Cancellation`() = runBlocking {
    val job = launch(Dispatchers.Default) {
        try {
            while (true) {
                println("XD")
                yield()
            }
        } finally {
            withContext(NonCancellable) {
                println("I am out!")
                delay(100)
                println("Am I?")
            }
        }
    }
    job.cancel()
}