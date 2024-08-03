plugins {
    alias(libs.plugins.convetion.feature)
}

android.namespace = "com.feature.player"

dependencies {
    implementation(libs.androidx.activity.compose)
    implementation(libs.bundles.media3)

    implementation(projects.core.common)//todo
    implementation(projects.core.ui)
}
