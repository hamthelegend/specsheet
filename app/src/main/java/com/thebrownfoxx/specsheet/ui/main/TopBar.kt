package com.thebrownfoxx.specsheet.ui.main

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.zIndex
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import com.thebrownfoxx.specsheet.R
import com.thebrownfoxx.specsheet.ui.composable.HorizontalSpacer
import com.thebrownfoxx.specsheet.ui.theme.SpecsheetTheme
import com.thebrownfoxx.specsheet.ui.theme.unit
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, ExperimentalPagerApi::class)
@Composable
fun SpecsheetTopBar(
    tabRowState: LazyListState = rememberLazyListState(),
    pagerState: PagerState = rememberPagerState(),
) {
    Column {
        TopAppBar(title = { Text(stringResource(id = R.string.app_name)) })
        SpecsheetTabRow(pagerState = pagerState)
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
private fun SpecsheetTabRow(
    pagerState: PagerState = rememberPagerState(),
) {
    val coroutineScope = rememberCoroutineScope()
    val state = rememberLazyListState()
    val selectedItemVisible by remember {
        derivedStateOf {
            pagerState.currentPage in state.layoutInfo.visibleItemsInfo.map { it.index }
        }
    }

/*    LaunchedEffect(selectedItemVisible) {
        if (!selectedItemVisible) {
            state.animateScrollToItem(pagerState.currentPage)
        }
    }*/

    LazyRow(modifier = Modifier.wrapContentSize()) {
        item {
            HorizontalSpacer(width = 4.unit)
        }
        itemsIndexed(tabs) { index, tab ->
            val containerColor by animateColorAsState(
                targetValue = when (pagerState.currentPage) {
                    index -> MaterialTheme.colorScheme.primary
                    else -> Color.Transparent
                },
                animationSpec = tween(durationMillis = 50),
            )
            val textColor by animateColorAsState(
                targetValue = when (pagerState.currentPage) {
                    index -> MaterialTheme.colorScheme.onPrimary
                    else -> MaterialTheme.colorScheme.onPrimaryContainer
                },
                animationSpec = tween(durationMillis = 50),
            )
            val circleRadius = 8.unit
            val startRadius = if (index == 0) circleRadius else 0.unit
            val endRadius = if (index == tabs.lastIndex) circleRadius else 0.unit
            val backgroundShape = RoundedCornerShape(
                topStart = startRadius,
                bottomStart = startRadius,
                topEnd = endRadius,
                bottomEnd = endRadius,
            )
            Surface(
                modifier = Modifier.clip(backgroundShape),
                color = MaterialTheme.colorScheme.primaryContainer,
            ) {
                Tab(
                    modifier = Modifier
                        .zIndex(6f)
                        .clip(CircleShape)
                        .defaultMinSize(minWidth = 24.unit)
                        .background(containerColor),
                    selected = pagerState.currentPage == index,
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                    text = {
                        Text(
                            text = tab.text(),
                            color = textColor,
                        )
                    },
                )
            }
        }
        item {
            HorizontalSpacer(width = 4.unit)
        }
    }

/*    Row {
        HorizontalSpacer(width = 4.unit)
        ScrollableTabRow(
            modifier = Modifier.clip(CircleShape).wrapContentSize(),
            selectedTabIndex = pagerState.currentPage,
            indicator = { tabPositions ->
                SpecsheetTabIndicator(tabPositions = tabPositions, pagerState = pagerState)
            },
            edgePadding = 0.dp,
            divider = {},
            containerColor = MaterialTheme.colorScheme.primaryContainer,
        ) {
            for ((index, tab) in tabs.withIndex()) {
                val textColor by animateColorAsState(
                    targetValue = when (pagerState.currentPage) {
                        index -> MaterialTheme.colorScheme.onPrimary
                        else -> MaterialTheme.colorScheme.onPrimaryContainer
                    },
                )

                Tab(
                    modifier = Modifier
                        .zIndex(6f)
                        .clip(CircleShape),
                    selected = pagerState.currentPage == index,
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                    text = {
                        Text(
                            text = tab.text(),
                            color = textColor,
                        )
                    },
                )
            }
        }
        HorizontalSpacer(width = 4.unit)
    }*/
}

@OptIn(ExperimentalPagerApi::class)
@Preview
@Composable
fun TopBarPreview() {
    SpecsheetTheme {
        SpecsheetTopBar()
    }
}