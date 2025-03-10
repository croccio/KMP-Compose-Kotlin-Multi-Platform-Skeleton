package it.croccio.ticketshare.library.kcnavigation

import androidx.navigation.NavGraphBuilder
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
open class RouteArgument

@Serializable
abstract class Route

@Serializable
abstract class RouteWithParameter(
    val parameter: RouteArgument // Cannot use generics due skiko error
) : Route()

interface Routes {

    fun injectRoutes(navGraphBuilder: NavGraphBuilder)

}

fun Route.toPath(): String =
    "${this::class.simpleName}"

inline fun <reified ARGUMENT> RouteWithParameter.toPath(): String =
    "${this::class.simpleName}/${Json.encodeToString(parameter as ARGUMENT)}"
