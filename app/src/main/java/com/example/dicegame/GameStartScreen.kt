package com.example.dicegame

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

@Composable
fun GameStartScreen(
    onBackPressed: () -> Unit,
    targetScore: Int = 101,
    onGameEnd: (humanWon: Boolean) -> Unit = {}
) {
    // State variables to track the game state such as dice values, scores, and roll count
    var humanDiceValues by rememberSaveable { mutableStateOf(List(5) { Random.nextInt(1, 7) }) }
    var computerDiceValues by rememberSaveable { mutableStateOf(List(5) { Random.nextInt(1, 7) }) }
    var rollCount by rememberSaveable { mutableStateOf(0) }
    var humanScore by rememberSaveable { mutableStateOf(0) }
    var computerScore by rememberSaveable { mutableStateOf(0) }
    var lockedDice by rememberSaveable { mutableStateOf(List(5) { false }) }
    var showDialog by remember { mutableStateOf(false) }
    var dialogMessage by remember { mutableStateOf("") }
    var dialogColor by remember { mutableStateOf(Color.Transparent) }
    var gameEnded by remember { mutableStateOf(false) }
    var tieBreakMode by remember { mutableStateOf(false) }
    var useStrategicAI by rememberSaveable { mutableStateOf(true) }

    // Track round wins
    var humanRoundWins by rememberSaveable { mutableStateOf(0) }
    var computerRoundWins by rememberSaveable { mutableStateOf(0) }

    // Track tie-breaker wins
    var humanTieWins by remember { mutableStateOf(0) }
    var computerTieWins by remember { mutableStateOf(0) }

    // Get current orientation
    val configuration = LocalConfiguration.current
    val isLandscape = configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

    // Use different layouts based on orientation
    if (isLandscape) {
        // Landscape layout: displays game components horizontally
        LandscapeGameLayout(
            humanDiceValues = humanDiceValues,
            computerDiceValues = computerDiceValues,
            lockedDice = lockedDice,
            onDiceClick = { index ->
                if (rollCount > 0 && rollCount < 3 && !gameEnded && !tieBreakMode) {
                    lockedDice = lockedDice.toMutableList().apply { this[index] = !this[index] }
                }
            },
            rollCount = rollCount,
            humanScore = humanScore,
            computerScore = computerScore,
            targetScore = targetScore,
            humanRoundWins = humanRoundWins,
            computerRoundWins = computerRoundWins,
            onBackPressed = onBackPressed,
            onThrowClick = { /* Handle throw click for both players */
                handleThrowClick(
                    gameEnded = gameEnded,
                    tieBreakMode = tieBreakMode,
                    rollCount = rollCount,
                    humanDiceValues = humanDiceValues,
                    computerDiceValues = computerDiceValues,
                    lockedDice = lockedDice,
                    humanScore = humanScore,
                    computerScore = computerScore,
                    targetScore = targetScore,
                    humanRoundWins = humanRoundWins,
                    computerRoundWins = computerRoundWins,
                    humanTieWins = humanTieWins,
                    computerTieWins = computerTieWins,
                    useStrategicAI = useStrategicAI,
                    onRollCountChange = { rollCount = it },
                    onHumanDiceValuesChange = { humanDiceValues = it },
                    onComputerDiceValuesChange = { computerDiceValues = it },
                    onLockedDiceChange = { lockedDice = it },
                    onHumanScoreChange = { humanScore = it },
                    onComputerScoreChange = { computerScore = it },
                    onHumanRoundWinsChange = { humanRoundWins = it },
                    onComputerRoundWinsChange = { computerRoundWins = it },
                    onHumanTieWinsChange = { humanTieWins = it },
                    onComputerTieWinsChange = { computerTieWins = it },
                    onGameEndedChange = { gameEnded = it },
                    onTieBreakModeChange = { tieBreakMode = it },
                    onShowDialogChange = { showDialog = it },
                    onDialogMessageChange = { dialogMessage = it },
                    onDialogColorChange = { dialogColor = it },
                    onGameEnd = onGameEnd
                )
            },
            onScoreClick = { /* Handle score click logic */
                handleScoreClick(
                    gameEnded = gameEnded,
                    tieBreakMode = tieBreakMode,
                    rollCount = rollCount,
                    humanDiceValues = humanDiceValues,
                    computerDiceValues = computerDiceValues,
                    humanScore = humanScore,
                    computerScore = computerScore,
                    targetScore = targetScore,
                    humanRoundWins = humanRoundWins,
                    computerRoundWins = computerRoundWins,
                    useStrategicAI = useStrategicAI,
                    onRollCountChange = { rollCount = it },
                    onHumanScoreChange = { humanScore = it },
                    onComputerScoreChange = { computerScore = it },
                    onHumanRoundWinsChange = { humanRoundWins = it },
                    onComputerRoundWinsChange = { computerRoundWins = it },
                    onComputerDiceValuesChange = { computerDiceValues = it },
                    onLockedDiceChange = { lockedDice = it },
                    onGameEndedChange = { gameEnded = it },
                    onTieBreakModeChange = { tieBreakMode = it },
                    onShowDialogChange = { showDialog = it },
                    onDialogMessageChange = { dialogMessage = it },
                    onDialogColorChange = { dialogColor = it },
                    onGameEnd = onGameEnd
                )
            },
            tieBreakMode = tieBreakMode,
            gameEnded = gameEnded
        )
    } else {
        // Portrait layout: displays game components vertically
        Column(
            modifier = Modifier.fillMaxSize().padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(15.dp))

            // Back button to navigate back from the game screen
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(onClick = onBackPressed) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.Black)
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            // Display the current round wins for human and computer players
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                Text("H:$humanRoundWins / C:$computerRoundWins", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }

            Spacer(modifier = Modifier.height(30.dp))

            // Display the target score and current scores of both players
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Target: $targetScore", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Text("Human: $humanScore | Computer: $computerScore", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }

            Spacer(modifier = Modifier.height(60.dp))

            // Display dice for the human player
            Column(modifier = Modifier.fillMaxWidth()) {
                Text("Human Player", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(20.dp))
                DiceRow(humanDiceValues, lockedDice, { index ->
                    if (rollCount > 0 && rollCount < 3 && !gameEnded && !tieBreakMode) {
                        lockedDice = lockedDice.toMutableList().apply { this[index] = !this[index] }
                    }
                }, rollCount)
            }

            Spacer(modifier = Modifier.height(50.dp))

            // Display dice for the computer player (locked dice are always false)
            Column(modifier = Modifier.fillMaxWidth()) {
                Text("Computer Player", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(20.dp))
                DiceRow(computerDiceValues, List(5) { false }, {})
            }

            Spacer(modifier = Modifier.height(60.dp))

            // Display game status and buttons
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                val rollStatus = when {
                    tieBreakMode -> "Tie Break"
                    rollCount == 0 -> "Initial Roll"
                    rollCount == 1 -> "Reroll 1"
                    rollCount == 2 -> "Reroll 2"
                    else -> ""
                }

                Text(rollStatus, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Black)
                Spacer(modifier = Modifier.height(20.dp))

                // Button to throw dice
                Button(
                    onClick = { /* Handle throw button logic */
                        handleThrowClick(
                            gameEnded = gameEnded,
                            tieBreakMode = tieBreakMode,
                            rollCount = rollCount,
                            humanDiceValues = humanDiceValues,
                            computerDiceValues = computerDiceValues,
                            lockedDice = lockedDice,
                            humanScore = humanScore,
                            computerScore = computerScore,
                            targetScore = targetScore,
                            humanRoundWins = humanRoundWins,
                            computerRoundWins = computerRoundWins,
                            humanTieWins = humanTieWins,
                            computerTieWins = computerTieWins,
                            useStrategicAI = useStrategicAI,
                            onRollCountChange = { rollCount = it },
                            onHumanDiceValuesChange = { humanDiceValues = it },
                            onComputerDiceValuesChange = { computerDiceValues = it },
                            onLockedDiceChange = { lockedDice = it },
                            onHumanScoreChange = { humanScore = it },
                            onComputerScoreChange = { computerScore = it },
                            onHumanRoundWinsChange = { humanRoundWins = it },
                            onComputerRoundWinsChange = { computerRoundWins = it },
                            onHumanTieWinsChange = { humanTieWins = it },
                            onComputerTieWinsChange = { computerTieWins = it },
                            onGameEndedChange = { gameEnded = it },
                            onTieBreakModeChange = { tieBreakMode = it },
                            onShowDialogChange = { showDialog = it },
                            onDialogMessageChange = { dialogMessage = it },
                            onDialogColorChange = { dialogColor = it },
                            onGameEnd = onGameEnd
                        )
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6366F1)),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.width(355.dp),
                    enabled = !gameEnded || tieBreakMode
                ) {
                    Text("Throw", color = Color.White, fontWeight = FontWeight.Bold)
                }

                Spacer(modifier = Modifier.height(15.dp))

                // Button to score points
                if (rollCount > 0) {
                    Button(
                        onClick = {  /* Handle score button logic */
                            handleScoreClick(
                                gameEnded = gameEnded,
                                tieBreakMode = tieBreakMode,
                                rollCount = rollCount,
                                humanDiceValues = humanDiceValues,
                                computerDiceValues = computerDiceValues,
                                humanScore = humanScore,
                                computerScore = computerScore,
                                targetScore = targetScore,
                                humanRoundWins = humanRoundWins,
                                computerRoundWins = computerRoundWins,
                                useStrategicAI = useStrategicAI,
                                onRollCountChange = { rollCount = it },
                                onHumanScoreChange = { humanScore = it },
                                onComputerScoreChange = { computerScore = it },
                                onHumanRoundWinsChange = { humanRoundWins = it },
                                onComputerRoundWinsChange = { computerRoundWins = it },
                                onComputerDiceValuesChange = { computerDiceValues = it },
                                onLockedDiceChange = { lockedDice = it },
                                onGameEndedChange = { gameEnded = it },
                                onTieBreakModeChange = { tieBreakMode = it },
                                onShowDialogChange = { showDialog = it },
                                onDialogMessageChange = { dialogMessage = it },
                                onDialogColorChange = { dialogColor = it },
                                onGameEnd = onGameEnd
                            )
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier.width(355.dp),
                        enabled = rollCount > 0 && !gameEnded && !tieBreakMode
                    ) {
                        Text("Score", color = Color.White, fontWeight = FontWeight.Bold)
                    }
                }
            }
            Spacer(modifier = Modifier.height(30.dp))
        }
    }
    // Show dialog when game ends
    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text("Game Over") },
            text = { Text(dialogMessage, color = dialogColor) },
            confirmButton = {
                Button(onClick = { showDialog = false }) {
                    Text("OK")
                }
            }
        )
    }
}

