package it.croccio.ticketshare.app.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import it.croccio.compose.swipe.navigation.Navigator
import it.croccio.kdi.byInjection
import it.croccio.ticketshare.app.navigation.route.TicketDetailRoute

@Composable
fun MainScreen(navigator: Navigator = byInjection()) {

    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text("Home view")
            Button(
                onClick = {
                    navigator.navigate(
                        TicketDetailRoute(argument = TicketDetailRoute.Argument("ticket 1"))
                    )
                }
            ) {
                Text("Go to Item 1")
            }
            Button(
                onClick = {
                    navigator.navigate(
                        TicketDetailRoute(argument = TicketDetailRoute.Argument("ticket 2"))
                    )
                }
            ) {
                Text("Go to Item 2")
            }
        }
    }

}