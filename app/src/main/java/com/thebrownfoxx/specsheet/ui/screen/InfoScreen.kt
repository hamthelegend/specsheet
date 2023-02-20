package com.thebrownfoxx.specsheet.ui.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.thebrownfoxx.specsheet.domain.Info
import com.thebrownfoxx.specsheet.ui.composable.InfoField
import com.thebrownfoxx.specsheet.ui.composable.VerticalSpacer
import com.thebrownfoxx.specsheet.ui.theme.unit

@Composable
fun InfoScreen(
    infoList: List<Info>,
    modifier: Modifier = Modifier,
) {
    LazyColumn(modifier = modifier.fillMaxSize()) {
        itemsIndexed(infoList) { index, info ->
            if (index == 0) {
                VerticalSpacer(height = 4.unit)
            }
            InfoField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.unit),
                info = info,
            )
            VerticalSpacer(height = (if (index == socInfo.lastIndex) 4 else 2).unit)
        }
    }
}