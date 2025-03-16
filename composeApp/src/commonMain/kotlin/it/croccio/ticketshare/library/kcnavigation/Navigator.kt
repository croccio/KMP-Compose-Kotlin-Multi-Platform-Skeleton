package it.croccio.ticketshare.library.kcnavigation

import androidx.compose.runtime.snapshots.SnapshotStateList

typealias ScreenStack = SnapshotStateList<Route>

interface Navigator {

    val screenStack: ScreenStack

    var onBack: (() -> Unit)?

    fun navigate(route: Route)

    fun popBackStack()

}