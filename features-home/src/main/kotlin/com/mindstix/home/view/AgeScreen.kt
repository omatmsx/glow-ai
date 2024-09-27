package com.mindstix.home.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mindstix.capabilities.presentation.theme.md_theme_light_background
import com.mindstix.capabilities.presentation.theme.textStyle1
import com.mindstix.capabilities.presentation.theme.textStyle2
import com.mindstix.core.utils.EMPTY_STRING
import com.mindstix.home.intent.AgeScreenIntent

@Composable
fun AgeScreen(
    userIntent: (AgeScreenIntent) -> Unit
){
    var age by remember { mutableStateOf(EMPTY_STRING) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(md_theme_light_background)
            .padding(24.dp, 32.dp),
    ) {
        Text(
            text = "What's your age?",
            style = textStyle1.copy(
                fontSize = 24.sp
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Helps determine skin aging patterns.",
            style = textStyle1.copy(
                fontSize = 16.sp
            )
        )
        Spacer(modifier = Modifier.height(48.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, shape = RoundedCornerShape(8.dp))
                .padding(16.dp)
        ) {
            BasicTextField(
                value = age,
                onValueChange = {
                    age = it
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                textStyle = TextStyle(color = Color.Black),
                modifier = Modifier.fillMaxWidth()
            )
        }


        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                userIntent.invoke(AgeScreenIntent.NavigateToHomeScreen)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFEDE5FF)
            ),
            shape = MaterialTheme.shapes.extraLarge
        ) {
            Text(text = "Continue", color = Color.DarkGray)
        }
    }
}

//@Preview
//@Composable
//fun AgeScreenPreview(){
//    AgeScreen()
//}