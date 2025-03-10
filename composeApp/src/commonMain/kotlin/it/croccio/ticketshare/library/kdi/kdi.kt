package it.croccio.ticketshare.library.kdi

import it.croccio.ticketshare.library.kdi.exception.KDIException
import it.croccio.ticketshare.library.kdi.injectable.Instance


@PublishedApi
internal val injections = mutableMapOf<String, Instance<*, *>>()

@PublishedApi
internal inline fun <reified T> findInjection(): T where T : Any =
    injections[T::class.toString()]
        ?.run { get() as T }
        ?: throw KDIException(T::class)

inline fun <reified T> inject(vararg instances: Instance<T, *>) where T : Any {
    instances
        .forEach { instance -> injections[T::class.toString()] = instance }
}

fun <T> inject(vararg modules: T) where T : Module {
    modules
        .forEach { module -> module.register() }
}

inline fun <reified T : Any> injection() =
    InjectDelegation<T>(findInjection())

