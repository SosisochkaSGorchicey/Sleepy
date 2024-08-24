package com.core.data.utils

fun Throwable.isChainError(): Boolean =
    this.message?.contains("Chain validation failed") == true