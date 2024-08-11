import com.android.build.gradle.LibraryExtension
import com.buildlogic.configureAndroidCompose
import com.buildlogic.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class AndroidLibraryComposeConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) = with(target) {
        pluginManager.apply {
            apply(libs.plugins.android.library.get().pluginId)
            apply(libs.plugins.compose.compiler.get().pluginId)
        }

        extensions.getByType<LibraryExtension>().let(::configureAndroidCompose)

        dependencies {
            add("implementation", libs.androidx.material3)
            add("implementation", libs.androidx.ui)
        }
    }
}
