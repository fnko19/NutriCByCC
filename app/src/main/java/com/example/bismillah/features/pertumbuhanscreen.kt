package com.example.bismillah.features

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bismillah.others.BottomBar
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavHostController

@Composable
fun PertumbuhanScreen(navController: NavHostController){
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
                text = "Ini halaman Pertumbuhan",
                fontSize = 24.sp
            )
        }
    }
}

@Composable
@Preview
fun pertumbuhanScreenPreview(){
    PertumbuhanScreen(navController = rememberNavController())
}

