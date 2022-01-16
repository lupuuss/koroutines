@file:Suppress("FunctionName")
@file:OptIn(ExperimentalStdlibApi::class)
package com.daftmobile.koroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield

fun `2 Cancellation`() = runBlocking {
    val job = launch(Dispatchers.Default) {
        while (true) { println("XD") }
    }
    yield()
    job.cancel()
}