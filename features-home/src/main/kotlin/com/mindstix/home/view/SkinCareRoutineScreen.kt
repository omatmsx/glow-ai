/**
 * Copyright (c) 2023 Mindstix Software Labs
 * All rights reserved.
 */

package com.mindstix.home.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mindstix.capabilities.database.entities.SkinCareRoutineEntity
import com.mindstix.capabilities.presentation.theme.textStyle1
import com.mindstix.capabilities.presentation.theme.textStyle2
import com.mindstix.core.R
import com.mindstix.home.intent.SkinCareRoutineScreenIntent
import com.mindstix.home.intent.SkinCareRoutineScreenViewStates
import com.mindstix.home.view.skinroutine.modal.SkinCareRoutineDataClass
import com.mindstix.home.viewmodel.SkinCareRoutineScreenViewModel

/**
 * Composable function representing the Profile Screen.
 *
 * @author Abhijeet Kokane
 */
@Composable
fun SkinCareRoutineScreen(
    skinCareRoutineScreenViewModel: SkinCareRoutineScreenViewModel,
    state: SkinCareRoutineScreenViewStates.LoadedData,
    userIntent: (SkinCareRoutineScreenIntent) -> Unit
) {

    val skinCareRoutineList = state.data.skinCareRoutineList

    val list = skinCareRoutineList.map {
        val icon = R.drawable.ic_skin_care
        SkinCareRoutineDataClass(
            title = it.task,
            description = it.whyWeShouldDoIt,
            iconRes = icon
        )
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // Header Title
        Text(
            text = "Personalized Skin Care Routine",
            modifier = Modifier.padding(bottom = 16.dp),
            style = textStyle1.copy(
                fontSize = 24.sp
            )
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 60.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(list) { routine ->
                // Display multiple routine cards
                RoutineCard(routine = routine)
            }
        }
    }
}

@Composable
fun RoutineCard(routine: SkinCareRoutineDataClass) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent)
            .padding(8.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 5.dp),
        ) {
            Row(
                modifier = Modifier
                    .padding(vertical = 10.dp)
                    .wrapContentHeight(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                // Icon on the left
                Image(
                    painter = painterResource(id = routine.iconRes),
                    contentDescription = "Routine Icon",
                    modifier = Modifier
                        .size(30.dp)
                        .background(Color.Transparent, shape = CircleShape)
                )
                Text(
                    text = routine.title, style = textStyle1.copy(
                        fontSize = 16.sp, fontWeight = FontWeight.Medium
                    ), lineHeight = 16.sp,
                    maxLines = 2, color = Color.Black, modifier = Modifier.padding(bottom = 4.dp)
                )
            }

            // Text content (Title and Description)
            Text(
                text = routine.description, color = Color.Gray, style = textStyle1.copy(
                    fontSize = 14.sp
                ), lineHeight = 14.sp, maxLines = 3
            )
        }
    }
}
