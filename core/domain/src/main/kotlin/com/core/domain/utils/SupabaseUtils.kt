package com.core.domain.utils

import com.core.domain.model.SupabaseResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

fun supabaseFlowRequest(block: suspend () -> Unit): Flow<SupabaseResult<Unit>> =
    flow {
        emit(SupabaseResult.Loading)
        try {
            block()
            emit(SupabaseResult.Success(Unit))
        } catch (e: Throwable) {
            emit(e.toSupabaseError())
        }
    }