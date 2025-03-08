//package com.example.dicegame
//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material3.Button
//import androidx.compose.material3.ButtonDefaults
//import androidx.compose.material3.Text // Import the correct Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Brush
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.unit.dp
//
//@Composable
//fun GradientButton(
//    text: String,
//    textColor: Color,
//    gradient: Brush,
//    onClick: () -> Unit
//) {
//    Button(
//        colors = ButtonDefaults.buttonColors(
//            containerColor = Color.Transparent // Use containerColor instead of backgroundColor
//        ),
//        onClick = { onClick() }
//    ) {
//        Box(
//            modifier = Modifier
//                .background(gradient)
//                .padding(horizontal = 16.dp, vertical = 8.dp),
//            contentAlignment = Alignment.Center
//        ) {
//            Text(text = text, color = textColor) // Corrected Text component
//        }
//    }
//}
//package com.example.dicegame
//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Brush
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//
//@Composable
//fun GradientButton(
//    text: String,
//    textColor: Color,
//    gradient: Brush,
//    onClick: () -> Unit
//) {
//    Box(
//        modifier = Modifier
//            .width(350.dp) // Set fixed width for consistency
//            .height(45.dp) // Set fixed height
//            .background(gradient, shape = RoundedCornerShape(12.dp)) // Rounded corners
//            .clickable(onClick = onClick), // Clickable effect
//        contentAlignment = Alignment.Center
//    ) {
//        Text(
//            text = text,
//            color = textColor,
//            fontSize = 18.sp, // Slightly larger text for visibility
//            fontWeight = if (text == "NEW GAME" || text == "ABOUT") FontWeight.Bold else FontWeight.Normal // Bold for both buttons
//        )
//    }
//}
package com.example.dicegame.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dicegame.ui.theme.color1
import com.example.dicegame.ui.theme.color2

@Composable
fun GradientButton(
    text: String,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .background(
                Brush.horizontalGradient(
                    colors = listOf(color1, color2)
                )
            )
            .clickable(onClick = onClick)
            .padding(vertical = 12.dp, horizontal = 24.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(text = text, color = Color.White, fontSize = 18.sp)
    }
}
