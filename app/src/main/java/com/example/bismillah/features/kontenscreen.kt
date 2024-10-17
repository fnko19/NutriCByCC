package com.example.bismillah.features

import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.bismillah.others.BottomBar
import com.example.bismillah.ui.theme.YaleBlue
import com.example.bismillah.ui.theme.Poppins
import androidx.navigation.compose.rememberNavController

@Composable
fun KontenScreen(navController: NavHostController) {
    Scaffold(
        bottomBar = {
            BottomBar(navController = navController)
        }
    ) { innerPadding ->
        // Main content of the Konten screen
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding), // Add innerPadding to avoid overlapping the BottomBar
            contentAlignment = Alignment.Center
        ) {
            // Temporary text in the content area
            Text(
                text = "Ini halaman konten",
                fontSize = 24.sp
            )
        }
    }
}

@Composable
@Preview
fun KontenScreenPreview(){
    KontenScreen(navController = rememberNavController() )
}

