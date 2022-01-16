package com.daftmobile.koroutines

import kotlinx.coroutines.CoroutineScope

fun CoroutineScope.log() = println("${Thread.currentThread().name} $coroutineContext")