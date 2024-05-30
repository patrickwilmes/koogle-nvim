/*
* Copyright (c) 2024, Patrick Wilmes <p.wilmes89@gmail.com>
* All rights reserved.
*
* SPDX-License-Identifier: BSD-2-Clause
*/

package com.bit.lake.koogle

import arrow.core.Either
import arrow.core.raise.either
import arrow.core.raise.ensure
import failure.Failure
import failure.trap
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction
import java.io.File

@JvmInline
value class ProjectName(val value: String)

data class Project(
    val name: ProjectName,
    val workingDirectory: File,
)

suspend fun registerProject(project: Project): Either<Failure, Unit> = either {
    ensure(project.workingDirectory.exists()) { Failure.NotFoundFailure("Working directory does not exist") }
    trap {
        transaction {
            ProjectTable.insert {
                it[name] = project.name.value
                it[workingDirectory] = project.workingDirectory.absolutePath
            }
        }
    }
}

internal object ProjectTable : Table(name = "project") {
    val name = text(name = "name")
    val workingDirectory = text(name = "working_directory")
}
