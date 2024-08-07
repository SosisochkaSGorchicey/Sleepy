package com.alice.common.mvi

import kotlinx.coroutines.Job
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.SimpleContext
import org.orbitmvi.orbit.syntax.simple.blockingIntent
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce

fun <S : Any, SE : Any> ContainerHost<S, SE>.emitSideEffect(
    sideEffect: SE,
): Job = intent { postSideEffect(sideEffect) }

fun <S : Any, SE : Any> ContainerHost<S, SE>.reducer(
    block: SimpleContext<S>.() -> S,
): Job = intent { reduce(block) }

fun <S : Any, SE : Any> ContainerHost<S, SE>.blockingReducer(
    block: SimpleContext<S>.() -> S,
): Unit = blockingIntent { reduce(block) }
