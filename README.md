[ ![Download](https://api.bintray.com/packages/robert-cronin/fortytwoapps/kt-cookies/images/download.svg) ](https://bintray.com/robert-cronin/fortytwoapps/kt-cookies/_latestVersion)
[![Build Status](https://travis-ci.org/fortytwoapps/kt-cookies.svg?branch=master)](https://travis-ci.org/fortytwoapps/kt-cookies)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
# KT-Cookies
Based on an awesome cookie management library in JavaScript, [js-cookie](https://github.com/js-cookie/js-cookie), KT-Cookies allows you to manipulate cookies in an Object Oriented, KotlinJS environment and also define custom classes to give your cookie structure.

## Getting Started

### Development
You can explore the source code either by browsing this repo or downloading KT-Cookies from GitHub:
```
git clone https://github.com/fortytwoapps/kt-cookies.git
```

### Prerequisites

To setup KT-Cookies and start using it in your project, add these lines to build.gradle :
What things you need to install the software and how to install them

```
Give examples
```

### Installing

To setup KT-Cookies, add these lines to build.gradle:

```
repositories {
    maven { url = "https://dl.bintray.com/robert-cronin/fortytwoapps" }
}

dependencies {
    implementation "fortytwoapps:kt-cookies:0.0.2"
}
```
To start using KT-Cookies in a project, simply import like this:

```kotlin
import com.fortytwoapps.ktcookies.*
```

If you are familiar with [js-cookie](https://github.com/js-cookie/js-cookie), you can still manipulate cookies in much the same way:

Create a cookie, valid across the entire site:

```kotlin
Cookies.set("name", "value")
```

Create a cookie that expires 7 days from now, valid across the entire site:

```kotlin

Cookies.set("name", "value", CookieOptions(expires = 7))
```

Create an expiring cookie, valid to the path of the current page:

```kotlin
Cookies.set("name", "value", CookieOptions(
        expires  = 7,
        path = " "
))
```

Read cookie:

```kotlin
val name = Cookies.get("name") // => 'value'
val nothing = Cookies.get("nothing") // => undefined
```

Read all visible cookies:

```kotlin
val cookie = Cookies.get() // => { name: 'value' }
```

As you can see, KT-Cookies can be used in much the same way as the underlying dependency. In addition, KT-Cookies also lets you define a custom class and use that as the cookie:

```kotlin
@Serializable
class UserData(var name: String, var favouriteDomain: String)
....
Cookies.setClass("userData", UserData("John Doe", "/jane/doe"))
val userData = Cookies.getClass<UserData>("userData") // => UserData("John Doe", "/jane/doe")
console.log(userData.name) // => "John Doe"
console.log(userData.favouriteDomain) // => "/jane/doe"
```

Note: ensure your custom class is marked with @Serializable, this is required for Json parsing purposes.

## Built With

* [js-cookie](https://github.com/js-cookie/js-cookie) - The underlying JavaScript library used
* [Travis CI](https://travis-ci.org/) - Continuous Integration
* [Gradle](https://gradle.org/) - Dependency Management

## Contributing

Feel free to contribute if you feel this wrapper is lacking for your application. Contributions are open.

## Authors

* **Robert Cronin** - *Initial work* - [robert-cronin](https://github.com/robert-cronin)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Hat tip goes to developers of js-cookie, an awesome library
* Template for this readme came from [PurpleBooth](https://github.com/PurpleBooth)
