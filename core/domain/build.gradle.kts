plugins {
    alias(libs.plugins.convetion.library)
}

android.namespace = "com.core.domain"

dependencies {
    implementation(libs.coroutines.core)
    implementation(libs.koin.android)
    implementation(libs.supabase.gotrue)
}