plugins {
    alias(libs.plugins.convetion.feature)
}

android.namespace = "com.feature.player"

dependencies {
    implementation(libs.androidx.activity.compose)

    implementation(projects.core.common)
    implementation(projects.core.ui)
}
