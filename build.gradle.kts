import org.jetbrains.compose.compose

plugins {
    kotlin("multiplatform") version "1.6.21"
    id("org.jetbrains.compose") version "1.2.0-alpha01-dev675"
    kotlin("plugin.serialization") version "1.6.10"

}

group = "dev.nasonov"
version = "0.1"
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
                implementation(npm("opensheetmusicdisplay", "1.4.3", false))
                implementation("app.softwork:bootstrap-compose:0.0.51")

            }
        }
        val jsTest by getting {
            dependencies {
                implementation(kotlin("test-js"))
            }
        }
    }
}
rootProject.plugins.withType<org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootPlugin> {
    rootProject.the<org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension>().nodeVersion = "16.0.0"
}
