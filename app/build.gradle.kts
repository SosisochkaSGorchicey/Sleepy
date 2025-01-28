plugins {
    alias(libs.plugins.convetion.application)
    alias(libs.plugins.convetion.compose.app)
    alias(libs.plugins.google.services)
}

android {
    namespace = "com.simple.mobile.sleepy"
    defaultConfig.applicationId = "com.simple.mobile.sleepy"
}

dependencies {
    implementation(libs.voyager.transitions)
    implementation(libs.bundles.voyager)
    implementation(libs.bundles.koin)
    implementation(libs.androidx.activity.compose)
    implementation(libs.bundles.compose)

    implementation(projects.core.ui)
    implementation(projects.core.common)
    implementation(projects.core.data)
    implementation(projects.core.domain)
    implementation(projects.core.database)

    implementation(projects.feature.initial)
    implementation(projects.feature.auth)
    implementation(projects.feature.player)
    implementation(projects.feature.home)
    implementation(projects.feature.audioContent)
    implementation(projects.feature.notification)
    implementation(libs.firebase.common.ktx)
}