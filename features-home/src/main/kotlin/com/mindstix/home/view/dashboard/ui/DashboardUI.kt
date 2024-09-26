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

    val diagnosisItems = listOf(
        DiagnosisListItemData(
            "Acne",
            firstItem.acneValue,
            R.drawable.ic_acne,
            firstItem.acneConfidence
        ),
        DiagnosisListItemData(
            "Black Heads",
            firstItem.blackheadValue,
            R.drawable.ic_acne1,
            firstItem.blackheadConfidence
        ),
        DiagnosisListItemData(
            "Dark Circle",
            firstItem.darkCircleValue,
            R.drawable.ic_acne2,
            firstItem.darkCircleConfidence
        ),
        DiagnosisListItemData(
            "Eye Pouch",
            firstItem.eyePouchValue,
            R.drawable.ic_acne3,
            firstItem.eyePouchConfidence
        ),
        DiagnosisListItemData(
            "EyeFine Lines",
            firstItem.eyeFinelinesValue,
            R.drawable.ic_acne4,
            firstItem.eyeFinelinesConfidence
        ),
        DiagnosisListItemData(
            "Forehead Wrinkle",
            firstItem.foreheadWrinkleValue,
            R.drawable.ic_acne1,
            firstItem.foreheadWrinkleConfidence
        ),
        DiagnosisListItemData(
            "Forehead Pores",
            firstItem.poresForeheadValue,
            R.drawable.ic_acne3,
            firstItem.poresForeheadConfidence
        ),
        DiagnosisListItemData(
            "RightCheek Pores",
            firstItem.poresRightCheekValue,
            R.drawable.ic_acne4,
            firstItem.poresRightCheekConfidence
        ),
        DiagnosisListItemData(
            "LeftCheek Pores",
            firstItem.poresLeftCheekValue,
            R.drawable.ic_acne,
            firstItem.poresLeftCheekConfidence
        ),
        DiagnosisListItemData(
            "Skin Spot",
            firstItem.skinSpotValue,
            R.drawable.ic_acne1,
            firstItem.skinSpotConfidence
        ),
        DiagnosisListItemData(
            "Nasolabial Fold",
            firstItem.nasolabialFoldValue,
            R.drawable.ic_acne2,
            firstItem.nasolabialFoldConfidence
        ),
        DiagnosisListItemData(
            "Jaw Pores",
            firstItem.poresJawValue,
            R.drawable.ic_acne3,
            firstItem.poresJawConfidence
        ),
        DiagnosisListItemData(
            "Left Eyelids",
            firstItem.leftEyelidsValue,
            R.drawable.ic_acne4,
            firstItem.leftEyelidsConfidence
        ),
        DiagnosisListItemData(
            "Crows Feet",
            firstItem.crowsFeetValue,
            R.drawable.ic_acne,
            firstItem.crowsFeetConfidence
        ),
        DiagnosisListItemData(
            "Glabella Wrinkle",
            firstItem.glabellaWrinkleValue,
            R.drawable.ic_acne1,
            firstItem.glabellaWrinkleConfidence
        ),
        DiagnosisListItemData(
            "Mole",
            firstItem.moleValue,
            R.drawable.ic_acne2,
            firstItem.moleConfidence
        ),
        DiagnosisListItemData(
            "Right Eyelids",
            firstItem.rightEyelidsValue,
            R.drawable.ic_acne3,
            firstItem.rightEyelidsConfidence
        )
    )

    // Sort the list by confidence, descending
    val sortedItems = diagnosisItems.sortedByDescending { it.itemValue }

    LazyColumn(
        modifier = Modifier.height(300.dp),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(sortedItems) { item ->
            DiagnosisListItem(
                itemName = item.itemName,
                itemValue = item.itemValue,
                itemImage = item.itemImage,
                itemConfidence = item.itemConfidence,
                onItemClick = {
                }
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


data class DiagnosisListItemData(
    val itemName: String,
    val itemValue: Int,
    val itemImage: Int,
    val itemConfidence: Double
)

data class DialogBoxDataModel(
    val dialogTitle: String,
    val dialogDesc: String
)

