package com.example.dicegame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.dicegame.ui.theme.DiceGameTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Enables edge-to-edge UI for a more immersive experience

        setContent {
            DiceGameTheme { // Applies the custom theme for styling
                // rememberSaveable retains state across configuration changes (e.g., screen rotation)
                var isGameScreen by rememberSaveable { mutableStateOf(false) } // Tracks if the game screen is active
                var targetScore by rememberSaveable { mutableStateOf(101) } // Stores the target score for the game

                // Surface provides a background container with a specific color
                Surface(
                    modifier = Modifier.fillMaxSize(), // Expands to fill the entire screen
                    color = Color.White // Sets the background color
                ) {
                    if (isGameScreen) {
                        // Show the GameStartScreen when the game starts
                        GameStartScreen(
                            targetScore = targetScore, // Pass the target score to the game screen
                            onBackPressed = { isGameScreen = false } // Switch back to the main screen when exiting the game
                        )
                    } else {
                        // Show the ButtonsScreen when on the main menu
                        ButtonsScreen(
                            onStartGame = { score -> // Callback when starting the game
                                targetScore = score // Update the target score
                                isGameScreen = true // Switch to the game screen
                            }
                        )
                    }
                }
            }
        }
    }
}

/**
 * References
 * 1. Function Types and Lambda Expressions in Kotlin:
 *    https://developer.android.com/codelabs/basic-android-kotlin-compose-function-types-and-lambda
 * 2. Material Design Components for Compose:
 *    https://developer.android.com/reference/kotlin/androidx/compose/material3/package-summary
 * 3. Compose Layouts:
 *    https://developer.android.com/jetpack/compose/layouts
 * 4. Compose State Management:
 *    https://developer.android.com/jetpack/compose/state
 **/






