package com.alice.common.mvi

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.container

abstract class MviScreenMode<S : Any, SE : Any, E : Any>(
    initialState: S,
) : ScreenModel, ContainerHost<S, SE> {
    override val container = screenModelScope.container<S, SE>(initialState = initialState)

    abstract fun onEvent(event: E)
}