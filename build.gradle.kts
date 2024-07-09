buildscript {
    dependencies {
        classpath("com.android.tools.build:gradle:8.5.0")
    }
}

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    id("androidx.navigation.safeargs.kotlin") version "2.7.7" apply false
    id("com.google.devtools.ksp") version "1.9.10-1.0.13" apply false
    id("org.jlleitschuh.gradle.ktlint") version "11.6.1" apply false
    alias(libs.plugins.google.gms.google.services) apply false
}