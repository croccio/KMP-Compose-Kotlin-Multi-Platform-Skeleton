package it.croccio.ticketshare.library.kdi.exception

class KDIException(clazz: Any) : RuntimeException("Cannot find dependency injection for $clazz")