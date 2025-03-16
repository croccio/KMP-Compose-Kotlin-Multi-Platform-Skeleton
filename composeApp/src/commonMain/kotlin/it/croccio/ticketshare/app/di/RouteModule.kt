package it.croccio.ticketshare.app.di

import androidx.compose.runtime.Composable
import it.croccio.compose.swipe.navigation.Route
import it.croccio.compose.swipe.navigation.Routes
import it.croccio.kdi.Module
import it.croccio.kdi.inject
import it.croccio.kdi.injectable.Bind
import it.croccio.ticketshare.app.navigation.route.TicketDetailRoute
import it.croccio.ticketshare.app.navigation.route.TicketMainRoute
import it.croccio.ticketshare.app.ui.screen.MainScreen
import it.croccio.ticketshare.app.ui.screen.TicketDetailScreen

class RouteModule : Module {

    override fun register() {
        inject(
            Bind<Routes, Routes> {
                object : Routes {
                    @Composable
                    override fun toScreen(route: Route) {
                        when (route) {
                            is TicketMainRoute -> MainScreen()
                            is TicketDetailRoute -> TicketDetailScreen(ticket = route.argument.ticket)
                            else -> throw IllegalStateException()
                        }
                    }

                }
            },
        )
    }
}