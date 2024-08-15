plugins {
    alias(libs.plugins.convetion.application)
    alias(libs.plugins.convetion.compose.app)
}

android {
    namespace = "com.alice.sleepy"
    defaultConfig.applicationId = "com.alice.sleepy"
}

dependencies {
    implementation(libs.bundles.voyager)
    implementation(libs.bundles.koin)
    implementation(libs.androidx.activity.compose)
    implementation(libs.bundles.compose)

    implementation(projects.core.ui)
    implementation(projects.core.common)
    implementation(projects.core.data)
    implementation(projects.core.domain)
    implementation(projects.feature.initial)
    implementation(projects.feature.auth)
    implementation(projects.feature.player)

    implementation(libs.bundles.media3) //todo delete later
}