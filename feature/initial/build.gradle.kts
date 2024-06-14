plugins {
    alias(libs.plugins.convetion.feature)
}

android.namespace = "com.alice.initial"

dependencies {
    implementation(projects.core.common)
}
