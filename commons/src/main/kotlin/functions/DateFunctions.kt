/*
 * Copyright (c) 2024, Patrick Wilmes <p.wilmes89@gmail.com>
 * All rights reserved.
 *
 * SPDX-License-Identifier: BSD-2-Clause
 */

package functions

import kotlinx.datetime.LocalDate

fun LocalDate.format() =
    "${dayOfMonth.formatWithZeroPrefix()}.${monthNumber.formatWithZeroPrefix()}.$year"
