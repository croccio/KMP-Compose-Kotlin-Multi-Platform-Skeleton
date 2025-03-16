package it.croccio.ticketshare.app.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import it.croccio.kdi.byInjection
import it.croccio.ticketshare.library.kcnavigation.Navigator

@Composable
fun TicketDetailScreen(
    navigator: Navigator = byInjection(),
    ticket: String,
) {

    Scaffold {
        Column {
            Text("Detail view")
            Text("Item name: $ticket")
            Button(
                onClick = {
                    navigator.popBackStack()
                }
            ) {
                Text("Go back")
            }
        }
    }

}