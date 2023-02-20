package com.thebrownfoxx.specsheet.ui.composable

import android.content.res.Resources.Theme
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ContentCopy
import androidx.compose.material.icons.outlined.CopyAll
import androidx.compose.material.icons.outlined.Speed
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import com.thebrownfoxx.specsheet.R
import com.thebrownfoxx.specsheet.domain.Info
import com.thebrownfoxx.specsheet.ui.theme.SpecsheetTheme
import com.thebrownfoxx.specsheet.ui.theme.ThemeIcons
import com.thebrownfoxx.specsheet.ui.theme.unit

@Composable
fun InfoField(
    info: Info,
    modifier: Modifier = Modifier,
) {
    InfoField(
        modifier = modifier,
        title = info.title(),
        value = info.value(),
    )
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun InfoField(
    title: String,
    value: String,
    modifier: Modifier = Modifier,
) {
    TextField(
        modifier = modifier,
        label = { Text(text = title) },
        value = value,
        onValueChange = {},
        readOnly = true,
        shape = ShapeDefaults.Small,
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
        ),
        singleLine = true,
    )
}

@Preview
@Composable
fun InfoFieldPreview() {
    SpecsheetTheme {
        InfoField(
            title = "Clock speed",
            value = "307 MHz - 3.00 GHz",
            modifier = Modifier.padding(4.unit),
        )
    }
}