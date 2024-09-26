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
import com.mindstix.home.view.dashboard.modal.SkinAnalysisEntityDataModal
import java.math.RoundingMode


@Composable
fun DiagnosisList(
    items: List<SkinAnalysisEntityDataModal>, onItemClick: () -> Unit
) {
    val firstItem = items.firstOrNull() ?: SkinAnalysisEntityDataModal(
        poresLeftCheekConfidence = 0.0,
        poresLeftCheekValue = 0,
        eyePouchConfidence = 0.0,
        eyePouchValue = 0,
        foreheadWrinkleConfidence = 0.0,
        foreheadWrinkleValue = 0,
        skinSpotConfidence = 0.0,
        skinSpotValue = 0,
        acneConfidence = 0.0,
        acneValue = 0,
        poresForeheadConfidence = 0.0,
        poresForeheadValue = 0,
        eyeFinelinesConfidence = 0.0,
        eyeFinelinesValue = 0,
        darkCircleConfidence = 0.0,
        darkCircleValue = 0,
        poresRightCheekConfidence = 0.0,
        poresRightCheekValue = 0,
        blackheadConfidence = 0.0,
        blackheadValue = 0,
        skinType = "--",
        nasolabialFoldConfidence = 0.0,
        nasolabialFoldValue = 0,
        poresJawConfidence = 0.0,
        poresJawValue = 0,
        leftEyelidsConfidence = 0.0,
        leftEyelidsValue = 0,
        crowsFeetConfidence = 0.0,
        crowsFeetValue = 0,
        glabellaWrinkleConfidence = 0.0,
        glabellaWrinkleValue = 0,
        moleConfidence = 0.0,
        moleValue = 0,
        rightEyelidsConfidence = 0.0,
        rightEyelidsValue = 0
    )

    LazyColumn(
        modifier = Modifier.height(300.dp),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            DiagnosisListItem(
                itemName = "Acne",
                itemValue = firstItem.acneValue,
                itemImage = R.drawable.ic_acne,
                itemConfidence = firstItem.acneConfidence,
                onItemClick = onItemClick
            )
        }
        item {
            DiagnosisListItem(
                itemName = "Black Heads",
                itemValue = firstItem.blackheadValue,
                itemImage = R.drawable.ic_acne1,
                itemConfidence = firstItem.blackheadConfidence,
                onItemClick = onItemClick
            )
        }
        item {
            DiagnosisListItem(
                itemName = "Dark Circle",
                itemValue = firstItem.darkCircleValue,
                itemImage = R.drawable.ic_acne2,
                itemConfidence = firstItem.acneConfidence,
                onItemClick = onItemClick
            )
        }
        item {
            DiagnosisListItem(
                itemName = "Eye Pouch",
                itemValue = firstItem.eyePouchValue,
                itemImage = R.drawable.ic_acne3,
                itemConfidence = firstItem.eyePouchConfidence,
                onItemClick = onItemClick
            )
        }
        item {
            DiagnosisListItem(
                itemName = "EyeFine Lines",
                itemValue = firstItem.eyeFinelinesValue,
                itemImage = R.drawable.ic_acne4,
                itemConfidence = firstItem.eyeFinelinesConfidence,
                onItemClick = onItemClick
            )
        }
        item {
            DiagnosisListItem(
                itemName = "Forehead Wrinkle",
                itemValue = firstItem.foreheadWrinkleValue,
                itemImage = R.drawable.ic_acne1,
                itemConfidence = firstItem.foreheadWrinkleConfidence,
                onItemClick = onItemClick
            )
        }
        item {
            DiagnosisListItem(
                itemName = "BlackHead",
                itemValue = firstItem.blackheadValue,
                itemImage = R.drawable.ic_acne2,
                itemConfidence = firstItem.blackheadConfidence,
                onItemClick = onItemClick
            )
        }
        item {
            DiagnosisListItem(
                itemName = "Forehead Pores",
                itemValue = firstItem.poresForeheadValue,
                itemImage = R.drawable.ic_acne3,
                itemConfidence = firstItem.poresForeheadConfidence,
                onItemClick = onItemClick
            )
        }
        item {
            DiagnosisListItem(
                itemName = "RightCheek Pores",
                itemValue = firstItem.poresRightCheekValue,
                itemImage = R.drawable.ic_acne4,
                itemConfidence = firstItem.poresRightCheekConfidence,
                onItemClick = onItemClick
            )
        }
        item {
            DiagnosisListItem(
                itemName = "LeftCheek Pores",
                itemValue = firstItem.poresLeftCheekValue,
                itemImage = R.drawable.ic_acne,
                itemConfidence = firstItem.poresLeftCheekConfidence,
                onItemClick = onItemClick
            )
        }
        item {
            DiagnosisListItem(
                itemName = "Skin Spot",
                itemValue = firstItem.skinSpotValue,
                itemImage = R.drawable.ic_acne1,
                itemConfidence = firstItem.skinSpotConfidence,
                onItemClick = onItemClick
            )
        }
        item {
            DiagnosisListItem(
                itemName = "Nasolabial Fold",
                itemValue = firstItem.nasolabialFoldValue,
                itemImage = R.drawable.ic_acne2,
                itemConfidence = firstItem.nasolabialFoldConfidence,
                onItemClick = onItemClick
            )
        }
        item {
            DiagnosisListItem(
                itemName = "Jaw Pores",
                itemValue = firstItem.poresJawValue,
                itemImage = R.drawable.ic_acne3,
                itemConfidence = firstItem.poresJawConfidence,
                onItemClick = onItemClick
            )
        }
        item {
            DiagnosisListItem(
                itemName = "left Eyelids",
                itemValue = firstItem.leftEyelidsValue,
                itemImage = R.drawable.ic_acne4,
                itemConfidence = firstItem.leftEyelidsConfidence,
                onItemClick = onItemClick
            )
        }
        item {
            DiagnosisListItem(
                itemName = "Crows Feet",
                itemValue = firstItem.crowsFeetValue,
                itemImage = R.drawable.ic_acne,
                itemConfidence = firstItem.crowsFeetConfidence,
                onItemClick = onItemClick
            )
        }
        item {
            DiagnosisListItem(
                itemName = "Glabella Wrinkle",
                itemValue = firstItem.glabellaWrinkleValue,
                itemImage = R.drawable.ic_acne1,
                itemConfidence = firstItem.glabellaWrinkleConfidence,
                onItemClick = onItemClick
            )
        }
        item {
            DiagnosisListItem(
                itemName = "Mole",
                itemValue = firstItem.moleValue,
                itemImage = R.drawable.ic_acne2,
                itemConfidence = firstItem.moleConfidence,
                onItemClick = onItemClick
            )
        }
        item {
            DiagnosisListItem(
                itemName = "Right Eyelids",
                itemValue = firstItem.rightEyelidsValue,
                itemImage = R.drawable.ic_acne3,
                itemConfidence = firstItem.rightEyelidsConfidence,
                onItemClick = onItemClick
            )
        }
    }
}

