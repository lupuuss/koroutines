@file:Suppress("FunctionName")
@file:OptIn(ExperimentalStdlibApi::class)
package com.daftmobile.koroutines

import kotlinx.coroutines.*

fun `3 Structured concurrency`() {
    val handler = CoroutineExceptionHandler { _, exception ->
        println(exception)
        println(exception.suppressed.contentToString())
    }
    val scope = CoroutineScope(Dispatchers.Default + SupervisorJob() + handler)
    scope.launch {
        launch {
            delay(100)
            throw IllegalStateException("1")
        }
        launch {
            delay(100)
            throw IllegalStateException("2")
        }
        launch {
            delay(100)
            throw IllegalStateException("3")
        }
    }

    runBlocking { scope.coroutineContext.job.children.forEach { it.join() } }
}