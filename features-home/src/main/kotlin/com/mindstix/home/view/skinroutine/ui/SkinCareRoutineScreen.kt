package com.mindstix.home.view.skinroutine.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mindstix.capabilities.presentation.theme.textStyle1
import com.mindstix.capabilities.presentation.theme.textStyle2
import com.mindstix.core.R
import com.mindstix.home.view.skinroutine.modal.SkinCareRoutineDataClass

@Composable
fun SkinCareRoutineUI() {

    val skinCareRoutineList = listOf(
        SkinCareRoutineDataClass(
            title = "Cleanse face with a gentle cleanser",
            description = "Apply sunscreen with SPF 30 or higher to protect your skin from harmful UV rays.",
            iconRes = R.drawable.ic_image // Replace with the correct resource
        ), SkinCareRoutineDataClass(
            title = "Apply a lightweight moisturizer",
            description = "To hydrate your skin and restore its natural moisture barrier without clogging your pores.",
            iconRes = R.drawable.ic_image // Replace with the correct resource
        ), SkinCareRoutineDataClass(
            title = "Use sunscreen daily",
            description = "Apply sunscreen with SPF 30 or higher to protect your skin from harmful UV rays.",
            iconRes = R.drawable.ic_image // Replace with the correct resource
        )
    )


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // Header Title
        Text(
            text = "AI Generated Skin Care Routine",
            modifier = Modifier.padding(bottom = 16.dp),
            style = textStyle2.copy(
                fontSize = 16.sp
            )
        )

        // Display multiple routine cards
        skinCareRoutineList.forEach { routine ->
            RoutineCard(routine = routine)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun RoutineCard(routine: SkinCareRoutineDataClass) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(horizontal = 20.dp)) {
            Row(
                modifier = Modifier.padding(vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                // Icon on the left
                Image(
                    painter = painterResource(id = routine.iconRes),
                    contentDescription = "Routine Icon",
                    modifier = Modifier
                        .size(40.dp)
                        .background(Color.Transparent, shape = CircleShape)
                )
                Text(
                    text = routine.title, style = textStyle1.copy(
                        fontSize = 16.sp
                    ), lineHeight = 16.sp, modifier = Modifier.padding(bottom = 4.dp)
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            // Text content (Title and Description)

            Text(
                text = routine.description, color = Color.Gray, style = textStyle1.copy(
                    fontSize = 16.sp
                ), lineHeight = 14.sp
            )
        }
    }
}

