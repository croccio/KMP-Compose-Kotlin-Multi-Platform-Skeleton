package it.croccio.ticketshare.app.di

import androidx.navigation.NavGraphBuilder
import it.croccio.ticketshare.app.navigation.route.TicketMainRoute
import it.croccio.ticketshare.app.navigation.route.TicketDetailRoute
import it.croccio.ticketshare.app.ui.screen.MainScreen
import it.croccio.ticketshare.app.ui.screen.TicketDetailScreen
import it.croccio.ticketshare.library.kdi.Module
import it.croccio.ticketshare.library.kdi.inject
import it.croccio.ticketshare.library.kdi.injectable.Bind
import it.croccio.ticketshare.library.kcnavigation.Routes
import it.croccio.ticketshare.library.kcnavigation.route

class RouteViewModule : Module {

    override fun register() {
        inject(
            Bind<Routes, Routes> {
                object : Routes {
                    override fun injectRoutes(navGraphBuilder: NavGraphBuilder) {
                        navGraphBuilder.route(TicketMainRoute::class) { MainScreen() }
                        navGraphBuilder.route<TicketDetailRoute.Argument>(TicketDetailRoute::class) { TicketDetailScreen(it) }
                    }
                }
            },
        )
    }

}