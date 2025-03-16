package it.croccio.ticketshare.library.kcnavigation

class PagerNavigator() : Navigator {

    override val screenStack = ScreenStack()

    override var onBack: (() -> Unit)? = null

    override fun navigate(route: Route) {
        screenStack.add(route)
    }

    override fun popBackStack() {
        if (screenStack.size > 1) {
            onBack?.invoke() ?: screenStack.removeLast()
        }
    }

}