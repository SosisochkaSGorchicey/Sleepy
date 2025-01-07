plugins {
    alias(libs.plugins.convetion.library)
    alias(libs.plugins.convetion.compose.lib)
}

android.namespace = "com.core.ui"

dependencies {
    implementation(libs.bundles.voyager)
    implementation(libs.voyager.transitions)
    implementation(libs.compose.shimmer)
    implementation(libs.kotlinx.datetime)

    implementation(projects.core.common)
    implementation(projects.core.domain)
}
