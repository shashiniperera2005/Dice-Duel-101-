//package com.example.dicegame
//
//import android.content.Intent
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.activity.enableEdgeToEdge
//import androidx.compose.foundation.layout.* // Import Row, Column, Box, etc.
//import androidx.compose.material3.Text
//import androidx.compose.ui.graphics.Brush
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import com.example.dicegame.ui.theme.DiceGameTheme
//import com.example.dicegame.ui.theme.color1
//import com.example.dicegame.ui.theme.color2
//import android.content.Intent
//
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//            DiceGameTheme {
//                // Import androidx.compose.foundation.layout.*
//                Column(
//                    modifier = Modifier.fillMaxSize(),
//                    verticalArrangement=  Arrangement.Center,
//                    horizontalAlignment = Alignment.CenterHorizontally
//                ) {
//                    Text(
//                        text = "Dice Game",
//                        fontSize = 32.sp,
//                        fontWeight = FontWeight.Bold,
//                        color = Color.Black
//
//                    )
//
//                    Spacer(
//                        modifier = Modifier.height(32.dp)
//                    )
//                    GradientButton(
//                        text = "New Game",
//                        textColor = Color.White,
//                        gradient = Brush.horizontalGradient(
//                            colors = listOf(color1, color2)
//                        ),
//                        onClick = {}
//                    )
//                    Spacer(
//                        modifier = Modifier.height(10.dp)
//                    )
//                    GradientButton(
//                        text = "About",
//                        textColor = Color.White,
//                        gradient = Brush.horizontalGradient(
//                            colors = listOf(color1, color2)
//                        ),
//                        onClick = {
//                            val intent = Intent(this, AboutActivity::class.java)
//                            startActivity(intent)
//                        }
//                    )
//                }
//            }
//        }
//    }
//}
package com.example.dicegame

import android.content.Intent  // ✅ Keep only one import
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.* // Import Row, Column, Box, etc.
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dicegame.ui.theme.DiceGameTheme
import com.example.dicegame.ui.theme.color1
import com.example.dicegame.ui.theme.color2

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DiceGameTheme {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement=  Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Dice Game",
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.height(32.dp))

                    // In MainActivity.kt, modify the GradientButton for "New Game":
                    GradientButton(
                        text = "New Game",
                        textColor = Color.White,
                        gradient = Brush.horizontalGradient(
                            colors = listOf(color1, color2)
                        ),
                        onClick = {
                            val intent = Intent(this@MainActivity, GameActivity::class.java)
                            startActivity(intent)
                        }
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    GradientButton(
                        text = "About",
                        textColor = Color.White,
                        gradient = Brush.horizontalGradient(
                            colors = listOf(color1, color2)
                        ),
                        onClick = {
                            val intent = Intent(this@MainActivity, AboutActivity::class.java)
                            startActivity(intent)
                        }
                    )
                }
            }
        }
    }
}



