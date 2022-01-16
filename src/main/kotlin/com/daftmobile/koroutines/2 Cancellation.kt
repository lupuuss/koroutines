@file:Suppress("FunctionName")
@file:OptIn(ExperimentalStdlibApi::class)

package com.daftmobile.koroutines

import kotlinx.coroutines.*

fun `2 Cancellation`() = runBlocking<Unit> {
    var count = 0

    repeat(20) {
        try {
            withTimeout(50) {
                delay(49)
                count++
            }
        } catch (e: TimeoutCancellationException) {

        } finally {
            count--
        }
    }

    println(count)
}
