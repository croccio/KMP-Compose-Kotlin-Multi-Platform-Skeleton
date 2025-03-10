# KDI - Kotlin Dependency Injection 🚀
KDI (Kotlin Dependency Injection) allows you to inject dependencies dynamically, without annotations, and with maximum flexibility.

## 📌 Usage
### 🔹 Defining an Injection
First, create your own module:
```
class MyModule : Module {
    override fun register() {
        // Define your injections here
    }
}
```

Inside the register method, specify the dependencies you want to inject:
```
override fun register() {
    inject(
        Provide { MyClassA() },
        Provide { MyClassB() },
        // Add more dependencies as needed
    )
}
```

### 🔹 Registering Your Module
After defining your module, you need to register it—typically when your app starts:
```
inject(yourModule)
```

Additionally, you can inject instances at runtime:
```
inject(Singleton { yourInstance })
```

### 🔥 Using the Injected Dependencies
To access an injected dependency, use the by injection() delegate:
```
val myInstance: MyClassA by injection()
```

### ⚡ Injection Types
KDI provides multiple ways to inject dependencies:
- Provide → Creates a new instance every time it's injected.
- Singleton → Injects the same instance throughout the application.
- Bind → Maps an interface to a specific implementation.
This makes dependency management in Kotlin simple, flexible, and annotation-free! 🚀
New types will be added soon!