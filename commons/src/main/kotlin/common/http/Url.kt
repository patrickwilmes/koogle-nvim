/*
 * Copyright (c) 2024, Patrick Wilmes <p.wilmes89@gmail.com>
 * All rights reserved.
 *
 * SPDX-License-Identifier: BSD-2-Clause
 */

package common.http

import io.ktor.server.application.ApplicationCall
import io.ktor.server.application.call
import io.ktor.util.pipeline.PipelineContext

fun PipelineContext<Unit, ApplicationCall>.buildUrlForPath(path: String) =
    "${assembleHostUrlPart()}$path"

fun PipelineContext<Unit, ApplicationCall>.assembleHostUrlPart() = with(call.request.local) {
    "$scheme://$serverHost:$serverPort"
}
