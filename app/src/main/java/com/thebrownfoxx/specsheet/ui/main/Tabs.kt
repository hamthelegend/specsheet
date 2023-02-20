package com.thebrownfoxx.specsheet.ui.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.thebrownfoxx.specsheet.R
import com.thebrownfoxx.specsheet.ui.screen.DeviceScreen
import com.thebrownfoxx.specsheet.ui.screen.SocScreen

data class Tab(
    val text: @Composable () -> String,
    val screen: @Composable (Modifier) -> Unit,
)

val tabs = listOf(
    Tab(
        text = { stringResource(R.string.soc) },
        screen = { modifier ->
            SocScreen(modifier = modifier)
        },
    ),
    Tab(
        text = { stringResource(R.string.device) },
        screen = { modifier ->
            DeviceScreen(modifier = modifier)
        },
    ),
    Tab(
        text = { stringResource(R.string.system) },
        screen = { modifier ->
            Text(
                modifier = modifier.fillMaxSize(),
                text = stringResource(id = R.string.system),
            )
        },
    ),
    Tab(
        text = { stringResource(R.string.battery) },
        screen = { modifier ->
            Text(
                modifier = modifier.fillMaxSize(),
                text = stringResource(id = R.string.battery),
            )
        },
    ),
    Tab(
        text = { stringResource(R.string.thermal) },
        screen = { modifier ->
            Text(
                modifier = modifier.fillMaxSize(),
                text = stringResource(id = R.string.thermal),
            )
        },
    ),
    Tab(
        text = { stringResource(R.string.sensors) },
        screen = { modifier ->
            Text(
                modifier = modifier.fillMaxSize(),
                text = stringResource(id = R.string.sensors),
            )
        },
    ),
    Tab(
        text = { stringResource(R.string.about) },
        screen = { modifier ->
            Text(
                modifier = modifier.fillMaxSize(),
                text = stringResource(id = R.string.about),
            )
        },
    ),
)