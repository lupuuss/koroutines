package com.daftmobile.koroutines

import kotlinx.coroutines.CoroutineScope

fun CoroutineScope.log(msg: Any = "") = println("$msg ${Thread.currentThread().name} $coroutineContext")