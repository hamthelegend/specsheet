package com.thebrownfoxx.specsheet.ui.screen

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.outlined.Speed
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.thebrownfoxx.specsheet.R
import com.thebrownfoxx.specsheet.domain.Info
import com.thebrownfoxx.specsheet.domain.InfoSection
import com.thebrownfoxx.specsheet.ui.composable.HorizontalSpacer
import com.thebrownfoxx.specsheet.ui.composable.InfoField
import com.thebrownfoxx.specsheet.ui.composable.VerticalSpacer
import com.thebrownfoxx.specsheet.ui.theme.SpecsheetTheme
import com.thebrownfoxx.specsheet.ui.theme.ThemeIcons
import com.thebrownfoxx.specsheet.ui.theme.unit

@Composable
fun InfoSectionTitle(
    icon: ImageVector,
    title: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.padding(4.unit),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            modifier = Modifier.size(8.unit),
            imageVector = icon,
            contentDescription = title,
        )
        HorizontalSpacer(width = 4.unit)
        Text(text = title, style = MaterialTheme.typography.headlineSmall)
    }
}

@Preview
@Composable
fun InfoSectionTitlePreview() {
    SpecsheetTheme {
        InfoSectionTitle(icon = ThemeIcons.Speed, title = stringResource(id = R.string.clock_speed))
    }
}

fun LazyListScope.infoSection(
    icon: ImageVector,
    @StringRes titleResourceId: Int,
    infoList: List<Info>,
) {
    item {
        InfoSectionTitle(icon = icon, title = stringResource(id = titleResourceId))
    }
    itemsIndexed(infoList) { index, info ->
        InfoField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 4.unit),
            info = info,
        )
        VerticalSpacer(height = (if (index == infoList.lastIndex) 0 else 2).unit)
    }
}

fun LazyListScope.infoSection(infoSection: InfoSection) {
    infoSection(
        icon = infoSection.icon,
        titleResourceId = infoSection.titleResourceId,
        infoList = infoSection.infoList,
    )
}

@Preview
@Composable
fun InfoSectionPreview() {
    SpecsheetTheme {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
//            infoSection(icon = ThemeIcons.Speed, titleResourceId = R.string.clock_speed, socInfo)
        }
    }
}
