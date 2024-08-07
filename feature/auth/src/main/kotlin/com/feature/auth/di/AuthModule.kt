package com.feature.auth.di

import cafe.adriel.voyager.core.registry.screenModule
import com.alice.common.navigation.SharedScreen
import com.feature.auth.signIn.SignInScreen
import com.feature.auth.signIn.screenmodel.SignInScreenModel
import com.feature.auth.signUp.SignUpScreen
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val authModule = module {
    factoryOf(::SignInScreenModel)
}

val authScreenModule = screenModule {
    register<SharedScreen.SignIn> {
        SignInScreen
    }

    register<SharedScreen.SignUp> {
        SignUpScreen
    }
}