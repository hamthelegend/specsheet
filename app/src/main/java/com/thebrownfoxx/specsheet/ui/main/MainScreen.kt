package com.thebrownfoxx.specsheet.ui.main

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.thebrownfoxx.specsheet.ui.theme.SpecsheetTheme

@OptIn(ExperimentalMaterial3Api::class, ExperimentalPagerApi::class)
@Composable
fun MainScreen() {
    val pagerState = rememberPagerState()

    Scaffold(
        topBar = {
            SpecsheetTopBar(pagerState = pagerState)
        }
    ) { paddingValues ->
        HorizontalPager(
            count = tabs.size,
            state = pagerState,
            modifier = Modifier.padding(paddingValues)
        ) { tabIndex ->
            tabs[tabIndex].screen(Modifier)
        }
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    SpecsheetTheme {
        MainScreen()
    }
}