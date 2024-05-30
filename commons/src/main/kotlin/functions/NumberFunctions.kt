/*
 * Copyright (c) 2024, Patrick Wilmes <p.wilmes89@gmail.com>
 * All rights reserved.
 *
 * SPDX-License-Identifier: BSD-2-Clause
 */

package functions

fun UShort.formatWithZeroPrefix(totalLength: UShort = 2U): String =
    toString().padStart(totalLength.toInt(), '0')

fun UInt.formatWithZeroPrefix(totalLength: UShort = 2U): String =
    toString().padStart(totalLength.toInt(), '0')

fun Int.formatWithZeroPrefix(totalLength: UShort = 2U): String =
    toString().padStart(totalLength.toInt(), '0')
