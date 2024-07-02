plugins {
    alias(libs.plugins.convetion.feature)
}

android.namespace = "com.alice.player"

dependencies {
    implementation(projects.core.common)
}
