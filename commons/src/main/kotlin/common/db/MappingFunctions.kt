/*
 * Copyright (c) 2024, Patrick Wilmes <p.wilmes89@gmail.com>
 * All rights reserved.
 *
 * SPDX-License-Identifier: BSD-2-Clause
 */

package common.db

import org.jetbrains.exposed.sql.Query
import org.jetbrains.exposed.sql.ResultRow

fun <R> Query.mapToSet(transform: (ResultRow) -> R): Set<R> {
    val set = mutableSetOf<R>()
    forEach { element -> set.add(transform(element)) }
    return set
}
