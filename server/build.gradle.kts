/*
 * Copyright (c) 2024, Patrick Wilmes <p.wilmes89@gmail.com>
 * All rights reserved.
 *
 * SPDX-License-Identifier: BSD-2-Clause
 */

plugins {
    applyApplicationPlugins()
    applyCommonPlugins()
}

group = "com.bit.lake"
version = "1.0-SNAPSHOT"

application {
    mainClass.set("boot.ApplicationKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    jcenter()
    mavenCentral()
}

dependencies {
    applyKtorEssentials()
    applyArrowEssentials()
    applyKoinEssentials()
    applyExposedEssentials()
    implementation(CoreDependencies.kotlinXDateTime)
    implementation(CoreDependencies.kotlinXCoroutines)
    implementation(CoreDependencies.logbackClassic)
    implementation(CoreDependencies.caffeine)
    implementation(project(":commons"))
    implementation(project(":kernel"))
    dokkaGfmPlugin(CoreDependencies.dokka)

    testImplementation(TestDependencies.assertK)
    testImplementation(TestDependencies.ktorServerTestsJVM)
    testImplementation(TestDependencies.kotlinTestJUnit)
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xcontext-receivers")
    }
}

tasks.dokkaHtml.configure {
    dokkaSourceSets {
        configureEach {
            val docsRoot = "$rootDir/docs/packages"
            includes.from()
        }
    }
}
