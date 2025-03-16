package it.croccio.ticketshare.app.di

import it.croccio.kdi.Module
import it.croccio.kdi.inject
import it.croccio.kdi.injectable.BindSingleton
import it.croccio.ticketshare.library.kcnavigation.Navigator
import it.croccio.ticketshare.library.kcnavigation.PagerNavigator

class AppModule : Module {

    override fun register() {
        inject(
            BindSingleton<Navigator, PagerNavigator> { PagerNavigator() }
        )
    }
}