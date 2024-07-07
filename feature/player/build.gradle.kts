plugins {
    alias(libs.plugins.convetion.feature)
}

android.namespace = "com.alice.player"

dependencies {
    implementation(libs.bundles.media3)
    implementation(projects.core.common)
}
