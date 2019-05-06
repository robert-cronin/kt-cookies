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

package com.fortytwoapps.ktcookies

import com.fortytwoapps.ktcookies.js.JsManager
import com.fortytwoapps.ktcookies.util.toJs
import kotlinx.serialization.ImplicitReflectionSerializer
import kotlinx.serialization.UnstableDefault
import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer

class Cookies {
    companion object {
        private val jsCookie = JsManager.getConstructor()

        fun set(name: dynamic, value: dynamic): dynamic {
            return jsCookie.asDynamic().set(name, value)
        }

        fun set(name: dynamic, value: dynamic, options: CookieOptions): dynamic {
            return jsCookie.asDynamic().set(name, value, options.toJs())
        }

        fun get(name: dynamic, options: CookieOptions): dynamic {
            return jsCookie.asDynamic().get(name, options.toJs())
        }

        fun get(name: dynamic): dynamic {
            return jsCookie.asDynamic().get(name)
        }

        fun get(): dynamic {
            return jsCookie.asDynamic().get()
        }

        fun remove(name: String, options: CookieOptions): dynamic {
            return jsCookie.asDynamic().remove(name, options.toJs())
        }

        fun remove(name: String): dynamic {
            return jsCookie.asDynamic().remove(name)
        }

        fun remove(): dynamic {
            return jsCookie.asDynamic().remove()
        }

        // Class functions
        @UnstableDefault
        @Suppress("NON_PUBLIC_CALL_FROM_PUBLIC_INLINE")
        @UseExperimental(ImplicitReflectionSerializer::class)
        inline fun <reified T : Any> getClass(name: String): T {
            return Json.parse(
                T::class.serializer(),
                jsCookie.asDynamic().get(name) as String
            )
        }
        @UnstableDefault
        @Suppress("NON_PUBLIC_CALL_FROM_PUBLIC_INLINE")
        @UseExperimental(ImplicitReflectionSerializer::class)
        inline fun <reified T : Any> getClass(name: String, options: CookieOptions): T {
            return Json.parse(
                T::class.serializer(),
                jsCookie.asDynamic().get(name, options.toJs()) as String
            )
        }

        @UnstableDefault
        @Suppress("NON_PUBLIC_CALL_FROM_PUBLIC_INLINE")
        @UseExperimental(ImplicitReflectionSerializer::class)
        inline fun <reified T : Any> setClass(name: String, value: T): T {
            return Json.parse(
                T::class.serializer(),
                jsCookie.asDynamic().set(name, Json.stringify(T::class.serializer(), value)) as String
            )
        }

        @UnstableDefault
        @Suppress("NON_PUBLIC_CALL_FROM_PUBLIC_INLINE")
        @UseExperimental(ImplicitReflectionSerializer::class)
        inline fun <reified T : Any> setClass(name: String, value: T, options: CookieOptions): T {
            return Json.parse(
                T::class.serializer(),
                jsCookie.asDynamic().set(name, Json.stringify(T::class.serializer(), value), options.toJs()) as String
            )
        }
    }

}