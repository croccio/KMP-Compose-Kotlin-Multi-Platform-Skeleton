package it.croccio.ticketshare.library.kcnavigation

import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch

@Composable
fun NavigationSystem(
    modifier: Modifier = Modifier,
    navigator: Navigator,
    starterPage: Route,
    routes: Routes,
) {

    val navigator = remember { navigator }

    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { navigator.screenStack.size }
    )

    val coroutineScope = rememberCoroutineScope()

    HorizontalPager(
        modifier = modifier
            .fillMaxSize(),
        state = pagerState,
        userScrollEnabled = true,
        snapPosition = SnapPosition.Center,
    ) { pageIndex ->
        routes
            .toScreen(navigator.screenStack[pageIndex])
    }

    LaunchedEffect(pagerState.pageCount) {
        pagerState.animateScrollToPage(navigator.screenStack.lastIndex)
    }

    LaunchedEffect(pagerState.currentPageOffsetFraction) {
        if (pagerState.currentPageOffsetFraction == 0f && pagerState.currentPage < navigator.screenStack.lastIndex) {
            coroutineScope.launch {
                navigator.screenStack.removeRange(
                    pagerState.currentPage + 1,
                    pagerState.pageCount,
                )
            }
        }
    }

    LaunchedEffect(Unit) {
        navigator.onBack = {
            coroutineScope.launch {
                pagerState.animateScrollToPage(navigator.screenStack.lastIndex - 1)
            }
        }
        navigator.navigate(starterPage)
    }
}