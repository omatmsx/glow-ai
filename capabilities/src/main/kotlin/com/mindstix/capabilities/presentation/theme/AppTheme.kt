/**
 * Copyright (c) 2023 Mindstix Software Labs
 * All rights reserved.
 */

package com.mindstix.capabilities.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

/**
 * Composable function representing the overall theme of the app using Jetpack Compose.
 *
 * @param darkTheme Flag to indicate whether the theme is in dark mode or light mode.
 * @param content The content block to apply the theme to.
 *
 * @author Alhaj SIddiqui
 */
@Composable
fun AppTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit,
) {
    // Determine the color scheme based on the selected theme (dark or light)
    val colors = if (!darkTheme) LightColors else DarkColors

    // Apply MaterialTheme with specified color scheme, typography, and shapes
    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        shapes = Shapes,
        content = content,
    )
}
