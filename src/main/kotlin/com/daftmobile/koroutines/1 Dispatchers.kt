@file:Suppress("FunctionName")
@file:OptIn(ExperimentalStdlibApi::class)
package com.daftmobile.koroutines

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun `1 Dispatchers`() = runBlocking {
    var count = 0

    val job1 = launch {
        repeat(1_000_000) { count++ }
    }

    val job2 = launch {
        repeat(1_000_000) { count++ }
    }

    job1.join()
    job2.join()

    println(count)
}