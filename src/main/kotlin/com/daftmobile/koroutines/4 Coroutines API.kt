@file:Suppress("FunctionName")
@file:OptIn(ExperimentalStdlibApi::class, ExperimentalCoroutinesApi::class)
package com.daftmobile.koroutines

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun `4 Coroutines API`() = runBlocking<Unit> {
    measureTimeMillis {
        println("Result = ${doMath()}")
    }.also { println("Time = $it ms") }
}

suspend fun doMath(): Int = supervisorScope {
    val result1 = async { sum1() }
    val result2 = async { sum2() }

    val result1Awaited = runCatching { result1.await() }.getOrElse { 0 }

     result1Awaited + result2.await()
}

suspend fun sum1(): Int {
    delay(1000)
    throw IllegalStateException("123")
}

suspend fun sum2(): Int {
    delay(1000)
    return 3 + 7
}