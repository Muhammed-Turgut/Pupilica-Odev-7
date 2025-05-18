buildscript{
    dependencies{
        classpath ("com.google.dagger:hilt-android-gradle-plugin:2.56")
        classpath ("androidx.navigation:navigation-safe-args-gradle-plugin:2.5.3")

    }
}

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
}