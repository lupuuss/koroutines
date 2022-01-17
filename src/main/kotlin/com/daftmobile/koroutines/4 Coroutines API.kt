@file:Suppress("FunctionName")
@file:OptIn(ExperimentalStdlibApi::class, ExperimentalCoroutinesApi::class)
package com.daftmobile.koroutines

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun `4 Coroutines API`() = runBlocking<Unit> {
    measureTimeMillis {
        val result1 = sum1()
        val result2 = sum2()
        println("Result = ${result1 + result2}")
    }.also { println("Time = $it ms") }
}

suspend fun sum1(): Int {
    delay(1000)
    return 2 + 1
}

suspend fun sum2(): Int {
    delay(1000)
    return 3 + 7
}