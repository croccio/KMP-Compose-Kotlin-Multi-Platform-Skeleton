package it.croccio.ticketshare.library.kcnavigation

import androidx.compose.runtime.Composable

open class RouteArgument

abstract class Route

abstract class RouteWithArgument(
    open val argument: RouteArgument
) : Route()

interface Routes {

    @Composable
    fun toScreen(route: Route)

}