package it.croccio.ticketshare.app.di

import it.croccio.kdi.Module

val modules = setOf<Module>(
    AppModule(),
    RouteModule(),
)