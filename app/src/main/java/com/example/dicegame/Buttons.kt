
package com.example.dicegame

import android.content.Intent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ButtonsScreen(onStartGame: (Int) -> Unit) {
    var showDialog by remember { mutableStateOf(false) } // Controls visibility of AboutDialog
    var showTargetDialog by remember { mutableStateOf(false) } // Controls visibility of TargetScoreDialog

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Dice Game", fontSize = 32.sp)
        Spacer(modifier = Modifier.height(32.dp))

        // Button to start a new game
        Button(
            onClick = { showTargetDialog = true }, // Opens Target Score Dialog
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF494786)),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.width(355.dp)
        ) {
            Text(text = "NEW GAME", fontSize = 18.sp)
        }

        Spacer(modifier = Modifier.height(10.dp))

        // Button to show "About" dialog
        Button(
            onClick = { showDialog = true }, // Opens About Dialog
            colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.width(355.dp)
        ) {
            Text(text = "ABOUT", fontSize = 18.sp)
        }

        // Show the About Dialog if showDialog is true
        if (showDialog) {
            AboutDialog { showDialog = false }
        }

        // Show the Target Score Dialog if showTargetDialog is true
        if (showTargetDialog) {
            TargetScoreDialog(
                onDismiss = { showTargetDialog = false },
                onStartGame = { targetScore ->
                    onStartGame(targetScore) // Pass target score to the game
                }
            )
        }
    }
}

@Composable
fun AboutDialog(onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss, // Dismiss dialog when clicking outside
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
            // Close button to dismiss dialog
            Button(
                onClick = onDismiss,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF494786))
            ) {
                Text("Close", color = Color.White)
            }
        }
    )
}

@Composable
fun TargetScoreDialog(onDismiss: () -> Unit, onStartGame: (Int) -> Unit) {
    var input by remember { mutableStateOf("") } // Holds user input
    var showError by remember { mutableStateOf(false) } // Tracks if the input is invalid

    AlertDialog(
        onDismissRequest = onDismiss, // Dismiss dialog when clicking outside
        title = { Text("Set Target Score") },
        text = {
            Column {
                Text("Enter target score (default is 101):")
                TextField(
                    value = input,
                    onValueChange = {
                        // Allow only digits and validate input
                        if (it.all { char -> char.isDigit() } || it.isEmpty()) {
                            input = it
                            showError = false
                        } else {
                            showError = true
                        }
                    },
                    placeholder = { Text("101") },
                    singleLine = true,
                    isError = showError
                )
                if (showError) {
                    Text("Only numbers are allowed!", color = Color.Red, fontSize = 12.sp)
                } else if (input.isEmpty()) {
                    Text("Default will be 101 if left empty", color = Color.Gray, fontSize = 12.sp)
                }
            }
        },
        confirmButton = {
            // Button to start the game with the entered target score
            Button(
                onClick = {
                    val score = input.toIntOrNull() ?: 101 // Default to 101 if empty
                    onStartGame(score) // Pass the score to start the game
                    onDismiss() // Close dialog
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF494786))
            ) {
                Text(text = "Start Game", color = Color.White)
            }
        },
        dismissButton = {
            // Button to cancel and close dialog
            Button(
                onClick = onDismiss,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF494786))
            ) {
                Text("Cancel", color = Color.White)
            }
        }
    )
}

