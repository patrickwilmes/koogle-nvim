/*
 * Copyright (c) 2024, Patrick Wilmes <p.wilmes89@gmail.com>
 * All rights reserved.
 *
 * SPDX-License-Identifier: BSD-2-Clause
 */

package identifier

enum class Domain {
    Undefined,
}

fun determineDomainFromUrnString(urnString: String): Domain =
    urnString.split(":")[1].let { domainPart ->
        domainPart.replaceFirstChar { firstChar -> firstChar.titlecaseChar() }
            .let { upperCasedDomainPart ->
                Domain.entries.first { it.name.lowercase() == upperCasedDomainPart.lowercase() }
            }
    }
