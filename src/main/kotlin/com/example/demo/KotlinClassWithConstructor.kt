package com.example.demo

/**
 * If a constructor has a non-field enum parameter, Kotlin class cannot be deserialized from RestTemplate response even if it has a noarg constructor(note that parameter has default value, which creates a noarg constructor)
 * This only happens with Kotlin classes.
 */
class KotlinClassWithConstructor(
    _someEnum: SomeEnum? = null
) {
    var id: Long? = null
    var someEnum: SomeEnum? = null
}