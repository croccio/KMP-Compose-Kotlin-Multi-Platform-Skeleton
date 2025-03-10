package it.croccio.ticketshare.app.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import it.croccio.ticketshare.app.navigation.route.TicketDetailRoute
import it.croccio.ticketshare.library.kdi.injection

@Composable
fun TicketDetailScreen(
    ticket: TicketDetailRoute.Argument,
) {

    val navController: NavHostController by injection()

    Scaffold {
        Column {
            Text("Detail view")
            Text("Item name: ${ticket.name}")
            Button(
                onClick = {
                    navController.popBackStack()
                }
            ) {
                Text("Go back")
            }
        }
    }

}