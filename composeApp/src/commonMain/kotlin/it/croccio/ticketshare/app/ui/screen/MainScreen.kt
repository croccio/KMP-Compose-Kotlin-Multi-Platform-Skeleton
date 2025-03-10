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
import androidx.navigation.NavHostController
import it.croccio.ticketshare.app.navigation.route.TicketDetailRoute
import it.croccio.ticketshare.library.kdi.injection
import it.croccio.ticketshare.library.kcnavigation.toPath

@Composable
fun MainScreen() {

    val navController: NavHostController by injection()

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
                    navController.navigate(
                        TicketDetailRoute(
                            ticket = TicketDetailRoute.Argument(
                                "Ticket 1"
                            )
                        ).toPath<TicketDetailRoute.Argument>()
                    )
                }
            ) {
                Text("Go to Item 1")
            }
            Button(
                onClick = {
                    navController.navigate(
                        TicketDetailRoute(
                            ticket = TicketDetailRoute.Argument(
                                "Ticket 2"
                            )
                        ).toPath<TicketDetailRoute.Argument>()
                    )
                }
            ) {
                Text("Go to Item 2")
            }
        }
    }

}