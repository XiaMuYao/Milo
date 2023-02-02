import com.android.build.gradle.internal.api.ApkVariantOutputImpl

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
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

    signingConfigs  {
        getByName("debug") {
            storeFile = file("D:\\Project\\GitHub\\Android\\confluence.jks")
            keyAlias = "xiamuyao"
            storePassword = "xmy73562418"
            keyPassword = "xmy73562418"
        }
        create("release"){
            storeFile = file("D:\\Project\\GitHub\\Android\\confluence.jks")
            keyAlias = "xiamuyao"
            storePassword = "xmy73562418"
            keyPassword = "xmy73562418"
        }
    }

    buildTypes {
        release {
            isMinifyEnabled =false
            proguardFile("proguard-android-optimize.txt")
        }
    }
    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_11)
        targetCompatibility(JavaVersion.VERSION_11)
    }

    kotlinOptions.jvmTarget= JavaVersion.VERSION_11.majorVersion

    buildFeatures.dataBinding = true

    applicationVariants.all {
        outputs.all {
            if (this is ApkVariantOutputImpl){
                this.outputFileName = "Milo_app_$versionName.apk"
            }
        }
    }

}
dependencies {
    implementation ("androidx.core:core-ktx:1.9.0")
    implementation ("androidx.appcompat:appcompat:1.5.1")
    implementation ("com.google.android.material:material:1.7.0")
    implementation ("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation( project(path = ":miloBox"))
    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation( "androidx.test.ext:junit:1.1.4")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.5.0")
}