/**
 * Copyright (c) 2023 Mindstix Software Labs
 * All rights reserved.
 */

package com.mindstix.capabilities.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp
import com.mindstix.capabilities.R

/**
 * Typography for defining text styles.
 *
 * @author Abhijeet Kokane
 */


val fredokaFontFamily = FontFamily(
    Font(R.font.fredoka_regular, FontWeight.Normal),
    Font(R.font.fredoka_bold, FontWeight.Bold),
    Font(R.font.fredoka_light, FontWeight.Light),
    Font(R.font.fredoka_semibold, FontWeight.SemiBold),
    Font(R.font.fredoka_medium, FontWeight.Medium),
)

val Typography =
    Typography(
        displayLarge =
            TextStyle(
                // Default font family
                fontFamily = fredokaFontFamily,
                // Normal font weight
                fontWeight = FontWeight.Normal,
                // Font size of 16sp
                fontSize = 16.sp,
            ),
    )


val textFieldLabel =
    TextStyle(
        fontFamily = fredokaFontFamily,
        // Normal font weight
        fontWeight = FontWeight.Normal,
        // Font size of 13sp
        fontSize = 13.sp,
    )

val buttonTextBold =
    TextStyle(
        fontFamily = fredokaFontFamily,
        // Normal font weight
        fontWeight = FontWeight.Bold,
        // Font size of 13sp
        fontSize = 13.sp,
        letterSpacing = 3.sp,
    )

val buttonTextNormal =
    TextStyle(
        fontFamily = fredokaFontFamily,
        // Normal font weight
        fontWeight = FontWeight.Normal,
        // Font size of 13sp
        fontSize = 13.sp,
        letterSpacing = 3.sp,
    )

val textStyle1 =
    TextStyle(
        fontFamily = fredokaFontFamily,
        // Normal font weight
        fontWeight = FontWeight.Normal,
        // Font size of 13sp
        fontSize = 13.sp,
    )

val textStyle2 =
    TextStyle(
        fontFamily = fredokaFontFamily,
        // Normal font weight
        fontWeight = FontWeight.Bold,
        // Font size of 13sp
        fontSize = 13.sp,
    )

val textStyleLight =
    TextStyle(
        fontFamily = fredokaFontFamily,
        // Normal font weight
        fontWeight = FontWeight.Light,
        // Font size of 13sp
        fontSize = 13.sp,
    )
