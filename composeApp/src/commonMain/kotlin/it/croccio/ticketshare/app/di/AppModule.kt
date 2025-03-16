package it.croccio.ticketshare.app.di

import it.croccio.compose.swipe.navigation.Navigator
import it.croccio.compose.swipe.navigation.PagerNavigator
import it.croccio.kdi.Module
import it.croccio.kdi.inject
import it.croccio.kdi.injectable.BindSingleton

class AppModule : Module {

    override fun register() {
        inject(
            BindSingleton<Navigator, PagerNavigator> { PagerNavigator() }
        )
    }
}