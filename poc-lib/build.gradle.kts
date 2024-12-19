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
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "poc-lib"
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
        minSdk = 25
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
            url = uri("https://maven.pkg.github.com/<GITHUB_USER_NAME>/MathLibGuide")
            credentials(PasswordCredentials::class)
        }
    }
}

mavenPublishing {
    // Define coordinates for the published artifact
    coordinates(
        groupId = "com.mindbodyonline.poclibexample",
        artifactId = "poc-lib",
        version = "0.0.1"
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