@Composable
fun LandscapeGameLayout(
    humanDiceValues: List<Int>,
    computerDiceValues: List<Int>,
    lockedDice: List<Boolean>,
    onDiceClick: (Int) -> Unit,
    rollCount: Int,
    humanScore: Int,
    computerScore: Int,
    targetScore: Int,
    humanRoundWins: Int,
    computerRoundWins: Int,
    onBackPressed: () -> Unit,
    onThrowClick: () -> Unit,
    onScoreClick: () -> Unit,
    tieBreakMode: Boolean,
    gameEnded: Boolean
) {
    Column(
        // Increase the start padding to avoid system navigation buttons
        modifier = Modifier.fillMaxSize().padding(start = 55.dp, end = 24.dp, top = 8.dp, bottom = 8.dp),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        // Top section with back button
        IconButton(
            onClick = onBackPressed,
            modifier = Modifier.align(Alignment.Start)
        ) {
            Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.Black)
        }

        // H: / C: round wins - now directly below back button
        Text(
            "H:$humanRoundWins / C:$computerRoundWins",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.Start).padding(start = 15.dp)
        )

        // Target score - now directly below H: / C:
        Row(
            modifier = Modifier.fillMaxWidth().padding(start = 15.dp, end = 30.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Target: $targetScore", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            Text("Human: $humanScore | Computer: $computerScore", fontSize = 16.sp, fontWeight = FontWeight.Bold)
        }

        // Middle section with dice displays
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            // Human player dice - aligned with previous elements
            Column(
                modifier = Modifier.weight(1f).padding(start = 15.dp, end = 30.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text("Human Player", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                DiceRow(humanDiceValues, lockedDice, onDiceClick, rollCount)
            }

            // Computer player dice
            Column(
                modifier = Modifier.weight(1f).padding(start = 15.dp, end = 30.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text("Computer Player", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                DiceRow(computerDiceValues, List(5) { false }, {})
            }
        }

        // Bottom section with game controls (vertical buttons)
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val rollStatus = when {
                tieBreakMode -> "Tie Break"
                rollCount == 0 -> "Initial Roll"
                rollCount == 1 -> "Reroll 1"
                rollCount == 2 -> "Reroll 2"
                else -> ""
            }

            Text(rollStatus, fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.Black)

            Spacer(modifier = Modifier.height(8.dp))

            // Throw button
            Button(
                onClick = onThrowClick,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6366F1)),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.width(300.dp),
                enabled = !gameEnded || tieBreakMode
            ) {
                Text("Throw", color = Color.White, fontWeight = FontWeight.Bold)
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Score button (always visible, but disabled when needed)
            if (rollCount > 0 && !gameEnded && !tieBreakMode) {
                Button(
                    onClick = onScoreClick,
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.width(300.dp)
                ) {
                    Text("Score", color = Color.White, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

@Composable
fun DiceRow(
    diceValues: List<Int>,  // List of dice values to be displayed
    lockedDice: List<Boolean>,  // List indicating whether each die is locked or not
    onDiceClick: (Int) -> Unit,  // Callback to handle click on a dice (which will lock/unlock it)
    rollCount: Int = 0  // The current number of rolls (used to determine whether dice can be clicked)
) {
    // A Row composable to arrange the dice horizontally and center them on the screen
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {

        // Iterate through each dice value and render the dice image
        diceValues.forEachIndexed { index, diceValue ->

            // Box composable that wraps the dice image and makes it clickable
            Box(
                modifier = Modifier
                    // Only enable clicks after the first roll (rollCount > 0)
                    .clickable(enabled = rollCount > 0) { onDiceClick(index) }
                    // Set background color to blue if the dice is locked, otherwise transparent
                    .background(if (lockedDice[index]) Color.Blue else Color.Transparent)
            ) {
                // Display the dice image based on its value
                Image(
                    painter = painterResource(id = getDiceDrawable(diceValue)),  // Load the image resource corresponding to the dice value
                    contentDescription = "Dice $diceValue",  // Accessibility label for the dice image
                    modifier = Modifier.size(65.dp)  // Set size of each dice image
                )
            }
            // Add some space between the dice images
            Spacer(modifier = Modifier.width(8.dp))
        }
    }
}

// Fixed handleThrowClick function
private fun handleThrowClick(
    gameEnded: Boolean,
    tieBreakMode: Boolean,
    rollCount: Int,
    humanDiceValues: List<Int>,
    computerDiceValues: List<Int>,
    lockedDice: List<Boolean>,
    humanScore: Int,
    computerScore: Int,
    targetScore: Int,
    humanRoundWins: Int,
    computerRoundWins: Int,
    humanTieWins: Int,
    computerTieWins: Int,
    useStrategicAI: Boolean,
    onRollCountChange: (Int) -> Unit,
    onHumanDiceValuesChange: (List<Int>) -> Unit,
    onComputerDiceValuesChange: (List<Int>) -> Unit,
    onLockedDiceChange: (List<Boolean>) -> Unit,
    onHumanScoreChange: (Int) -> Unit,
    onComputerScoreChange: (Int) -> Unit,
    onHumanRoundWinsChange: (Int) -> Unit,
    onComputerRoundWinsChange: (Int) -> Unit,
    onHumanTieWinsChange: (Int) -> Unit,
    onComputerTieWinsChange: (Int) -> Unit,
    onGameEndedChange: (Boolean) -> Unit,
    onTieBreakModeChange: (Boolean) -> Unit,
    onShowDialogChange: (Boolean) -> Unit,
    onDialogMessageChange: (String) -> Unit,
    onDialogColorChange: (Color) -> Unit,
    onGameEnd: (Boolean) -> Unit
) {
    if (gameEnded && !tieBreakMode) return

    // Handle tie-break mode
    if (tieBreakMode) {
        val newHumanDiceValues = List(5) { Random.nextInt(1, 7) }
        val newComputerDiceValues = List(5) { Random.nextInt(1, 7) }

        onHumanDiceValuesChange(newHumanDiceValues)
        onComputerDiceValuesChange(newComputerDiceValues)

        val humanTBScore = newHumanDiceValues.sum()
        val computerTBScore = newComputerDiceValues.sum()

        // Determine tie-break winner
        if (humanTBScore != computerTBScore) {
            val humanWon = humanTBScore > computerTBScore
            onDialogMessageChange(if (humanWon) "You win tie-break!" else "You lose tie-break!")
            onDialogColorChange(if (humanWon) Color.Green else Color.Red)
            onShowDialogChange(true)
            onGameEndedChange(true)
            onTieBreakModeChange(false)
            onGameEnd(humanWon)

            // Update win counts
            if (humanWon) {
                onHumanTieWinsChange(humanTieWins + 1)
                onHumanRoundWinsChange(humanRoundWins + 1)
            } else {
                onComputerTieWinsChange(computerTieWins + 1)
                onComputerRoundWinsChange(computerRoundWins + 1)
            }
        }
        return
    }

    // Handle first or reroll
    if (rollCount == 0) {
        val newHumanDiceValues = List(5) { Random.nextInt(1, 7) }
        val newComputerDiceValues = List(5) { Random.nextInt(1, 7) }

        onHumanDiceValuesChange(newHumanDiceValues)
        onComputerDiceValuesChange(newComputerDiceValues)
        onRollCountChange(1)
        onLockedDiceChange(List(5) { false })
    } else if (rollCount < 3) {
        // Reroll unlocked dice for human
        val newHumanDiceValues = humanDiceValues.mapIndexed { index, value ->
            if (lockedDice[index]) value else Random.nextInt(1, 7)
        }

        // Reroll for computer
        val newComputerDiceValues = if (useStrategicAI) {
            strategicComputerTurn(computerDiceValues, humanScore, computerScore)
        } else {
            randomComputerTurn(computerDiceValues)
        }

        onHumanDiceValuesChange(newHumanDiceValues)
        onComputerDiceValuesChange(newComputerDiceValues)
        onRollCountChange(rollCount + 1)

        // If final roll, calculate scores and check for winner
        if (rollCount + 1 == 3) {
            val humanRoundScore = newHumanDiceValues.sum()
            val computerRoundScore = newComputerDiceValues.sum()

            val newHumanScore = humanScore + humanRoundScore
            val newComputerScore = computerScore + computerRoundScore

            onHumanScoreChange(newHumanScore)
            onComputerScoreChange(newComputerScore)

            // Update round wins
            if (humanRoundScore > computerRoundScore) {
                onHumanRoundWinsChange(humanRoundWins + 1)
            } else if (humanRoundScore < computerRoundScore) {
                onComputerRoundWinsChange(computerRoundWins + 1)
            }

            // Check if game is over
            checkForWinner(newHumanScore, newComputerScore, targetScore) { humanWon, isTie ->
                if (isTie) {
                    onTieBreakModeChange(true)
                } else {
                    onDialogMessageChange(if (humanWon) "You win!" else "You lose!")
                    onDialogColorChange(if (humanWon) Color.Green else Color.Red)
                    onShowDialogChange(true)
                    onGameEndedChange(true)
                    onGameEnd(humanWon)
                }
            }

            // Reset for next round if game isn't over
            if (!gameEnded && !tieBreakMode) {
                onRollCountChange(0)
                onLockedDiceChange(List(5) { false })
            }
        }
    }
}


// Function to handle the click on the score, manage game logic, and update UI components accordingly
private fun handleScoreClick(
    gameEnded: Boolean,  // Whether the game has ended
    tieBreakMode: Boolean,  // Whether the game is in tie-break mode
    rollCount: Int,  // The current roll count for the turn
    humanDiceValues: List<Int>,  // The current dice values for the human player
    computerDiceValues: List<Int>,  // The current dice values for the computer player
    humanScore: Int,  // The total score of the human player
    computerScore: Int,  // The total score of the computer player
    targetScore: Int,  // The target score to win the game
    humanRoundWins: Int,  // Number of rounds won by the human player
    computerRoundWins: Int,  // Number of rounds won by the computer player
    useStrategicAI: Boolean,  // Whether the computer uses strategic AI for its turn
    onRollCountChange: (Int) -> Unit,  // Callback to update the roll count
    onHumanScoreChange: (Int) -> Unit,  // Callback to update the human score
    onComputerScoreChange: (Int) -> Unit,  // Callback to update the computer score
    onHumanRoundWinsChange: (Int) -> Unit,  // Callback to update the human round wins
    onComputerRoundWinsChange: (Int) -> Unit,  // Callback to update the computer round wins
    onComputerDiceValuesChange: (List<Int>) -> Unit,  // Callback to update the computer's dice values
    onLockedDiceChange: (List<Boolean>) -> Unit,  // Callback to update locked dice states
    onGameEndedChange: (Boolean) -> Unit,  // Callback to indicate if the game has ended
    onTieBreakModeChange: (Boolean) -> Unit,  // Callback to enable or disable tie-break mode
    onShowDialogChange: (Boolean) -> Unit,  // Callback to show or hide dialog
    onDialogMessageChange: (String) -> Unit,  // Callback to update dialog message
    onDialogColorChange: (Color) -> Unit,  // Callback to update dialog color
    onGameEnd: (Boolean) -> Unit  // Callback to end the game
) {
    // Exit early if the game has ended, if we're in tie-break mode, or if there are no rolls left
    if (gameEnded || tieBreakMode || rollCount <= 0) return

    // Calculate the total score for the human player based on their dice values
    val humanRoundScore = humanDiceValues.sum()

    // Simulate the computer's remaining rolls and get updated dice values
    var updatedComputerDiceValues = computerDiceValues.toList()

    // Determine how many more rolls the computer can make (up to 3 total rolls)
    val remainingRolls = 3 - rollCount
    println("Computer has $remainingRolls remaining rolls")

    // Simulate the computer's rolls (based on whether it uses strategic AI or random strategy)
    for (i in 0 until remainingRolls) {
        println("Computer roll #${i + 1}")
        updatedComputerDiceValues = if (useStrategicAI) {
            // Strategic AI turn: computer chooses dice based on human score and its own score
            strategicComputerTurn(updatedComputerDiceValues, humanScore, computerScore)
        } else {
            // Random turn: computer picks dice randomly
            randomComputerTurn(updatedComputerDiceValues)
        }
    }

    // Update the computer's dice display in the UI
    println("Final computer dice: $updatedComputerDiceValues")
    onComputerDiceValuesChange(updatedComputerDiceValues)

    // Calculate the total score for the computer based on its final dice values
    val computerRoundScore = updatedComputerDiceValues.sum()
    println("Computer round score: $computerRoundScore")

    // Update the total scores for both players
    val newHumanScore = humanScore + humanRoundScore
    val newComputerScore = computerScore + computerRoundScore
    onHumanScoreChange(newHumanScore)
    onComputerScoreChange(newComputerScore)

    // Update the round wins based on who has the higher score for this round
    if (humanRoundScore > computerRoundScore) {
        onHumanRoundWinsChange(humanRoundWins + 1)
    } else if (humanRoundScore < computerRoundScore) {
        onComputerRoundWinsChange(computerRoundWins + 1)
    }

    // Check if the game is over (either player has reached or exceeded the target score)
    checkForWinner(
        newHumanScore,
        newComputerScore,
        targetScore
    ) { humanWon, isTie ->
        if (isTie) {
            // If the game is a tie, switch to tie-break mode
            onTieBreakModeChange(true)
        } else {
            // If the game has a winner, display the result in a dialog
            onDialogMessageChange(if (humanWon) "You win!" else "You lose!")
            onDialogColorChange(if (humanWon) Color.Green else Color.Red)
            onShowDialogChange(true)
            onGameEndedChange(true)
            onGameEnd(humanWon)
        }
    }

    // Reset for the next round if the game is still ongoing
    if (!gameEnded && !tieBreakMode) {
        // Reset the roll count and locked dice for the next round
        onRollCountChange(0)
        onLockedDiceChange(List(5) { false })  // Reset all dice to unlocked
    }
}


// Improved random computer strategy according to the question 12
fun randomComputerTurn(diceValues: List<Int>): List<Int> {
    // Always reroll at least one die to make it visible that something changed
    val diceToKeep = List(5) { index ->
        if (index == Random.nextInt(0, 5)) false else Random.nextBoolean()
    }

    return diceValues.mapIndexed { index, value ->
        if (!diceToKeep[index]) Random.nextInt(1, 7) else value
    }
}

// strategic computer strategy
fun strategicComputerTurn(diceValues: List<Int>, humanScore: Int, computerScore: Int): List<Int> {
    // Debug print to verify function is being called
    // println("Strategic computer turn called")

    // Create a copy of the dice values
    val currentDice = diceValues.toList()

    // Determine game state
    val isLosing = computerScore < humanScore
    val isCloseToWinning = computerScore + currentDice.sum() >= 101

    // Strategic decision making - IMPORTANT: we need to actually change values here
    return currentDice.mapIndexed { index, die ->
        val shouldReroll = when {
            die >= 5 -> false  // Always keep high value dice (5 and 6)
            isLosing && die < 3 -> true  // Take more risks when losing
            isCloseToWinning && die < 4 -> true  // Be more conservative when close to winning
            else -> false  // Otherwise, keep the die
        }

        if (shouldReroll) {
            val newValue = Random.nextInt(1, 7)
            println("Strategic reroll: die $index from $die to $newValue")
            newValue
        } else {
            println("Strategic keep: die $index with value $die")
            die
        }
    }
}

/**
 * Strategic AI Implementation for Computer Player
 *
 * This function implements an efficient strategy for the computer player to decide
 * which dice to keep and which to reroll based on the current game state and dice values.
 *
 * Strategy Overview:
 * 1. Keep high-value dice (5s and 6s) regardless of game state
 * 2. Adapt rerolling behavior based on whether the computer is:
 *    - Losing (more aggressive rerolling of low values)
 *    - Close to winning (more selective rerolling)
 *    - In a neutral position (balanced approach)
 *
 * Justification:
 * This strategy is based on probability theory and game state awareness. Since the maximum
 * value of a die is 6, keeping 5s and 6s is always beneficial as the probability of rolling
 * higher is zero or very low. For lower values, the decision depends on the game context.
 *
 * Expected Performance:
 * This strategy should outperform random play because it:
 * 1. Preserves high values that contribute significantly to the score
 * 2. Takes calculated risks when behind (rerolling more dice)
 * 3. Plays conservatively when close to winning (minimizing risk)
 *
 * Advantages:
 * 1. Simple to implement and computationally efficient
 * 2. Adapts to the current game state
 * 3. Makes decisions based on both immediate dice values and overall game context
 * 4. Balances risk-taking with conservative play based on situation
 *
 * Disadvantages:
 * 1. Does not consider the exact probability distribution of outcomes
 * 2. Lacks memory of previous rolls or patterns
 * 3. Does not directly counter the human player's strategy
 * 4. Uses fixed thresholds rather than dynamic calculations
 * 5. Does not consider the exact points needed to win in all scenarios
 **/

// Function to get the drawable resource for a given dice value
fun getDiceDrawable(value: Int): Int {
    // The 'when' expression checks the value of the dice and returns the corresponding drawable resource ID
    return when (value) {
        1 -> R.drawable.dice_1  // If the value is 1, return the drawable for dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6 //For any value other than 1 to 5 (i.e., 6), return the drawable for dice_6
    }
}
//Checks if there is a winner based on the current scores and target score.
private fun checkForWinner(
    humanScore: Int,
    computerScore: Int,
    targetScore: Int,
    onWinnerDetermined: (humanWon: Boolean, isTie: Boolean) -> Unit
) {
    // Check if either player has reached or exceeded the target score
    val humanReachedTarget = humanScore >= targetScore
    val computerReachedTarget = computerScore >= targetScore

    // If either player reaches the target, determine the winner
    if (humanReachedTarget || computerReachedTarget) {
        if (humanScore == computerScore) {
            onWinnerDetermined(false, true)  // It's a tie - check this first!
        } else if (humanScore > computerScore) {
            onWinnerDetermined(true, false)  // Human wins
        } else {
            onWinnerDetermined(false, false) // Computer wins
        }
    }
}




