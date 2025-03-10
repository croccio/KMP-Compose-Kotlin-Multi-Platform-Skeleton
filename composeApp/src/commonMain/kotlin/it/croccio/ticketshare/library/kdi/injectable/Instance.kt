package it.croccio.ticketshare.library.kdi.injectable

sealed interface Instance<in T, out U> {

    fun get(): U

}