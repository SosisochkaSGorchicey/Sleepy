package com.core.domain.di

import com.core.domain.usecase.auth.IsUserLoggedInUseCase
import com.core.domain.usecase.auth.SignInUseCase
import com.core.domain.usecase.auth.SignUpAnonymously
import com.core.domain.usecase.auth.SignUpUseCase
import com.core.domain.usecase.storage.CreateScheduleItemUseCase
import com.core.domain.usecase.storage.DeleteAllScheduleItemsUseCase
import com.core.domain.usecase.storage.DeleteScheduleItemUseCase
import com.core.domain.usecase.storage.DeleteScheduleItemsForWeekdayUseCase
import com.core.domain.usecase.storage.ObserveScheduleItemUseCase
import com.core.domain.usecase.storage.UpdateAllSimilarScheduleItemsUseCase
import com.core.domain.usecase.storage.UpdateScheduleItemUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val domainModule = module {
    singleOf(::SignInUseCase)
    singleOf(::SignUpUseCase)
    singleOf(::SignUpAnonymously)
    singleOf(::IsUserLoggedInUseCase)

    singleOf(::CreateScheduleItemUseCase)
    singleOf(::UpdateScheduleItemUseCase)
    singleOf(::UpdateAllSimilarScheduleItemsUseCase)
    singleOf(::ObserveScheduleItemUseCase)
    singleOf(::DeleteScheduleItemUseCase)
    singleOf(::DeleteAllScheduleItemsUseCase)
    singleOf(::DeleteScheduleItemsForWeekdayUseCase)
}