package com.thebrownfoxx.specsheet.ui.screen

import android.os.Build
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.thebrownfoxx.specsheet.R
import com.thebrownfoxx.specsheet.domain.Info
import com.thebrownfoxx.specsheet.ui.theme.SpecsheetTheme

val deviceInfo = listOf(
    Info(
        title = { stringResource(id = R.string.model) },
        value = { Build.MODEL },
    ),
    Info(
        title = { stringResource(id = R.string.manufacturer) },
        value = { Build.MANUFACTURER },
    ),
    Info(
        title = { stringResource(R.string.board) },
        value = { Build.BOARD },
    ),
    Info(
        title = { stringResource(R.string.hardware) },
        value = { Build.HARDWARE },
    ),
    Info(
        title = { stringResource(R.string.screen_size) },
        value = { stringResource(id = R.string.unimplemented) },
    ),
    Info(
        title = { stringResource(R.string.screen_resolution) },
        value = { stringResource(id = R.string.unimplemented) },
    ),
    Info(
        title = { stringResource(R.string.screen_density) },
        value = { stringResource(id = R.string.unimplemented) },
    ),
    Info(
        title = { stringResource(R.string.total_ram) },
        value = { stringResource(id = R.string.unimplemented) },
    ),
    Info(
        title = { stringResource(R.string.available_ram) },
        value = { stringResource(id = R.string.unimplemented) },
    ),
    Info(
        title = { stringResource(R.string.internal_storage) },
        value = { stringResource(id = R.string.unimplemented) },
    ),
    Info(
        title = { stringResource(R.string.available_storage) },
        value = { stringResource(id = R.string.unimplemented) },
    ),
)

@Composable
fun DeviceScreen(modifier: Modifier = Modifier) {
    InfoScreen(
        modifier = modifier,
        infoList = deviceInfo,
    )
}

@Preview
@Composable
fun DeviceScreenPreview() {
    SpecsheetTheme {
        DeviceScreen()
    }
}