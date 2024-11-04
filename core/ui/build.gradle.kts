plugins {
    alias(libs.plugins.convetion.library)
    alias(libs.plugins.convetion.compose.lib)
}

android.namespace = "com.core.ui"

dependencies {
    implementation(libs.bundles.voyager)
    implementation(libs.compose.shimmer)

    implementation(projects.core.common)
    implementation(projects.core.domain)
}
