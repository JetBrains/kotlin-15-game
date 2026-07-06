package com.glycin.koita.ui_composables

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.glycin.koita.gameplay.upgrades.UnlockGroup

@Composable
internal fun rememberMenuBackgroundBrush(): Brush = remember {
    Brush.verticalGradient(
        colors = listOf(
            MenuColors.MAIN_BACKGROUND_DARK,
            MenuColors.MAIN_BACKGROUND_MID,
            MenuColors.MAIN_BACKGROUND_LIGHT,
        ),
    )
}

internal object MenuColors {
    val PAUSE_OVERLAY = Color(0x99000000)
    val SECTION_TITLE = Color(0xFFCCCCFF)
    val ERROR_TEXT = Color(0xFFFF6666)
    val VICTORY_TITLE = Color(0xFFFFD700)
    val INPUT_FIELD_FILL = Color.LightGray.copy(alpha = 0.35f)
    val RANK_GOLD = VICTORY_TITLE
    val RANK_SILVER = Color(0xFFC0C0C0)
    val RANK_BRONZE = Color(0xFFCD7F32)

    val SIDEBAR = Color(0xFFFF5530)
    val SLIDER_TRACK = Color.White.copy(alpha = 0.35f)
    val PAUSE_RIGHT_BG = Color.White
    val PAUSE_RIGHT_TEXT = Color(0xFF1A1A1A)
    val PAUSE_RIGHT_MUTED = Color(0xFF666666)
    val PAUSE_ACCENT = SIDEBAR
    val MAIN_BACKGROUND_DARK = Color(0xFF1A0A2E)
    val MAIN_BACKGROUND_MID = Color(0xFF4B0AC9)
    val MAIN_BACKGROUND_LIGHT = Color(0xFF6B30F9)
    val YOU_ACCENT = MAIN_BACKGROUND_LIGHT

    val CARD_MOVEMENT_BORDER = Color(0xFF8C83FF)
    val CARD_BUILD_BORDER = Color(0xFF8CFF83)
    val CARD_WEAPON_BORDER = Color(0xFFFF8C63)
    val ATLAS_TAB_INACTIVE = Color.White.copy(alpha = 0.5f)
}
