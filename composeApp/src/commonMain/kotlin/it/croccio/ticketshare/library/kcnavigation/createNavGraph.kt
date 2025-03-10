package it.croccio.ticketshare.library.kcnavigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import it.croccio.ticketshare.library.kdi.injection
import kotlinx.serialization.json.Json
import kotlin.reflect.KClass

@Composable
fun NavHostController.createNavGraph(startRoute: Route, routes: Routes) {
    NavHost(
        navController = this,
        startDestination = startRoute.toPath()
    ) {
        routes.injectRoutes(this)
    }
}

inline fun NavGraphBuilder.route(
    route: KClass<out Route>,
    crossinline screen: @Composable () -> Unit,
) {
    composable(route = "${route.simpleName}") { screen() }
}

inline fun <reified ARGUMENT_TYPE : RouteArgument> NavGraphBuilder.route(
    route: KClass<out RouteWithParameter>,
    crossinline screen: @Composable (ARGUMENT_TYPE) -> Unit,
) {
    composable(
        route = "${route.simpleName}/{parameter}",
        arguments = listOf(navArgument("parameter") { type = NavType.StringType })
    ) { backStackEntry ->
        backStackEntry
            .arguments
            ?.getString("parameter")
            ?.let { parameter ->
                screen(Json.decodeFromString(parameter))
            }
    }
}