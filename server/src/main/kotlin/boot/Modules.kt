/*
 * Copyright (c) 2024, Patrick Wilmes <p.wilmes89@gmail.com>
 * All rights reserved.
 *
 * SPDX-License-Identifier: BSD-2-Clause
 */

package boot

import com.bit.lake.koogle.lifecycle.installLifecycleRoutes
import com.bit.lake.koogle.registerKoogleTables
import io.ktor.server.application.Application
import io.ktor.server.application.install
import koin.GlobalKoinContext
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

fun Application.modules() {
    configure(isDevelopmentMode = booleanConfigValue(ConfigurationValue.DevelopmentMode))
    install(Koin) {
        slf4jLogger()
        val app = modules()
        GlobalKoinContext.koin = app.koin
    }
    connectToDatabase()
    registerKoogleTables()
    installRoutes()
}

private fun Application.installRoutes() {
    installLifecycleRoutes()
}
