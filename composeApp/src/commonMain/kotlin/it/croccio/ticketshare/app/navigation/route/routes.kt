package it.croccio.ticketshare.app.navigation.route

import it.croccio.ticketshare.library.kcnavigation.Route
import it.croccio.ticketshare.library.kcnavigation.RouteArgument
import it.croccio.ticketshare.library.kcnavigation.RouteWithArgument


data object TicketMainRoute : Route()

data class TicketDetailRoute(
    override val argument: Argument
) : RouteWithArgument(
    argument
) {
    class Argument(
        val ticket: String
    ) : RouteArgument()

}