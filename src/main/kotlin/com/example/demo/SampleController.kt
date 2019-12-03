package com.example.demo

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

@RestController
class SampleController (
    private val restTemplate: RestTemplate
) {
    /**
     * http://localhost:8080/java1?id=1&someEnum=SUCCESS
     * deserializing request param into javaClass: works as intended.
     */
    @RequestMapping("/java1")
    fun javaParam(javaClass: JavaClass) = javaClass

    /**
     * http://localhost:8080/java2
     * deserializing restTemplate response into javaClass: works as intended
     */
    @RequestMapping("/java2")
    fun javaRestTemplate() = restTemplate.postForObject("http://localhost:8080/api", mapOf<String, String>(), JavaClass::class.java)

    /**
     * http://localhost:8080/kotlin1?id=1&someEnum=SUCCESS
     * deserializing request param into kotlin Class without constructor: works as intended
     */
    @RequestMapping("/kotlin1")
    fun kotlinNoConstructorParam(kotlinClassNoConstructor: KotlinClassNoConstructor) = kotlinClassNoConstructor

    /**
     * http://localhost:8080/kotlin1?id=2&someEnum=SUCCESS
     * deserializing request param into kotlin class with constructor: works as intended
     */
    @RequestMapping("/kotlin2")
    fun kotlinParam(kotlinClassWithConstructor: KotlinClassWithConstructor) = kotlinClassWithConstructor

    /**
     * http://localhost:8080/kotlin3
     * deserializing restTemplate response into kotlin class without constructor: works as intended
     */
    @RequestMapping("/kotlin3")
    fun kotlinRestTemplateNoConstructor(kotlinClassNoConstructor: KotlinClassNoConstructor) = restTemplate.postForObject("http://localhost:8080/api", mapOf<String, String>(), KotlinClassNoConstructor::class.java)

    /**
     * http://localhost:8080/kotlin4
     * deserializing restTemplate response into kotlin class with constructor: DOESN'T WORK
     */
    @RequestMapping("/kotlin4")
    fun kotlinRestTemplateWithConstructor(kotlinClassWithConstructor: KotlinClassWithConstructor) = restTemplate.postForObject("http://localhost:8080/api", mapOf<String, String>(), KotlinClassWithConstructor::class.java)

    @RequestMapping("/api")
    fun api() = KotlinClassWithConstructor().apply {
        id = 999
        someEnum = SomeEnum.SUCCESS
    }
}