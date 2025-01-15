import org.jetbrains.kotlin.konan.properties.Properties
import java.io.FileInputStream

plugins {
    alias(libs.plugins.convetion.library)
    alias(libs.plugins.kotlin.serizliation)
    alias(libs.plugins.google.services)
}

android.namespace = "com.core.data"

dependencies {
    // Import the Firebase BoM
    implementation(platform("com.google.firebase:firebase-bom:33.7.0"))


    // TODO: Add the dependencies for Firebase products you want to use
    // When using the BoM, don't specify versions in Firebase dependencies
    implementation("com.google.firebase:firebase-analytics")
    implementation("com.google.firebase:firebase-messaging")

    implementation(projects.core.domain)
    implementation(projects.core.database)

    implementation(libs.coroutines.core)
    implementation(libs.koin.android)
    implementation(libs.ktor.client.okhttp)
    implementation(libs.datastore.preferences)

    implementation(libs.bundles.supabase)
}

private val keystorePropertiesFile = file("keys.properties")
private val keystoreProperties = Properties()
keystoreProperties.load(FileInputStream(keystorePropertiesFile))

android{
    defaultConfig {
        buildConfigField("String", "SUPABASE_URL", keystoreProperties.getProperty("supabaseUrl"))
        buildConfigField("String", "SUPABASE_SECRET_KEY", keystoreProperties.getProperty("supabaseSecretKey"))
    }

    buildFeatures {
        buildConfig = true
    }
}
