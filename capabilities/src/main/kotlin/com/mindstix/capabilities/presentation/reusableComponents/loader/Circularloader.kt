/**
 * Copyright (c) 2023 Mindstix Software Labs
 * All rights reserved.
 */

package com.mindstix.capabilities.presentation.reusableComponents.loader

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import com.mindstix.capabilities.presentation.theme.SurroundingSpacingLarge
import com.mindstix.capabilities.presentation.theme.SurroundingSpacingSmall
import com.mindstix.capabilities.presentation.theme.md_theme_light_primary

/**
 * Composable function representing a circular progress bar in Jetpack Compose.
 *
 * @param modifier Custom modifier for the circular progress bar.
 * @param progressColor Color of the circular progress bar.
 * @param size Size of the circular progress bar.
 * @param strokeWidth Width of the circular progress bar's stroke.
 *
 * @author Alhaj SIddiqui
 */
@Composable
fun CircularProgressBar(
    modifier: Modifier = Modifier,
    progressColor: Color = md_theme_light_primary,
    size: Dp = SurroundingSpacingLarge,
    strokeWidth: Dp = SurroundingSpacingSmall,
) {
    // Column to center the circular progress bar vertically and horizontally
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        // Circular progress indicator with specified parameters
        CircularProgressIndicator(
            modifier = modifier.size(size),
            color = progressColor,
            strokeWidth = strokeWidth,
        )
    }
}
