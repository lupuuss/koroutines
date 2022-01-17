@file:Suppress("FunctionName")
@file:OptIn(ExperimentalStdlibApi::class)
package com.daftmobile.koroutines

import kotlinx.coroutines.*

fun `3 Structured concurrency`() {
    val scope = CoroutineScope(Dispatchers.Default + SupervisorJob())
    scope.launch(SupervisorJob()) {
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
    scope.launch {
        delay(1000)
        println("ACK!")
    }

    runBlocking { scope.coroutineContext.job.children.forEach { it.join() } }
}