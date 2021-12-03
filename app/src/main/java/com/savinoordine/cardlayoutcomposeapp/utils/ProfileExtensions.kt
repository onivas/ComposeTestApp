package com.savinoordine.cardlayoutcomposeapp.utils

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.savinoordine.cardlayoutcomposeapp.ui.theme.LightGreen
import com.savinoordine.cardlayoutcomposeapp.ui.theme.LightRed

@Composable
fun Boolean.colorForOnlineUser(): Color =
    if (this) MaterialTheme.colors.LightGreen
    else MaterialTheme.colors.LightRed

@Composable
fun Boolean.stringStatusForOnlineUser(): String =
    if (this) "Active now"
    else "Offline"
