# KcNavigation 🚀

KcNavigation (Kotlin Compose Navigation) implement a custom navigation system based on viewpager to
allow swipe-back navigation between screens.

## 📌 Usage

### 🔹 Defining Routes

Start by creating your routes. You can define routes with or without parameters.

✅ Route Without Parameters

```
data object RouteWithoutParameter : Route()
```

✅ Route With Parameters

```
data class RouteWithParameter(
    override val argument: Argument
) : RouteWithArgument(
    argument
) {
    class Argument(
        val property: String
    ) : RouteArgument()

}
```

### 🔹 Creating the NavGraph

After defining routes, create the navigation system and define a mapping between Route and your
Screen:

```
NavigationSystem(
    navigator = PagerNavigator(),
    starterPage = MainRoute,
    routes = object : Routes {
        @Composable
        override fun toScreen(route: Route) {
            when (route) {
                is TicketMainRoute -> MainScreen()
                is TicketDetailRoute -> TicketDetailScreen(ticket = route.argument.ticket)
                else -> throw IllegalStateException()
            }
        }

    }
)
```

### 🔥 Navigating Between Screens

To navigate between screens, use the navigate function from the Navigator, passing the target route
as a parameter.

✅ Navigating With Parameters

```
navigator.navigate(
    OtherRoute(
        parameter = RouteWithArgument.MyArgument(
            "Value of parameter"
        )
    )
)
```

✅ Navigating Without Parameters

```
navigator.navigate(
    OtherRouteWithoutPrameter()
)
```

### 🎯 Accessing Parameters in a Composable

Once navigated, use the parameters inside your Composable function:

```
@Composable
fun OtherRoute(
    param: String, //or your type
) {

    Scaffold {
        Column {
            Text("Item name: ${param}")
            Button(
                onClick = {}
            ) { }
        }
    }

}
```