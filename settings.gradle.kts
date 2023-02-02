rootProject.name = "Milo"
include( ":app",":miloBox")

pluginManagement {
    repositories {
        maven("https://maven.aliyun.com/repository/public")
        maven("https://jitpack.io")
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositories {
        maven("https://maven.aliyun.com/repository/public")
        maven("https://jitpack.io")
        google()
        mavenCentral()
    }
}
