plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("com.google.devtools.ksp")
    id("kotlin-parcelize")
    id("androidx.navigation.safeargs")
}

android {
    namespace = "com.example.belajarandroid"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.belajarandroid"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        viewBinding = true
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    // Core Android and Kotlin components
    implementation(libs.androidx.core.ktx) // Core Kotlin extensions for Android
    implementation(libs.androidx.appcompat) // Support for backward compatibility with older Android versions
    implementation(libs.androidx.activity) // Support for managing Android Activity
    implementation(libs.androidx.activity.ktx) // Extensions for managing Android Activity with lifecycle awareness

// UI components and layouts
    implementation(libs.material) // Material Design components and styles
    implementation(libs.androidx.constraintlayout) // ConstraintLayout for creating complex layouts with a flat view hierarchy
    implementation(libs.glide) // Glide library for image loading and caching

// Navigation components
    implementation(libs.androidx.navigation.fragment.ktx) // Navigation component for fragment navigation
    implementation(libs.androidx.navigation.ui.ktx) // Navigation UI component

// Lifecycle and ViewModel components
    implementation(libs.androidx.lifecycle.runtime.ktx) // Lifecycle components for managing UI-related data in a lifecycle-conscious way
    implementation(libs.androidx.lifecycle.viewmodel.ktx) // ViewModel component for lifecycle-aware data management
    implementation(libs.androidx.lifecycle.livedata.ktx) // LiveData component for lifecycle-aware observable data
    implementation(libs.androidx.lifecycle.runtime.ktx.v286) // Runtime lifecycle components for backward compatibility

// Asynchronous programming with Kotlin Coroutines
    implementation(libs.kotlinx.coroutines.core) // Core Coroutines library
    implementation(libs.kotlinx.coroutines.android) // Android-specific Coroutines support

// Network operations
    implementation(libs.android.async.http) // Async HTTP library for network operations
    implementation(libs.retrofit) // Retrofit for making HTTP requests and handling API responses
    implementation(libs.converter.gson) // GSON converter for converting JSON data to Kotlin/Java objects
    implementation(libs.logging.interceptor) // Interceptor for logging network requests and responses

// Data persistence
    implementation(libs.androidx.preference) // Preferences for saving key-value pairs
    implementation(libs.androidx.datastore.preferences) // DataStore for saving data asynchronously with coroutine support

// Testing libraries
    testImplementation(libs.junit) // JUnit framework for unit testing
    androidTestImplementation(libs.androidx.junit) // AndroidX JUnit extensions for Android Instrumentation tests
    androidTestImplementation(libs.androidx.espresso.core) // Espresso library for UI testing
}