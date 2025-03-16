package it.croccio.ticketshare

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import it.croccio.kdi.byInjection
import it.croccio.kdi.inject
import it.croccio.ticketshare.app.di.modules
import it.croccio.ticketshare.app.navigation.route.TicketMainRoute
import it.croccio.ticketshare.library.kcnavigation.NavigationSystem
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    inject(*modules.toTypedArray())

    MaterialTheme {
        NavigationSystem(
            navigator = byInjection(),
            starterPage = TicketMainRoute,
            routes = byInjection()
        )
    }
}