Run DemoApplication.kt main().  

Check http://localhost:8080/kotlin4 - it fails only in an unique scenario of deserializing Kotlin class that has a non-field constructor parameter of type Enum, while the identical Java class dooesn't share the issue.  
Moreover, request parameter deserialization works normally - RestTemplate deserialization is the only issue although they supposedly use the same Jackson converter...  

The controller shows how RestTemplate deserialization exclusively fails on Kotlin class that have constructor parameters of Enum type that aren't fields.  
That is,
```
class Foo(
    tempVar: Long? = null
) {
    var id: Long
}
```
deserializes normally while below doesn't work.
```
class Bar(
    tempVar: SomeEnum? = null
) {
    var id: Long
}
```