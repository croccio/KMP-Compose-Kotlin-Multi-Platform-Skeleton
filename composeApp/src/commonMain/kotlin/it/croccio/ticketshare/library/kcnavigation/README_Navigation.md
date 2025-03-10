# KcNavigation 🚀

KcNavigation (Kotlin Compose Navigation) simplifies the usage of JetBrains' navigation system. Currently, an older version is used due to compatibility issues with web applications that prevent startup.

## 📌 Usage
### 🔹 Defining Routes
Start by creating your routes. You can define routes with or without parameters.

✅ Route Without Parameters
```
@Serializable
data object RouteWithoutParameter : Route()
```

✅ Route With Parameters
```
@Serializable
data class RouteWithParameter(
    val parameter: MyParameter
) : RouteWithParameter(ticket) {

    @Serializable
    class MyParameter(
        val prop: String,
    ): RouteArgument()

}
```

### 🔹 Creating the NavGraph
After defining routes, set up the NavGraph using createNavGraph on your NavHostController instance:
```
rememberNavController()
    .createNavGraph(startRoute = MainRoute, routes = routes)
```

### 🔥 Navigating Between Screens
To navigate between screens, use the navigate function from navController, passing the target route as a parameter.

✅ Navigating With Parameters
```
navController.navigate(
    OtherRoute(
        parameter = RouteWithParameter.MyParameter(
            "Value of parameter"
        )
    ).toPath<RouteWithParameter.MyParameter>()
)
```

✅ Navigating Without Parameters
```
navController.navigate(
    OtherRouteWithoutPrameter().toPath()
)
```

### 🎯 Accessing Parameters in a Composable
Once navigated, use the parameters inside your Composable function:
```
@Composable
fun OtherRoute(
    : RouteWithParameter.MyParameter,
) {

    val navController: NavHostController by injection()

    Scaffold {
        Column {
            Text("Item name: ${parameter.prop}")
            Button(
                onClick = {
                    navController.popBackStack()
                }
            ) {
                Text("Go back")
            }
        }
    }

}
```