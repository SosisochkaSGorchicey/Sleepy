plugins {
    alias(libs.plugins.convetion.feature)
}

android.namespace = "com.feature.content"

dependencies {
    implementation(projects.feature.player)
}
