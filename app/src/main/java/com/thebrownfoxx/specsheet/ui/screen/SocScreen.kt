package com.thebrownfoxx.specsheet.ui.screen

import android.os.Build
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.outlined.DeveloperBoard
import androidx.compose.material.icons.outlined.Memory
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.thebrownfoxx.specsheet.R
import com.thebrownfoxx.specsheet.domain.Info
import com.thebrownfoxx.specsheet.domain.InfoSection
import com.thebrownfoxx.specsheet.ui.theme.SpecsheetTheme
import com.thebrownfoxx.specsheet.ui.theme.ThemeIcons

val socInfoSection = InfoSection(
    icon = ThemeIcons.Memory,
    titleResourceId = R.string.soc,
    infoList = listOf(
        Info(
            titleResourceId = R.string.manufacturer,
            value = { Build.SOC_MANUFACTURER },
        ),
        Info(
            titleResourceId = R.string.model,
            value = { Build.SOC_MODEL },
        ),
    )
)

val cpuInfoSection = InfoSection(
    icon = ThemeIcons.DeveloperBoard,
    titleResourceId = R.string.cpu,
    infoList = listOf(
        Info(
            titleResourceId = R.string.cores,
            value = { Runtime.getRuntime().availableProcessors().toString() },
        ),
        Info(
            titleResourceId = R.string.architecture,
            value = { System.getProperty("os.arch") ?: stringResource(id = R.string.unknown) },
        ),
    ),
)

@Composable
fun SocScreen(modifier: Modifier = Modifier) {
    LazyColumn(modifier) {
        infoSection(socInfoSection)
        infoSection(cpuInfoSection)
    }
}

@Preview
@Composable
fun SocScreenPreview() {
    SpecsheetTheme {
        SocScreen()
    }
}