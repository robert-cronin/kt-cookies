/*
 * Copyright (C) 2019/2020 Robert Cronin
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.fortytwoapps.ktcookies.util

import com.fortytwoapps.ktcookies.CookieOptions
import kotlinx.serialization.UnstableDefault

external class Object

inline fun obj(init: dynamic.() -> Unit): dynamic {
    return (Object()).apply(init)
}

@UnstableDefault
internal fun CookieOptions.toJs(): dynamic {
    return obj {
        if (expires != null) this.expires = expires
        if (path != null) this.path = path
        if (domain != null) this.domain = domain
        if (secure != null) this.secure = secure
    }
}