@Composable
fun DiagnosisListItem(
    itemName: String,
    itemValue: Int,
    itemConfidence: Double,
    itemImage: Int,
    onItemClick: () -> Unit
) {
    val percentage = (itemConfidence * 100).toBigDecimal()
        .setScale(2, RoundingMode.HALF_UP)  // Convert and round to two decimal places

    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        Card(
            // Rounded corners
            colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFFFF)), // Card background color
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp), // Card shadow elevation
            modifier = Modifier
                .weight(1F)
                .height(70.dp)
                .clickable { onItemClick() }, // Make the card clickable
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
                        painter = painterResource(id = itemImage),
                        contentDescription = "Condition Image",
                        modifier = Modifier
                            .size(40.dp)
                            .clip(RoundedCornerShape(8.dp)) // You can change this to CircleShape if needed
                    )

                    Spacer(modifier = Modifier.width(16.dp))

                    // Condition Name
                    Text(
                        text = itemName, style = textStyle1.copy(
                            fontSize = 16.sp
                        )
                    )
                }
                Spacer(modifier = Modifier.weight(1F))
                // Information Icon
                Icon(
                    painter = painterResource(id = if (itemValue != 0) R.drawable.ic_info else R.drawable.baseline_done_24),
                    contentDescription = "Info Icon",
                    tint = if (itemValue != 0) Color.Red else Color.Green,
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
                .clickable { onItemClick() }) {
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
                    text = "${percentage}%", style = textStyle1.copy(
                        fontSize = 14.sp
                    ), modifier = Modifier.padding(top = 5.dp)
                )
            }
        }
    }
}

