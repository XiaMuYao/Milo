plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}



android {
    compileSdk = 33
    defaultConfig {
        minSdk = 23
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
}

dependencies {
    api("androidx.core:core-ktx:1.9.0")
    api("androidx.collection:collection-ktx:1.2.0")
    api("androidx.fragment:fragment-ktx:1.5.5")

    api("androidx.appcompat:appcompat:1.5.1")
    api("com.google.android.material:material:1.7.0")
    testApi("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.4")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.0")


    // Brvah
    api("io.github.cymchad:BaseRecyclerViewAdapterHelper:4.0.0-beta02")

    // lifecycle
    val lifecycleVersion = "2.5.1"
    api("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion")
    api("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")

    // coroutines
    api("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")


    val roomVersion = "2.5.0"
    api("androidx.room:room-runtime:$roomVersion")
    annotationProcessor("androidx.room:room-compiler:$roomVersion")

    // KTX
    api("androidx.lifecycle:lifecycle-livedata-ktx:2.5.1")
    api("androidx.lifecycle:lifecycle-runtime-ktx:2.5.1")
    api("androidx.collection:collection-ktx:1.2.0")
    api("androidx.room:room-ktx:2.5.0")

    // immersionbar
    // 基础依赖包，必须要依赖
    api("com.geyifeng.immersionbar:immersionbar:3.2.2")
    // kotlin扩展（可选）
    api("com.geyifeng.immersionbar:immersionbar-ktx:3.2.2")

    //LiveDataBus
    api("io.github.jeremyliao:live-event-bus-x:1.8.0")

    //gson
    api("com.google.code.gson:gson:2.9.0")

    //retrofit
    api("com.squareup.retrofit2:retrofit:2.9.0")
    api("com.squareup.retrofit2:converter-gson:2.9.0")
    api("com.squareup.okhttp3:logging-interceptor:4.9.1")


    //SmartRefreshLayout
    api("io.github.scwang90:refresh-layout-kernel:2.0.5")

    //MagicIndicator
    api("com.github.XuQK:KDTabLayout:1.1.6")

    //Glide
    api("com.github.bumptech.glide:glide:4.12.0")

}