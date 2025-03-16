package it.croccio.ticketshare.app.navigation.route

import it.croccio.compose.swipe.navigation.Route
import it.croccio.compose.swipe.navigation.RouteArgument
import it.croccio.compose.swipe.navigation.RouteWithArgument


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