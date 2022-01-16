@file:Suppress("FunctionName")
@file:OptIn(ExperimentalStdlibApi::class)
package com.daftmobile.koroutines

import kotlinx.coroutines.*

fun `2 Cancellation`() = runBlocking {
    val job = launch(Dispatchers.Default) {
        while (isActive) { println("XD") }
    }
    job.cancel()
}