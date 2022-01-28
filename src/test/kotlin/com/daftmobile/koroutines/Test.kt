@file:OptIn(ExperimentalCoroutinesApi::class)
package com.daftmobile.koroutines

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.system.measureTimeMillis

suspend fun doThings() = coroutineScope {
    launch {
        delay(1000)
        println(" test!")
    }
    delay(500)
    print("Hello ")
}

class SomeTest {

    @Test
    fun test() = runTest {
        measureTimeMillis { doThings() }.also(::println)
    }
}