plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false

}

task("clean", Delete::class) {
    delete(rootProject.buildDir)
}
