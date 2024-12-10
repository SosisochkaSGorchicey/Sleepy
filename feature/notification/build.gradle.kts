plugins {
    alias(libs.plugins.convetion.feature)
}

android.namespace = "com.feature.notification"

dependencies {//todo
    implementation("io.github.darkokoa:datetime-wheel-picker:1.0.2-compose1.7")
    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.6.1")
}
