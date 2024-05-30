/*
 * Copyright (c) 2024, Patrick Wilmes <p.wilmes89@gmail.com>
 * All rights reserved.
 *
 * SPDX-License-Identifier: BSD-2-Clause
 */

package boot

import io.ktor.server.application.Application
import org.jetbrains.exposed.sql.Database

fun Application.connectToDatabase() {
    val dbUrl = (configValue(ConfigurationValue.DatabaseUrl) as Value.StringValue).value
    Database.connect(
        url = dbUrl,
        driver = "org.sqlite.JDBC",
    )
}
