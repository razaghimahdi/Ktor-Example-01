# Ktor-Example-01
## Developed by Mahdi Razzaghi Ghaleh
**my first connection network ktor app, which is show how Ktor is easy to use**


### What is Ktor?
Ktor is an asynchronous open source framework for creating microservices and web applications. 
It was developed with Kotlin by Jetbrains.
It’s easy to install and use, and i will show that to you :). 
It's asynchronous property allows it to receive multiple requests by coroutines.

### Multiplatform
Ktor is multiplatform,
It means that we can deploy Ktor applications anywhere,
you can use it for your server or on your android/ios client or even JS!!
Ktor Client allows you to make requests and handle responses, extend its functionality with features,
such as authentication, JSON serialization, and ...

### Why Ktor?
**Kotlin and Coroutines**
Ktor is built from the ground up using Kotlin and Coroutines. 
You get to use a concise, multiplatform language, 
as well as the power of asynchronous programming with an intuitive imperative flow.

**Lightweight and Flexible**
Ktor allows you to use only what you need, 
and to structure your application the way you need it.
In addition you can also extend Ktor with your own plugin very easily.


**look at these examples:**

```kotlin

    /**
     * HttpClient:
     * Constructs an asynchronous HttpClient using the specified engineFactory
     * and an optional block for configuring this client.
     * which means if u want to use in IOS
     * Just replace Android with Ios
     */
    
    /**
     * install:
     * Installs a specific feature and optionally configure it.
     * exp:
     **/ 
        serializer=KotlinxSerializer(
        kotlinx.serialization.json.Json {
        ignoreUnknownKeys=true // if server send extra fields just ignore
            }
         )
      
    
    
    private val clientAndroid = HttpClient(Android) {
        install(JsonFeature) {
            serializer = GsonSerializer()
        }
    }


    private val clientIos = HttpClient(Ios) {
        install(JsonFeature) {
            serializer = GsonSerializer()
        }
    }



```





#### API:
**https://randomuser.me/**

#### Some Ideas:
**https://ktor.io**

**https://ktor.io/learn/**