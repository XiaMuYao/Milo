import com.android.build.gradle.internal.api.ApkVariantOutputImpl

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

@Suppress("UnstableApiUsage")
android {
    namespace = "com.confluence.milo"
    compileSdk = 33
    defaultConfig {
        applicationId = "com.confluence.milo"
        minSdk = 23
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    signingConfigs {
        getByName("debug") {
            storeFile = file("D:\\Project\\GitHub\\Android\\confluence.jks")
            keyAlias = "xiamuyao"
            storePassword = "xmy73562418"
            keyPassword = "xmy73562418"
        }
        create("release") {
            storeFile = file("D:\\Project\\GitHub\\Android\\confluence.jks")
            keyAlias = "xiamuyao"
            storePassword = "xmy73562418"
            keyPassword = "xmy73562418"
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFile("proguard-android-optimize.txt")
        }
    }
    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_11)
        targetCompatibility(JavaVersion.VERSION_11)
    }

    kotlinOptions.jvmTarget = JavaVersion.VERSION_11.majorVersion

    buildFeatures.dataBinding = true

    applicationVariants.all {
        outputs.all {
            if (this is ApkVariantOutputImpl) {
                this.outputFileName = "Milo_app_$versionName.apk"
            }
        }
    }

    kapt {
        useBuildCache = true
        correctErrorTypes = true
        javacOptions { option("-Xmaxerrs", 500) }
    }

}
dependencies {
    implementation(project(path = ":miloBox"))

    implementation("com.google.dagger:hilt-android:2.44")
    kapt("com.google.dagger:hilt-android-compiler:2.44")

    val roomVersion = "2.5.0"
    kapt("androidx.room:room-compiler:$roomVersion")

}
android {
    namespace = "com.confluence.milo"
}
