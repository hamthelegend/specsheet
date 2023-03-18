package com.thebrownfoxx.specsheet.domain

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

data class Info(
    val title: @Composable () -> String,
    val value: @Composable () -> String,
) {
    constructor(@StringRes titleResourceId: Int, value: @Composable () -> String) : this(
        title = {
            stringResource(id = titleResourceId)
        },
        value = value,
    )
}