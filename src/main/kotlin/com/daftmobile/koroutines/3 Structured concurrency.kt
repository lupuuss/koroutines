@file:Suppress("FunctionName")
@file:OptIn(ExperimentalStdlibApi::class)
package com.daftmobile.koroutines

import kotlinx.coroutines.*

fun `3 Structured concurrency`() = runBlocking<Unit>(Dispatchers.Default) {
    launch(Job().apply(CompletableJob::complete)) {
        println(":)")
    }
}