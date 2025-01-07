plugins {
    alias(libs.plugins.convetion.feature)
}

android.namespace = "com.feature.notification"

dependencies {
    implementation(libs.datetime.wheel.picker)
    implementation(libs.kotlinx.datetime)
}
