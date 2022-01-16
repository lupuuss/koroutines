@file:Suppress("FunctionName", "EXPERIMENTAL_API_USAGE")
@file:OptIn(ExperimentalStdlibApi::class)
package com.daftmobile.koroutines

import kotlinx.coroutines.*

fun `1 Dispatchers`() = runBlocking<Unit> {
    log("START")

    launch(Dispatchers.Unconfined) {
        log("Unconfined")
        suspensionPoint()
        log("Unconfined after delay")
    }

    launch(Dispatchers.Default) { log("Default") }

    launch(Dispatchers.IO) { log("IO") }

    delay(500)

    launch(Dispatchers.Main) { log("MAIN") }
}

private suspend fun suspensionPoint() {
    newSingleThreadContext("7312").use {
        withContext(it) {
            println("SUSPENSION POINT")
        }
    }
}