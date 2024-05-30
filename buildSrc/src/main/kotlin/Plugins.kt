/*
 * Copyright (c) 2024, Patrick Wilmes <p.wilmes89@gmail.com>
 * All rights reserved.
 *
 * SPDX-License-Identifier: BSD-2-Clause
 */

import org.gradle.kotlin.dsl.PluginDependenciesSpecScope
import org.gradle.kotlin.dsl.application
import org.gradle.kotlin.dsl.kotlin
import org.gradle.kotlin.dsl.version

private const val KotlinXSerialization = "org.jetbrains.kotlin.plugin.serialization"
private const val ShadowJar = "com.github.johnrengelman.shadow"
private const val KotlinJvm = "jvm"
private const val Dokka = "org.jetbrains.dokka"

fun PluginDependenciesSpecScope.applyApplicationPlugins() {
    application
    id(ShadowJar) version Versions.shadowJarVersion
}

fun PluginDependenciesSpecScope.applyCommonPlugins() {
    kotlin(KotlinJvm) version Versions.kotlinVersion
    id(KotlinXSerialization) version Versions.kotlinVersion
    id(Dokka) version Versions.dokkaVersion
}
