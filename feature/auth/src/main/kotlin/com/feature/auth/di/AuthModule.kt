package com.feature.auth.di

import cafe.adriel.voyager.core.registry.screenModule
import com.alice.common.navigation.SharedScreen
import com.feature.auth.signIn.SignInScreen

val authScreenModule = screenModule {
    register<SharedScreen.SighIn> {
        SignInScreen
    }
}