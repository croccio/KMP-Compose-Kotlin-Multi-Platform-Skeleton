package it.croccio.ticketshare.app.navigation.route

import it.croccio.ticketshare.library.kcnavigation.Route
import it.croccio.ticketshare.library.kcnavigation.RouteArgument
import it.croccio.ticketshare.library.kcnavigation.RouteWithParameter
import kotlinx.serialization.Serializable

@Serializable
data object TicketMainRoute : Route()

@Serializable
data class TicketDetailRoute(
    val ticket: Argument
) : RouteWithParameter(ticket) {

    @Serializable
    class Argument(
        val name: String,
    ): RouteArgument()

}