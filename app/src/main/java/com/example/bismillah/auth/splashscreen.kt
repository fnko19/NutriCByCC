package com.example.bismillah.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bismillah.R
import com.example.bismillah.others.Screen
import com.example.bismillah.ui.theme.NaplesYellow
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    LaunchedEffect(true) {
        delay(3000) // Delay for 3 seconds
        navController.navigate(Screen.Start.route) {
            popUpTo(Screen.Splash.route) {
                inclusive = true
            }
        }
    }

    // Box dengan background berwarna kuning
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(NaplesYellow) // Warna kuning
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        // Gambar logo di tengah layar
        val image: Painter = painterResource(id = R.drawable.logo)
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = image,
                contentDescription = "App Logo",
                modifier = Modifier
                    .size(200.dp)
                    .padding(bottom = 16.dp) // Jarak antara logo dan progress indicator
            )

            // Gambar loading (CircularProgressIndicator)
            CircularProgressIndicator(
                color = Color.White, // Warna indikator
                strokeWidth = 4.dp,
                modifier = Modifier
                    .size(50.dp)
                    .background(Color.Transparent, CircleShape)
            )
        }
    }
}

@Preview
@Composable
fun SplashScreenPreview() {
    SplashScreen(navController = rememberNavController())
}
