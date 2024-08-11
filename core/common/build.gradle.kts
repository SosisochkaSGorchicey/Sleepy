plugins {
    alias(libs.plugins.convetion.library)
}

android.namespace = "com.alice.common"


dependencies {
    implementation(libs.bundles.voyager)
    implementation(libs.orbit.viewmodel)
    implementation(libs.coroutines.core)
}