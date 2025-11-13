plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.publish)
    `maven-publish`
    signing
}

val libGroup = "dev.datlag.inkraft"
val libName = "nanoid"

group = libGroup
version = libVersion

kotlin {
    androidLibrary {
        compileSdk = 36
        minSdk = 21

        namespace = "$libGroup.$libName"
    }
    jvm()

    linuxX64 {
        binaries {
            sharedLib()
            staticLib()
        }
    }
    linuxArm64 {
        binaries {
            sharedLib()
            staticLib()
        }
    }

    mingwX64 {
        binaries {
            sharedLib()
            staticLib()
        }
    }

    macosX64 {
        binaries {
            sharedLib()
            staticLib()
        }
    }
    macosArm64 {
        binaries {
            sharedLib()
            staticLib()
        }
    }

    iosX64 {
        binaries {
            sharedLib()
            staticLib()
        }
    }
    iosArm64 {
        binaries {
            sharedLib()
            staticLib()
        }
    }
    iosSimulatorArm64 {
        binaries {
            sharedLib()
            staticLib()
        }
    }

    tvosX64 {
        binaries {
            sharedLib()
            staticLib()
        }
    }
    tvosArm64 {
        binaries {
            sharedLib()
            staticLib()
        }
    }
    tvosSimulatorArm64 {
        binaries {
            sharedLib()
            staticLib()
        }
    }

    watchosArm32 {
        binaries {
            sharedLib()
            staticLib()
        }
    }
    watchosArm64 {
        binaries {
            sharedLib()
            staticLib()
        }
    }
    watchosSimulatorArm64 {
        binaries {
            sharedLib()
            staticLib()
        }
    }
    watchosDeviceArm64 {
        binaries {
            sharedLib()
            staticLib()
        }
    }

    js {
        browser()
        nodejs()
    }

    wasmJs {
        browser()
        nodejs()
    }

    applyDefaultHierarchyTemplate()

    sourceSets {
        commonMain.dependencies {
            implementation(libs.korlibs.crypto)
        }

        commonTest.dependencies {
            implementation(libs.test)
        }
    }
}

publishing {
    repositories {
        maven {
            name = "githubPackages"
            url = uri("https://maven.pkg.github.com/iN-Kraft/NanoId")
            credentials(PasswordCredentials::class)
        }
    }
}

mavenPublishing {
    coordinates(
        groupId = libGroup,
        artifactId = libName,
        version = libVersion
    )

    pom {
        name.set("NanoId")
        description.set("A unique string ID generator for Kotlin Multiplatform.")
        inceptionYear.set("2020")
        url.set("https://github.com/iN-Kraft/NanoId")

        licenses {
            license {
                name.set("GNU Lesser General Public License version 3")
                url.set("https://opensource.org/license/lgpl-3-0")
            }
        }
        developers {
            developer {
                id.set("DatL4g")
                name.set("Jeff Retz")
                url.set("https://github.com/DatL4g")
            }
        }
        scm {
            url.set("https://github.com/iN-Kraft/NanoId")
            connection.set("scm:git:git://github.com/iN-Kraft/NanoId.git")
            developerConnection.set("scm:git:ssh://git@github.com/iN-Kraft/NanoId.git")
        }
    }
}