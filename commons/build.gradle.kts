/*
 * Copyright (c) 2024, Patrick Wilmes <p.wilmes89@gmail.com>
 * All rights reserved.
 *
 * SPDX-License-Identifier: BSD-2-Clause
 */

plugins {
    applyCommonPlugins()
}

group = "com.bit.lake"
version = "1.0-SNAPSHOT"

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
