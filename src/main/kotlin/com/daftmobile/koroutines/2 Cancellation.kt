@file:Suppress("FunctionName")
@file:OptIn(ExperimentalStdlibApi::class)
package com.daftmobile.koroutines

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield

fun `2 Cancellation`() = runBlocking {
    val job = launch {
        while (true) { println("XD") }
    }
    yield()
    job.cancel()
}