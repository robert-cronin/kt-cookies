package test.com.rcronin.kookies

import com.rcronin.kcookies.CookieOptions
import com.rcronin.kcookies.Cookies
import kotlinx.serialization.*

@Serializable
class TestClass(val name: String, val someBool: Boolean)

fun main(args: Array<String>){
    val someTestClass = TestClass("abcd", true)
    console.log(
        CookieOptions(
        expires = 10,
        path = "/",
        secure = true
    )
    )
    val cookie = Cookies.set(
        "expiration", someTestClass, CookieOptions(
            expires = 10,
            secure = true
        )
    )


    print(cookie)

    val stringednamecookie = Cookies.set("stringedname", "SomeString")
    console.log(stringednamecookie)

    val stringedClass = Cookies.get()
    console.log(stringedClass)

    val someTestClass2 = TestClass("someName", false)
    val cookie2 = Cookies.set("cookie2", someTestClass2)
    try {
        val testClass = Cookies.getClass<TestClass>("cookie2")
        console.log(testClass)
        console.log(testClass.name)
        console.log(testClass.someBool)
    } catch (e: Exception) {
        console.log(e)
    }
}