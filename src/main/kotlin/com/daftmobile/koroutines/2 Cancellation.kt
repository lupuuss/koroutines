@file:Suppress("FunctionName")
@file:OptIn(ExperimentalStdlibApi::class)

package com.daftmobile.koroutines

import kotlinx.coroutines.*

fun `2 Cancellation`() = runBlocking<Unit> {
    var count = 0

    repeat(20) {
        runCatching {
            withTimeout(50) {
                delay(100)
                count++
            }
            count--
        }
    }

    println(count)
}
