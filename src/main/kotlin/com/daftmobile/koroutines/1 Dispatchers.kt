@file:Suppress("FunctionName")
@file:OptIn(ExperimentalStdlibApi::class)
package com.daftmobile.koroutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun `1 Dispatchers`() = runBlocking {
    var count = 0

    coroutineScope {
        launch {
            repeat(1_000_000) { count++ }
        }

        launch {
            repeat(1_000_000) { count++ }
        }
    }

    println(count)
}