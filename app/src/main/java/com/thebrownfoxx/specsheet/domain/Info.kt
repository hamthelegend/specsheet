package com.thebrownfoxx.specsheet.domain

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

data class Info(
//    val icon: ImageVector,
    val title: @Composable () -> String,
    val value: @Composable () -> String,
)
