plugins {
    alias(libs.plugins.convetion.feature)
}

android.namespace = "com.feature.initial"

dependencies {
    implementation(projects.core.common)
    implementation(projects.core.ui) //todo
}
