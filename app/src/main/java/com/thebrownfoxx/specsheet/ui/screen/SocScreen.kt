package com.thebrownfoxx.specsheet.ui.screen

import android.content.res.Resources.Theme
import android.os.Build
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.outlined.Build
import androidx.compose.material.icons.outlined.DeveloperBoard
import androidx.compose.material.icons.outlined.Memory
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.thebrownfoxx.specsheet.R
import com.thebrownfoxx.specsheet.domain.Info
import com.thebrownfoxx.specsheet.ui.composable.InfoField
import com.thebrownfoxx.specsheet.ui.composable.VerticalSpacer
import com.thebrownfoxx.specsheet.ui.theme.SpecsheetTheme
import com.thebrownfoxx.specsheet.ui.theme.ThemeIcons
import com.thebrownfoxx.specsheet.ui.theme.unit

val socInfo = listOf(
    Info(
        title = { stringResource(id = R.string.manufacturer) },
        value = { Build.SOC_MANUFACTURER }
    ),
    Info(
        title = { stringResource(id = R.string.model) },
        value = { Build.SOC_MODEL }
    ),
    Info(
        title = { stringResource(id = R.string.cores) },
        value = { Runtime.getRuntime().availableProcessors().toString() }
    ),
    Info(
        title = { stringResource(id = R.string.architecture) },
        value = {
            // TODO: Make this more friendly
            System.getProperty("os.arch") ?: stringResource(id = R.string.unknown)
        },
    ),
    Info(
        title = { stringResource(id = R.string.revision) },
        value = { stringResource(id = R.string.unimplemented) },
    ),
    Info(
        title = { stringResource(id = R.string.process) },
        value = { stringResource(id = R.string.unimplemented) },
    ),
    Info(
        title = { stringResource(id = R.string.gpu_vendor) },
        value = { stringResource(id = R.string.unimplemented) },
    ),
    Info(
        title = { stringResource(id = R.string.process) },
        value = { stringResource(id = R.string.unimplemented) },
    ),
    Info(
        title = { stringResource(id = R.string.process) },
        value = { stringResource(id = R.string.unimplemented) },
    ),
    Info(
        title = { stringResource(id = R.string.process) },
        value = { stringResource(id = R.string.unimplemented) },
    ),
)

@Composable
fun SocScreen(modifier: Modifier = Modifier) {
    InfoScreen(
        modifier = modifier,
        infoList = socInfo,
    )
}

@Preview
@Composable
fun SocScreenPreview() {
    SpecsheetTheme {
        SocScreen()
    }
}