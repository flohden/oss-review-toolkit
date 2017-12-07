/*
 * Copyright (c) 2017 HERE Europe B.V.
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

package com.here.ort.downloader.vcs

import io.kotlintest.matchers.shouldBe
import io.kotlintest.matchers.shouldNotBe
import io.kotlintest.specs.StringSpec

class GitTest : StringSpec() {
    init {
        "Detected Git version is not empty" {
            val version = Git.getVersion()
            println("Git version $version detected.")
            version shouldNotBe ""
        }

        "Git correctly detects URLs to remote repositories" {
            // Bitbucket forwards to ".git" URLs for Git repositories, so we can omit the suffix.
            Git.isApplicableUrl("https://bitbucket.org/yevster/spdxtraxample") shouldBe true

            Git.isApplicableUrl("https://bitbucket.org/paniq/masagin") shouldBe false
        }
    }
}
