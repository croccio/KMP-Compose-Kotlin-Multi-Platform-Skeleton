package it.croccio.ticketshare.library.kdi

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class InjectDelegation<T>(val instance: T) : ReadOnlyProperty<Any?, T> {

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return instance
    }

}