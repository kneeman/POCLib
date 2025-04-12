import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    id("com.vanniktech.maven.publish") version "0.28.0"
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
        publishLibraryVariants("release")
    }

    val xcframeworkName = "POCLib"
    val xcf = XCFramework(xcframeworkName)
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = xcframeworkName

            // Specify CFBundleIdentifier to uniquely identify the framework
            binaryOption("bundleId", "com.prateek.${xcframeworkName}")
            xcf.add(this)
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            //put your multiplatform dependencies here
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

android {
    namespace = "com.mindbodyonline.poclibexample"
    compileSdk = 34
    defaultConfig {
        minSdk = 23
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

publishing {
    repositories {
        maven {
            name = "githubPackages"
            url = uri("https://maven.pkg.github.com/kneeman/POCLib")
            credentials(PasswordCredentials::class)
        }
    }
}

mavenPublishing {
    // Define coordinates for the published artifact
    coordinates(
        groupId = "com.mindbodyonline.poclibexample",
        artifactId = "poc-lib",
        version = "0.0.3"
    )

    // Configure POM metadata for the published artifact
    pom {
        name.set("POC Library")
        description.set("Sample Kotlin MultiPlatform Library Test")
        inceptionYear.set("2024")
        url.set("https://github.com/kneeman/POCLib")

        licenses {
            license {
                name.set("MIT")
                url.set("https://opensource.org/licenses/MIT")
            }
        }

        // Specify developers information
        developers {
            developer {
                id.set("Kneeman")
                name.set("Craig Knee")
                email.set("craig_knee@yahoo.com")
            }
        }

        // Specify SCM information
        scm {
            url.set("https://github.com/kneeman/POCLib")
        }
    }
}

//tasks.register("assembleXCFramework") {
//    dependsOn("linkReleaseFrameworkIosArm64", "linkReleaseFrameworkIosSimulatorArm64")
//    doLast {
//        val xcframeworkDir = buildDir.resolve("xcframework")
//        xcframeworkDir.deleteRecursively()
//        xcframeworkDir.mkdirs()
//
//        val frameworkDirs = listOf(
//            buildDir.resolve("bin/iosArm64/releaseFramework"),
//            buildDir.resolve("bin/iosSimulatorArm64/releaseFramework")
//        )
//
//        exec {
//            commandLine(
//                "xcodebuild",
//                "-create-xcframework",
//                *frameworkDirs.flatMap { listOf("-framework", it.resolve("poc_lib.framework").path) }.toTypedArray(),
//                "-output",
//                xcframeworkDir.resolve("poc_lib.xcframework").path
//            )
//        }
//    }
//}