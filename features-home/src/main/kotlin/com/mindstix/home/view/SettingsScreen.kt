/**
 * Copyright (c) 2023 Mindstix Software Labs
 * All rights reserved.
 */

package com.mindstix.home.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

/**
 * Composable function representing the Settings Screen.
 *
 * @author Alhaj SIddiqui
 */
@Composable
fun SettingsScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Coming Soon", fontSize = 20.sp)
    }
}
