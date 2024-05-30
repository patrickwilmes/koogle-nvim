/*
 * Copyright (c) 2024, Patrick Wilmes <p.wilmes89@gmail.com>
 * All rights reserved.
 *
 * SPDX-License-Identifier: BSD-2-Clause
 */

plugins {
    id("base")
}

val homePath = System.getenv("HOME")
val nvimPluginDir = "$homePath/.config/nvim/lua/koogle"

tasks.register<Copy>("installLuaPlugin") {
    group = "build"
    description = "Installs the Lua plugin to Neovim"

    from(file("src"))

    into(file(nvimPluginDir))

    doFirst {
        file(nvimPluginDir).mkdirs()
    }

    doLast {
        println("Lua plugin installed to $nvimPluginDir")
    }
}

tasks.register<Delete>("cleanLuaPlugin") {
    group = "build"
    description = "Cleans the installed Lua plugin"

    delete(file(nvimPluginDir))
}
