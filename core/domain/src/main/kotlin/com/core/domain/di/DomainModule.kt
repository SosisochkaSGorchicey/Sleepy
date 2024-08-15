package com.core.domain.di

import com.core.domain.usecase.SignInUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val domainModule = module {
    singleOf(::SignInUseCase)
}