//package com.example.dicegame
//
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//
//@Composable
//fun GameScreen() {
//    var playerDice by remember { mutableStateOf(List(5) { 1 }) }
//    var computerDice by remember { mutableStateOf(List(5) { 1 }) }
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        // Title
//        Text(
//            text = "Dice Game",
//            style = MaterialTheme.typography.headlineMedium,
//            fontWeight = FontWeight.Bold
//        )
//        Text(
//            text = "Player vs Computer",
//            style = MaterialTheme.typography.bodyLarge,
//            modifier = Modifier.padding(bottom = 24.dp)
//        )
//
//        // Player's dice card
//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(bottom = 16.dp),
//            shape = RoundedCornerShape(8.dp),
//            colors = CardDefaults.cardColors(containerColor = Color.White)
//        ) {
//            Column(
//                modifier = Modifier.padding(16.dp)
//            ) {
//                Text(
//                    text = "Your Dice",
//                    style = MaterialTheme.typography.titleMedium,
//                    color = Color(0xFF2196F3)
//                )
//                Row(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(top = 8.dp),
//                    horizontalArrangement = Arrangement.SpaceBetween
//                ) {
//                    repeat(5) {
//                        DiceView(playerDice[it], Color(0xFF2196F3))
//                    }
//                }
//            }
//        }
//
//        // Computer's dice card
//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(bottom = 24.dp),
//            shape = RoundedCornerShape(8.dp),
//            colors = CardDefaults.cardColors(containerColor = Color.White)
//        ) {
//            Column(
//                modifier = Modifier.padding(16.dp)
//            ) {
//                Text(
//                    text = "Computer's Dice",
//                    style = MaterialTheme.typography.titleMedium,
//                    color = Color(0xFFE91E63)
//                )
//                Row(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(top = 8.dp),
//                    horizontalArrangement = Arrangement.SpaceBetween
//                ) {
//                    repeat(5) {
//                        DiceView(computerDice[it], Color(0xFFE91E63))
//                    }
//                }
//            }
//        }
//
//        // Buttons
//        Row(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.SpaceEvenly
//        ) {
//            Button(
//                onClick = {
//                    playerDice = List(5) { (1..6).random() }
//                    computerDice = List(5) { (1..6).random() }
//                },
//                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2196F3))
//            ) {
//                Text("Throw")
//            }
//            Button(
//                onClick = { /* TODO: Implement scoring */ },
//                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50))
//            ) {
//                Text("Score")
//            }
//        }
//    }
//}
//
//@Composable
//private fun DiceView(value: Int, color: Color) {
//    Surface(
//        modifier = Modifier.size(40.dp),
//        shape = RoundedCornerShape(4.dp),
//        color = color.copy(alpha = 0.1f)
//    ) {
//        Box(
//            contentAlignment = Alignment.Center
//        ) {
//            Text(
//                text = value.toString(),
//                color = color,
//                style = MaterialTheme.typography.titleMedium
//            )
//        }
//    }
//}
//package com.example.dicegame
//
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//
//@Composable
//fun GameScreen() {
//    var playerDice by remember { mutableStateOf(List(5) { 1 }) }
//    var computerDice by remember { mutableStateOf(List(5) { 1 }) }
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        // Title Section
//        Text(
//            text = "Dice Game",
//            fontSize = 24.sp,
//            fontWeight = FontWeight.Bold,
//            modifier = Modifier.padding(bottom = 4.dp)
//        )
//        Text(
//            text = "Player vs Computer",
//            fontSize = 16.sp,
//            color = Color.Gray,
//            modifier = Modifier.padding(bottom = 24.dp)
//        )
//
//        // Player's Section
//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(horizontal = 16.dp, vertical = 8.dp),
//            shape = RoundedCornerShape(12.dp),
//            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
//            colors = CardDefaults.cardColors(containerColor = Color.White)
//        ) {
//            Column(
//                modifier = Modifier.padding(16.dp)
//            ) {
//                Text(
//                    text = "Your Dice",
//                    color = Color(0xFF2196F3),
//                    fontWeight = FontWeight.Bold,
//                    fontSize = 18.sp,
//                    modifier = Modifier.padding(bottom = 12.dp)
//                )
//                Row(
//                    modifier = Modifier.fillMaxWidth(),
//                    horizontalArrangement = Arrangement.SpaceEvenly,
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//                    playerDice.forEach { value ->
//                        DiceView(value = value, isPlayer = true)
//                    }
//                }
//            }
//        }
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        // Computer's Section
//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(horizontal = 16.dp, vertical = 8.dp),
//            shape = RoundedCornerShape(12.dp),
//            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
//            colors = CardDefaults.cardColors(containerColor = Color.White)
//        ) {
//            Column(
//                modifier = Modifier.padding(16.dp)
//            ) {
//                Text(
//                    text = "Computer's Dice",
//                    color = Color(0xFFE91E63),
//                    fontWeight = FontWeight.Bold,
//                    fontSize = 18.sp,
//                    modifier = Modifier.padding(bottom = 12.dp)
//                )
//                Row(
//                    modifier = Modifier.fillMaxWidth(),
//                    horizontalArrangement = Arrangement.SpaceEvenly,
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//                    computerDice.forEach { value ->
//                        DiceView(value = value, isPlayer = false)
//                    }
//                }
//            }
//        }
//
//        Spacer(modifier = Modifier.weight(1f))
//
//        // Control Buttons
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(horizontal = 16.dp, vertical = 16.dp),
//            horizontalArrangement = Arrangement.SpaceEvenly
//        ) {
//            Button(
//                onClick = {
//                    playerDice = List(5) { (1..6).random() }
//                    computerDice = List(5) { (1..6).random() }
//                },
//                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2196F3)),
//                modifier = Modifier.weight(1f).padding(end = 8.dp)
//            ) {
//                Text(
//                    "Throw",
//                    color = Color.White,
//                    fontWeight = FontWeight.Bold
//                )
//            }
//
//            Button(
//                onClick = { /* TODO: Implement scoring */ },
//                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)),
//                modifier = Modifier.weight(1f).padding(start = 8.dp)
//            ) {
//                Text(
//                    "Score",
//                    color = Color.White,
//                    fontWeight = FontWeight.Bold
//                )
//            }
//        }
//    }
//}
//
//@Composable
//private fun DiceView(value: Int, isPlayer: Boolean) {
//    val backgroundColor = if (isPlayer) {
//        Color(0xFF2196F3).copy(alpha = 0.1f)
//    } else {
//        Color(0xFFE91E63).copy(alpha = 0.1f)
//    }
//
//    val textColor = if (isPlayer) {
//        Color(0xFF2196F3)
//    } else {
//        Color(0xFFE91E63)
//    }
//
//    Card(
//        modifier = Modifier
//            .size(45.dp)
//            .padding(4.dp),
//        shape = RoundedCornerShape(8.dp),
//        colors = CardDefaults.cardColors(containerColor = backgroundColor)
//    ) {
//        Box(
//            modifier = Modifier.fillMaxSize(),
//            contentAlignment = Alignment.Center
//        ) {
//            Text(
//                text = value.toString(),
//                color = textColor,
//                fontWeight = FontWeight.Bold,
//                fontSize = 18.sp
//            )
//        }
//    }
//}
package com.example.dicegame

