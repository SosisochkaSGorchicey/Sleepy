plugins {
    alias(libs.plugins.convetion.feature)
}

android.namespace = "com.feature.auth"

dependencies {
    implementation(projects.core.common)
    implementation(projects.core.ui) //todo
}
