/*
 * Copyright (c) 2024, Patrick Wilmes <p.wilmes89@gmail.com>
 * All rights reserved.
 *
 * SPDX-License-Identifier: BSD-2-Clause
 */

package common.file

import arrow.core.Either
import failure.Failure
import failure.trap
import java.io.File

suspend fun String.asFileWithName(name: String): Either<Failure, File> =
    trap(contextName = String::asFileWithName.name) {
        val rootDir = File(this)
        if (!rootDir.exists()) rootDir.mkdir()
        if (endsWith(File.separator) && name.startsWith(File.separator)) {
            File(this + name.removePrefix(File.separator))
        } else if (endsWith(File.separator) && !name.startsWith(File.separator)) {
            File(this + name)
        } else {
            File(this + File.separator + name)
        }
    }
