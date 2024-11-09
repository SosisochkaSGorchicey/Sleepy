plugins {
    alias(libs.plugins.convetion.library)
}

android.namespace = "com.core.common"

dependencies {
    implementation(libs.bundles.voyager)
    implementation(libs.orbit.viewmodel)
    implementation(libs.coroutines.core)

    implementation(projects.core.domain)
}