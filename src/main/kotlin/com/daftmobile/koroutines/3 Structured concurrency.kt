@file:Suppress("FunctionName")
@file:OptIn(ExperimentalStdlibApi::class)
package com.daftmobile.koroutines

import kotlinx.coroutines.*

fun `3 Structured concurrency`() {
    val scope = CoroutineScope(Dispatchers.Default + Job())
    scope.launch {
        launch {
            delay(100)
            println("DONE!")
        }
        runCatching {
            coroutineScope {
                throw IllegalStateException("2")
            }
        }
    }

    runBlocking { scope.coroutineContext.job.children.forEach { it.join() } }
}