@file:Suppress("FunctionName")
@file:OptIn(ExperimentalStdlibApi::class)
package com.daftmobile.koroutines

import kotlinx.coroutines.*

fun `1 Dispatchers`() = runBlocking { // <--- ?
    var count = 0

    coroutineScope {
        launch {
            log()
            repeat(1_000_000) { count++ }
        }

        launch {
            log()
            repeat(1_000_000) { count++ }
        }
    }
    println(count)
}