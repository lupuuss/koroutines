@file:Suppress("FunctionName")
@file:OptIn(ExperimentalStdlibApi::class)
package com.daftmobile.koroutines

import kotlinx.coroutines.*

fun `3 Structured concurrency`() {
    val scope = CoroutineScope(Dispatchers.Default + SupervisorJob() + CoroutineExceptionHandler { _, _ ->  })
    scope.launch {
        launch(CoroutineExceptionHandler { _, _ ->  println("I should not work :(")}) {
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