//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.ArrowBack
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun GameScreen(onBackPressed: () -> Unit) {
//    var playerDice by remember { mutableStateOf(List(5) { 1 }) }
//    var computerDice by remember { mutableStateOf(List(5) { 1 }) }
//
//    Scaffold(
//        topBar = {
//            TopAppBar(
//                title = {
//                    Text(
//                        text = "Dice Game",
//                        fontWeight = FontWeight.Bold
//                    )
//                },
//                navigationIcon = {
//                    IconButton(onClick = onBackPressed) {
//                        Icon(
//                            imageVector = Icons.Filled.ArrowBack,
//                            contentDescription = "Back"
//                        )
//                    }
//                },
//                colors = TopAppBarDefaults.smallTopAppBarColors(
//                    containerColor = Color.White,
//                    titleContentColor = Color.Black,
//                    navigationIconContentColor = Color.Black
//                )
//            )
//        }
//    ) { innerPadding ->
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(innerPadding)
//                .padding(16.dp),
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Text(
//                text = "Player vs Computer",
//                fontSize = 16.sp,
//                color = Color.Gray,
//                modifier = Modifier.padding(bottom = 24.dp)
//            )
//
//            // Player's Section
//            Card(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 8.dp),
//                shape = RoundedCornerShape(12.dp),
//                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
//                colors = CardDefaults.cardColors(containerColor = Color.White)
//            ) {
//                Column(
//                    modifier = Modifier.padding(16.dp)
//                ) {
//                    Text(
//                        text = "Your Dice",
//                        color = Color(0xFF2196F3),
//                        fontWeight = FontWeight.Bold,
//                        fontSize = 18.sp,
//                        modifier = Modifier.padding(bottom = 12.dp)
//                    )
//                    Row(
//                        modifier = Modifier.fillMaxWidth(),
//                        horizontalArrangement = Arrangement.SpaceEvenly,
//                        verticalAlignment = Alignment.CenterVertically
//                    ) {
//                        playerDice.forEach { value ->
//                            DiceView(value = value, isPlayer = true)
//                        }
//                    }
//                }
//            }
//
//            Spacer(modifier = Modifier.height(16.dp))
//
//            // Computer's Section
//            Card(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 8.dp),
//                shape = RoundedCornerShape(12.dp),
//                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
//                colors = CardDefaults.cardColors(containerColor = Color.White)
//            ) {
//                Column(
//                    modifier = Modifier.padding(16.dp)
//                ) {
//                    Text(
//                        text = "Computer's Dice",
//                        color = Color(0xFFE91E63),
//                        fontWeight = FontWeight.Bold,
//                        fontSize = 18.sp,
//                        modifier = Modifier.padding(bottom = 12.dp)
//                    )
//                    Row(
//                        modifier = Modifier.fillMaxWidth(),
//                        horizontalArrangement = Arrangement.SpaceEvenly,
//                        verticalAlignment = Alignment.CenterVertically
//                    ) {
//                        computerDice.forEach { value ->
//                            DiceView(value = value, isPlayer = false)
//                        }
//                    }
//                }
//            }
//
//            Spacer(modifier = Modifier.weight(1f))
//
//            // Control Buttons
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 16.dp),
//                horizontalArrangement = Arrangement.SpaceEvenly
//            ) {
//                Button(
//                    onClick = {
//                        playerDice = List(5) { (1..6).random() }
//                        computerDice = List(5) { (1..6).random() }
//                    },
//                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2196F3)),
//                    modifier = Modifier.weight(1f).padding(end = 8.dp)
//                ) {
//                    Text(
//                        "Throw",
//                        color = Color.White,
//                        fontWeight = FontWeight.Bold
//                    )
//                }
//
//                Button(
//                    onClick = { /* TODO: Implement scoring */ },
//                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)),
//                    modifier = Modifier.weight(1f).padding(start = 8.dp)
//                ) {
//                    Text(
//                        "Score",
//                        color = Color.White,
//                        fontWeight = FontWeight.Bold
//                    )
//                }
//            }
//        }
//    }
//}
//
//@Composable
//private fun DiceView(value: Int, isPlayer: Boolean) {
//    val backgroundColor = if (isPlayer) {
//        Color(0xFF2196F3).copy(alpha = 0.1f)
//    } else {
//        Color(0xFFE91E63).copy(alpha = 0.1f)
//    }
//
//    val textColor = if (isPlayer) {
//        Color(0xFF2196F3)
//    } else {
//        Color(0xFFE91E63)
//    }
//
//    Card(
//        modifier = Modifier
//            .size(45.dp)
//            .padding(4.dp),
//        shape = RoundedCornerShape(8.dp),
//        colors = CardDefaults.cardColors(containerColor = backgroundColor)
//    ) {
//        Box(
//            modifier = Modifier.fillMaxSize(),
//            contentAlignment = Alignment.Center
//        ) {
//            Text(
//                text = value.toString(),
//                color = textColor,
//                fontWeight = FontWeight.Bold,
//                fontSize = 18.sp
//            )
//        }
//    }
//}

Button(

)