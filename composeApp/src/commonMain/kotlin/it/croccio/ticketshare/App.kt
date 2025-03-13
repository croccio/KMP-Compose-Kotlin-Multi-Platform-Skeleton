package it.croccio.ticketshare

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import it.croccio.kdi.injectable.Singleton
import it.croccio.ticketshare.app.di.modules
import it.croccio.ticketshare.app.navigation.route.TicketMainRoute
import it.croccio.ticketshare.library.kcnavigation.Routes
import it.croccio.ticketshare.library.kcnavigation.createNavGraph
import it.croccio.ticketshare.library.kdi.inject
import it.croccio.ticketshare.library.kdi.injection
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    inject(*modules.toTypedArray())

    MaterialTheme {
        val routes by injection<Routes>()
        rememberNavController()
            .also { navHostController -> inject(Singleton { navHostController }) }
            .createNavGraph(TicketMainRoute, routes)

    }
}