plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-parcelize")
    id("androidx.navigation.safeargs.kotlin")
    id("com.google.devtools.ksp")
    id("org.jlleitschuh.gradle.ktlint")
    alias(libs.plugins.google.gms.google.services)
}

android {
    namespace = "com.iyam.myfirebasedatabaseapp"
    compileSdk = 34

    defaultConfig {
        applicationId =
            "com.iyam.myfirebasedatabaseapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner =
            "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
}

tasks.getByPath("preBuild").dependsOn("ktlintFormat")

ktlint {
    android.set(false)
    ignoreFailures.set(true)
    reporters {
        reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.PLAIN)
        reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.CHECKSTYLE)
    }
    kotlinScriptAdditionalPaths {
        include(fileTree("scripts/"))
    }
    filter {
        exclude("**/generated/**")
        include("**/kotlin/**")
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.firebase.database)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    // navigation
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    // coil
    implementation(libs.coil)
    // coroutine
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)
    // ktx lifecycle
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.lifecycle.livedata.ktx)
    // rv
    implementation(libs.androidx.recyclerview)
    // fragment ktx
    implementation(libs.androidx.fragment.ktx)
    // data store
    implementation(libs.androidx.datastore.preferences)
    // retrofit & okhttp
    implementation(libs.retrofit)
    implementation(libs.retrofit2.converter.gson)
    implementation(libs.okhttp)
    // chucker
    debugImplementation(libs.library)
    releaseImplementation(libs.library.no.op)
    // koin
    implementation(libs.koin.android)
    // room database libraries
    implementation(libs.androidx.room.ktx)
    ksp(libs.room.compiler)
    // firebase
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.crashlytics.ktx)
    implementation(libs.firebase.analytics.ktx)
    implementation(libs.firebase.auth.ktx)

}