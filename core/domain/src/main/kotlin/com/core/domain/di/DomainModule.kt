package com.core.domain.di

import com.core.domain.usecase.IsUserLoggedInUseCase
import com.core.domain.usecase.SignInUseCase
import com.core.domain.usecase.SignUpAnonymously
import com.core.domain.usecase.SignUpUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val domainModule = module {
    singleOf(::SignInUseCase)
    singleOf(::SignUpUseCase)
    singleOf(::SignUpAnonymously)
    singleOf(::IsUserLoggedInUseCase)
}