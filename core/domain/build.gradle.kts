plugins {
    alias(libs.plugins.convetion.library)
    alias(libs.plugins.kotlin.serizliation)
}

android.namespace = "com.core.domain"

dependencies {
    implementation(libs.coroutines.core)
    implementation(libs.koin.android)
    implementation(libs.supabase.gotrue)
}