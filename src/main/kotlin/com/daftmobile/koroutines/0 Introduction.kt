@file:Suppress("FunctionName")
@file:OptIn(ExperimentalStdlibApi::class)
package com.daftmobile.koroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun `0 Introduction`() = runBlocking {
    launch {
        delay(1000)
        println(" world!")
    }
    delay(500)
    print("Hello ")
}