package com.core.domain.di

import com.core.domain.usecase.storage.CreateScheduleItemUseCase
import com.core.domain.usecase.auth.IsUserLoggedInUseCase
import com.core.domain.usecase.storage.ObserveScheduleItemUseCase
import com.core.domain.usecase.auth.SignInUseCase
import com.core.domain.usecase.auth.SignUpAnonymously
import com.core.domain.usecase.auth.SignUpUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val domainModule = module {
    singleOf(::SignInUseCase)
    singleOf(::SignUpUseCase)
    singleOf(::SignUpAnonymously)
    singleOf(::IsUserLoggedInUseCase)

    singleOf(::CreateScheduleItemUseCase)
    singleOf(::ObserveScheduleItemUseCase)
}