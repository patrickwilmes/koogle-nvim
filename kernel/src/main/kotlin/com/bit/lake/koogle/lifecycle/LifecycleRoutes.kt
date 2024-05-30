/*
 * Copyright (c) 2024, Patrick Wilmes <p.wilmes89@gmail.com>
 * All rights reserved.
 *
 * SPDX-License-Identifier: BSD-2-Clause
 */

package com.bit.lake.koogle.lifecycle

import arrow.core.raise.either
import com.bit.lake.koogle.Project
import com.bit.lake.koogle.registerProject
import common.http.respondWithServerFailure
import common.receiveObject
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.routing.post
import io.ktor.server.routing.route
import io.ktor.server.routing.routing

fun Application.installLifecycleRoutes() {
    routing {
        route("/lifecycle") {
            post("/initialize") {
                either {
                    val project = receiveObject<Project>().bind()
                    registerProject(project)
                }.fold({
                    respondWithServerFailure(it)
                }) {
                    call.respond(HttpStatusCode.Accepted)
                }
            }
        }
    }
}
