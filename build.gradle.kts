import org.jetbrains.compose.compose

plugins {
    kotlin("multiplatform") version "1.6.10"
    id("org.jetbrains.compose") version "1.0.1"
    kotlin("plugin.serialization") version "1.6.10"

}

group = "me.user"
version = "1.0"
val ktorVersion = "1.6.7"
val serializationVersion = "1.3.0"
repositories {
    google()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

kotlin {
    js(IR) {
        browser {
            testTask {
                testLogging.showStandardStreams = true
                useKarma {
                    useChromeHeadless()
                    useFirefox()
                }
            }
        }
        binaries.executable()
    }
    sourceSets {
        val jsMain by getting {
            dependencies {
                implementation(compose.web.core)
                implementation(compose.runtime)
                implementation("app.softwork:routing-compose:0.1.5")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$serializationVersion")
                // https://mvnrepository.com/artifact/org.jetbrains.kotlin-wrappers/kotlin-mui
//                implementation("org.jetbrains.kotlin-wrappers:kotlin-mui:5.2.7-pre.290-kotlin-1.6.10")

                implementation("io.ktor:ktor-client-core:$ktorVersion")
//                implementation("io.ktor:ktor-client-cio:$ktorVersion")
                implementation("io.ktor:ktor-client-js:$ktorVersion")
                implementation("io.ktor:ktor-client-json:$ktorVersion")
                implementation("io.ktor:ktor-client-serialization:$ktorVersion")

            }
        }
        val jsTest by getting {
            dependencies {
                implementation(kotlin("test-js"))
            }
        }
    }
}
