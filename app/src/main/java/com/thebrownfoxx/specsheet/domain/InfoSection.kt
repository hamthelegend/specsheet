package com.thebrownfoxx.specsheet.domain

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector

data class InfoSection(
    val icon: ImageVector,
    @StringRes val titleResourceId: Int,
    val infoList: List<Info>,
)
