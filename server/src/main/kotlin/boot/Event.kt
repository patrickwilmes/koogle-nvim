/*
 * Copyright (c) 2024, Patrick Wilmes <p.wilmes89@gmail.com>
 * All rights reserved.
 *
 * SPDX-License-Identifier: BSD-2-Clause
 */

package boot

import io.ktor.events.EventDefinition
import io.ktor.server.application.Application

val InvalidateIndicesAndDirectoriesEvent: EventDefinition<Application> = EventDefinition()

fun <T> Application.raise(eventDefinition: EventDefinition<T>, value: T): Unit =
    environment.monitor.raise(eventDefinition, value)
