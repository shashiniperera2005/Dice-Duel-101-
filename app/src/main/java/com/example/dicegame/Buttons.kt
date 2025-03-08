//package com.example.dicegame
//
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.activity.enableEdgeToEdge
//import androidx.compose.foundation.background
////import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.*
//import androidx.compose.runtime.Composable
////import androidx.compose.runtime.remember
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import com.example.dicegame.ui.theme.DiceGameTheme
//import com.example.dicegame.ui.theme.color1
//
//class AboutActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//            DiceGameTheme {
//                AboutScreen { finish() } // Close activity on button click
//            }
//        }
//    }
//}
//
//@Composable
//fun AboutScreen(onClose: () -> Unit) {
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(color1)), // Semi-transparent background
//        contentAlignment = Alignment.Center
//    ) {
//        Card(
//            shape = RoundedCornerShape(12.dp),
//            modifier = Modifier.padding(16.dp)
//        ) {
//            Column(
//                modifier = Modifier.padding(16.dp),
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Text(
//                    text = "About",
//                    fontSize = 22.sp,
//                    fontWeight = FontWeight.Bold
//                )
//
//                Spacer(modifier = Modifier.height(10.dp))
//
//                Text(
//                    text = "Student ID: 12345678\nJohn Smith",
//                    fontSize = 18.sp,
//                    fontWeight = FontWeight.Medium
//                )
//
//                Spacer(modifier = Modifier.height(10.dp))
//
//                Text(
//                    text = "I confirm that I understand what plagiarism is and have read and understood the section on Assessment Offences in the Essential Information for Students. The work that I have submitted is entirely my own. Any work from other authors is duly referenced and acknowledged.",
//                    fontSize = 14.sp,
//                    modifier = Modifier
//                        .background(Color.LightGray.copy(alpha = 0.3f), shape = RoundedCornerShape(8.dp))
//                        .padding(10.dp)
//                )
//
//                Spacer(modifier = Modifier.height(20.dp))
//
//                Button(
//                    onClick = { onClose() },
//                    colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
//                ) {
//                    Text(text = "Close", color = Color.White)
//                }
//            }
//        }
//    }
//}
//
//@Preview
//@Composable
//fun AboutScreenPreview() {
//    DiceGameTheme {
//        AboutScreen {}
//    }
//}
package com.example.dicegame

//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.activity.enableEdgeToEdge
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.*
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Brush
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import com.example.dicegame.ui.theme.DiceGameTheme
//import com.example.dicegame.ui.theme.Pink40
//import com.example.dicegame.ui.theme.Pink80
//import com.example.dicegame.ui.theme.Purple80
//import com.example.dicegame.ui.theme.color1
//import com.example.dicegame.ui.theme.color2
//import com.example.dicegame.ui.theme.color3
//import com.example.dicegame.ui.theme.color4
//import com.example.dicegame.ui.theme.color5
//import com.example.dicegame.ui.theme.color6
//
//
//class AboutActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//            DiceGameTheme {
//                AboutScreen { finish() } // Close activity on button click
//            }
//        }
//    }
//}
//
//@Composable
//fun AboutScreen(onClose: () -> Unit) {
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(color3),
//        contentAlignment = Alignment.Center
//    ) {
//        Box( // ✅ Wrap Card inside a Box with gradient background
//            modifier = Modifier
//                .padding(20.dp)
//                .background(
//                    brush = Brush.linearGradient(listOf(color1, color5)),
//                    shape = RoundedCornerShape(15.dp)
//                )
//        ) {
//            Card(
//                shape = RoundedCornerShape(15.dp),
//                colors = CardDefaults.cardColors(containerColor = Color.Transparent), // ✅ Set card background to transparent
//                modifier = Modifier.fillMaxWidth()
//            ) {
//                Column(
//                    modifier = Modifier.padding(20.dp),
//                    horizontalAlignment = Alignment.CenterHorizontally
//                ) {
//                    Text(
//                        text = "About",
//                        fontSize = 25.sp,
//                        fontWeight = FontWeight.Bold,
//                        color = Color.White
//                    )
//
//                    Spacer(modifier = Modifier.height(30.dp))
//
//                    Text(
//                        text = "Student ID: 20230303\nStudent Name: Shashini Perera",
//                        fontSize = 15.sp,
//                        fontWeight = FontWeight.Medium,
//                        color = Color.White
//                    )
//
//                    Spacer(modifier = Modifier.height(30.dp))
//
//                    Text(
//                        text = "I confirm that I understand what plagiarism is and have read and understood the section on " +
//                                "Assessment Offences in the Essential Information for Students." +
//                                " The work that I have submitted is entirely my own. Any work from other authors is " +
//                                "duly referenced and acknowledged.",
//                        fontSize = 14.sp,
//                        modifier = Modifier
//                            .background(
//                                brush = Brush.linearGradient(listOf(color4, color5)),
//                                shape = RoundedCornerShape(8.dp)
//                            )
//                            .padding(20.dp),
//                        color = Color.White
//                    )
//
//                    Spacer(modifier = Modifier.height(20.dp))
//
//                    Button(
//                        onClick = { onClose() },
//                        colors = ButtonDefaults.buttonColors(containerColor = color6)
//                    ) {
//                        Text(text = "Close", color = Color.White)
//                    }
//                }
//            }
//        }
//    }
//}
//
//
//
//
//@Preview
//@Composable
//fun AboutScreenPreview() {
//    DiceGameTheme {
//        AboutScreen {}
//    }
//}
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.window.Dialog
//@Composable
//fun AboutDialog(onDismiss: () -> Unit) {
//    Dialog(onDismissRequest = onDismiss) {
//        Surface(
//            shape = MaterialTheme.shapes.medium,
//            tonalElevation = 8.dp,
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(16.dp)
//        ) {
//            Column(
//                modifier = Modifier
//                    .background(Color.White)
//                    .padding(16.dp),
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Text("Author: John Doe", style = MaterialTheme.typography.bodyLarge)
//                Text("Student ID: 12345678", style = MaterialTheme.typography.bodyMedium)
//                Spacer(modifier = Modifier.height(16.dp))
//                Text(
//                    "I confirm that I understand what plagiarism is and have read " +
//                            "and understood the section on Assessment Offences in the Essential " +
//                            "Information for Students. The work that I have submitted is entirely my own. " +
//                            "Any work from other authors is duly referenced and acknowledged.",
//                    style = MaterialTheme.typography.bodySmall
//                )
//                Spacer(modifier = Modifier.height(16.dp))
//                Button(onClick = onDismiss) {
//                    Text("Close")
//                }
//            }
//        }
//    }
//}
//package com.example.dicegame

import android.content.Intent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
//import com.example.dicegame.GameActivity

@Composable
fun ButtonsScreen(mainActivity: androidx.activity.ComponentActivity) {
    var showDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Title
        Text(
            text = "Dice Game",
            fontSize = 32.sp
        )

        Spacer(modifier = Modifier.height(32.dp))

        // "NEW GAME" Button
        Button(
            onClick = {
                val intent = Intent(mainActivity, GameActivity::class.java)
                mainActivity.startActivity(intent)
            }) {
            Text(text = "NEW GAME", fontSize = 18.sp)
        }

        Spacer(modifier = Modifier.height(10.dp))

        // "ABOUT" Button (Standard Button without Gradient)
        Button(
            onClick = { showDialog = true }
        ) {
            Text(text = "ABOUT", fontSize = 18.sp)
        }

        if (showDialog) {
            AboutDialog { showDialog = false }
        }
    }
}

@Composable
fun AboutDialog(onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("About the Author") },
        text = {
            Column {
                Text("Name: Shashini Perera", fontSize = 16.sp)
                Text("Student ID: 20230303", fontSize = 16.sp)
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    "I confirm that I understand what plagiarism is and have read " +
                            "and understood the section on Assessment Offences in the Essential " +
                            "Information for Students. The work that I have submitted is entirely my own. " +
                            "Any work from other authors is duly referenced and acknowledged.",
                    fontSize = 14.sp
                )
            }
        },
        confirmButton = {
            Button(onClick = onDismiss) {
                Text("Close")
            }
        }
    )
}
