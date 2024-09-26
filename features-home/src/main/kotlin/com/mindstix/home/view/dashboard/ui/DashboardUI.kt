package com.mindstix.home.view.dashboard.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mindstix.capabilities.presentation.theme.textStyle1
import com.mindstix.core.R
import com.mindstix.home.view.dashboard.modal.DiagnosisDataModel


@Composable
fun DiagnosisList(items: List<DiagnosisDataModel>, onItemClick: (DiagnosisDataModel) -> Unit) {
    LazyColumn(
        modifier = Modifier.height(300.dp),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(items) { item ->
            DiagnosisListItem(item = item, onItemClick = onItemClick)
        }
    }
}

@Composable
fun DiagnosisListItem(item: DiagnosisDataModel, onItemClick: (DiagnosisDataModel) -> Unit) {

    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        Card(
            // Rounded corners
            colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFFFF)), // Card background color
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp), // Card shadow elevation
            modifier = Modifier
                .weight(1F)
                .height(70.dp)
                .clickable { onItemClick(item) }, // Make the card clickable
            shape = RoundedCornerShape(16.dp),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Image and Title section
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Condition Image
                    Image(
                        painter = item.imagePainter,
                        contentDescription = "Condition Image",
                        modifier = Modifier
                            .size(55.dp)
                            .clip(RoundedCornerShape(8.dp)) // You can change this to CircleShape if needed
                    )

                    Spacer(modifier = Modifier.width(16.dp))

                    // Condition Name
                    Text(
                        text = item.conditionName, style = textStyle1.copy(
                            fontSize = 16.sp
                        )
                    )
                }
                Spacer(modifier = Modifier.weight(1F))
                // Information Icon
                Icon(
                    painter = painterResource(id = R.drawable.ic_info),
                    contentDescription = "Info Icon",
                    tint = Color.Red,
                    modifier = Modifier.size(20.dp)
                )
            }
        }
        Card(
            // Make the card clickable
            shape = RoundedCornerShape(16.dp), // Rounded corners
            colors = CardDefaults.cardColors(containerColor = Color.White), // Card background color
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp), // Card shadow elevation
            modifier = Modifier
                .height(70.dp)
                .clickable { onItemClick(item) }) {
            // Confidence Level
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .height(70.dp)
                    .padding(horizontal = 10.dp)
            ) {
                Text(
                    text = "Confidence", style = textStyle1.copy(
                        fontSize = 14.sp
                    ), color = Color(0xFFDE9696) // light red color for confidence text
                )
                Text(
                    text = "${item.confidence}%", style = textStyle1.copy(
                        fontSize = 14.sp
                    ),
                    modifier = Modifier.padding(top = 5.dp)
                )
            }
        }
    }
}

