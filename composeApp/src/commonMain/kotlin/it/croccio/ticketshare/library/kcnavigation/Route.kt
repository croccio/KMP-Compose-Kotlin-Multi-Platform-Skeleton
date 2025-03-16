package it.croccio.ticketshare.library.kcnavigation

open class RouteArgument

abstract class Route

abstract class RouteWithArgument(
    open val argument: RouteArgument
) : Route()