package com.core.data.utils

import com.core.domain.model.supabase.SupabaseResult

fun Throwable.isChainError(): Boolean =
    this.message?.contains("Chain validation failed") == true

suspend fun <T> supabaseRequest(block: suspend () -> T): SupabaseResult<T> {
    return try {
        val result = block()
        SupabaseResult.Success(result)
    } catch (e: Throwable) {
        e.toSupabaseError()
    }
}