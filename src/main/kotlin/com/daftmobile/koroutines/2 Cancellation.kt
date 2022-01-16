@file:Suppress("FunctionName")
@file:OptIn(ExperimentalStdlibApi::class)
package com.daftmobile.koroutines

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun `2 Cancellation`() = runBlocking {
    val job = launch {
        while (true) { println("XD") }
    }

    job.cancel()
}