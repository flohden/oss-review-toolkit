/*
 * Copyright (C) 2017-2019 HERE Europe B.V.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 * License-Filename: LICENSE
 */

package org.ossreviewtoolkit.utils

/**
 * Continuous-Integration-specific utility functions.
 */
object Ci {
    val isAppVeyor = listOf("APPVEYOR", "CI").all { Os.env[it].isTrue() }
    val isAzure = Os.env["TF_BUILD"].isTrue()
    val isAzureLinux = isAzure && Os.env["AGENT_OS"] == "Linux"
    val isAzureWindows = isAzure && Os.env["AGENT_OS"] == "Windows_NT"
    val isTravis = listOf("TRAVIS", "CI").all { Os.env[it].isTrue() }
}
