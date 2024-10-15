import io.gitlab.arturbosch.detekt.extensions.DetektExtension
import org.jlleitschuh.gradle.ktlint.KtlintExtension

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.kotlin.detekt)
    alias(libs.plugins.kotlin.ktlint)
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.compose.compiler) apply false
    alias(libs.plugins.kotlin.serialization) apply false
    alias(libs.plugins.kotlin.parcelize) apply false
    alias(libs.plugins.hilt) apply false
    alias(libs.plugins.ksp) apply false
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(libs.gradle.kotlin)
    }
}

allprojects {
    apply {
        plugin(rootProject.libs.plugins.kotlin.detekt.get().pluginId)
        plugin(rootProject.libs.plugins.kotlin.ktlint.get().pluginId)
    }

    afterEvaluate {
        extensions.configure<DetektExtension> {
            parallel = true
            buildUponDefaultConfig = true
            toolVersion = libs.versions.kotlin.detekt.get()
            config.setFrom(files("$rootDir/detekt-config.yml"))
        }

        extensions.configure<KtlintExtension> {
            version.set(rootProject.libs.versions.kotlin.ktlint.source.get())
            android.set(true)
            verbose.set(true)
        }
    }
}
