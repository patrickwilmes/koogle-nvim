/*
 * Copyright (c) 2024, Patrick Wilmes <p.wilmes89@gmail.com>
 * All rights reserved.
 *
 * SPDX-License-Identifier: BSD-2-Clause
 */

package boot

import io.ktor.server.netty.Netty
import kotlinx.coroutines.Job
import kotlinx.coroutines.runBlocking
import server
import kotlin.time.Duration.Companion.seconds

fun main(): Unit = runBlocking {
    val engine  = server(Netty, preWait = 1.seconds)
    val engineJob = Job().apply {
        invokeOnCompletion { }
    }
    engine.application.modules()
}
