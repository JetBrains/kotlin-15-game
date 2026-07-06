package com.glycin.koita.ui_composables.main_menu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.glycin.koita.gameplay.GameState
import com.glycin.koita.gameplay.Screen
import com.glycin.koita.ui_composables.MenuColors
import com.glycin.koita.ui_composables.MenuHeader
import com.glycin.koita.ui_composables.SidebarMenuItem
import com.glycin.koita.ui_composables.compactOr
import com.glycin.koita.ui_composables.isCompact
import com.glycin.koita.ui_composables.isPortrait
import com.glycin.koita.ui_composables.pixelFont
import com.glycin.koita.ui_composables.rememberMenuBackgroundBrush
import com.glycin.koita.util.requestBrowserFullscreen

@Composable
fun MainMenu(gameState: GameState) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(rememberMenuBackgroundBrush()),
    ) {
        MainMenuPanel(gameState, modifier = Modifier.align(Alignment.Center))
        GithubCorner(modifier = Modifier.align(Alignment.TopEnd))
        if (isPortrait()) {
            DeviceHintBanner(modifier = Modifier.align(Alignment.BottomCenter))
        }
    }
}

@Composable
private fun DeviceHintBanner(modifier: Modifier = Modifier) {
    val text = "Kodee vs Friction is best played on desktop. On mobile, play in landscape mode."
    val fontSize = compactOr(24.sp, 36.sp)
    val font = pixelFont()
    val outlineStyle = remember(fontSize) {
        TextStyle(
            fontFamily = font,
            fontSize = fontSize,
            color = Color.Black,
            drawStyle = Stroke(width = 6f),
            textAlign = TextAlign.Center,
        )
    }
    val fillStyle = remember(fontSize) {
        TextStyle(
            fontFamily = font,
            fontSize = fontSize,
            color = Color.White,
            textAlign = TextAlign.Center,
        )
    }
    val textModifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
    Box(modifier = modifier) {
        Text(text = text, style = outlineStyle, modifier = textModifier)
        Text(text = text, style = fillStyle, modifier = textModifier)
    }
}

@Composable
private fun MainMenuPanel(gameState: GameState, modifier: Modifier = Modifier) {
    val compact = isCompact()
    Column(
        modifier = modifier
            .width(compactOr(320.dp, 480.dp))
            .background(MenuColors.SIDEBAR),
    ) {
        MenuHeader(modifier = Modifier.fillMaxWidth()) {
            KodeeVsFrictionBanner()
        }

        MainMenuItem("Start") {
            if (compact) requestBrowserFullscreen()
            gameState.currentScreen = Screen.GAME
        }
        MainMenuItem("Modifiers") { gameState.currentScreen = Screen.MODIFIERS }
        MainMenuItem("How to Play") {
            if (compact) requestBrowserFullscreen()
            gameState.currentScreen = Screen.TUTORIAL
        }
        MainMenuItem("Options") { gameState.currentScreen = Screen.OPTIONS }
        MainMenuItem("Highscores") { gameState.currentScreen = Screen.HIGHSCORES }
        MainMenuItem("Atlas") { gameState.currentScreen = Screen.ATLAS }

        Spacer(modifier = Modifier.size(compactOr(16.dp, 32.dp)))
    }
}

@Composable
private fun MainMenuItem(text: String, onClick: () -> Unit) {
    SidebarMenuItem(
        text = text,
        fontSize = compactOr(18.sp, 32.sp),
        verticalPadding = compactOr(8.dp, 12.dp),
        onClick = onClick,
    )
}
