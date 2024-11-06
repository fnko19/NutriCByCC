package com.example.bismillah.features.Konten

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.bismillah.others.BottomBar
import com.example.bismillah.ui.theme.Poppins
import androidx.navigation.compose.rememberNavController
import com.example.bismillah.R
import com.example.bismillah.others.Screen
import com.example.bismillah.ui.theme.NaplesYellow

@Composable
fun KontenScreen(navController: NavHostController) {
    Scaffold(
        bottomBar = {
            BottomBar(navController = navController)
        }
    ) { innerPadding ->
        // Main content of the Konten screen
        var searchQuery by remember { mutableStateOf("") } // State for search input
        var selectedCategory by remember { mutableStateOf("Sarapan") } // State for selected category
        var isLoading by remember { mutableStateOf(false) } // State for loading status

        // Use verticalScroll to make the content scrollable
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())  // Make the content scrollable
                .padding(innerPadding)
                .padding(top = 48.dp, start = 18.dp, end = 18.dp, bottom = 64.dp)  // Add padding at the bottom to prevent content from being hidden by BottomBar
        ) {
            // Title
            androidx.compose.material3.Text(
                text = "Resep",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = Poppins,
                color = Color(0xFF0D3B66),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(8.dp))

            androidx.compose.material3.Text(
                text = "Haloo mama Indri! \nMau masak apa hari ini? ",
                fontSize = 14.sp,
                fontFamily = Poppins,
                color = Color(0xFF0D3B66),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                textAlign = TextAlign.Left
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Search Field
            SearchField(searchQuery = searchQuery, onSearchQueryChange = { searchQuery = it })

            Spacer(modifier = Modifier.height(24.dp))

            // Categories
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                RecipeCategoryCard("Sarapan", R.drawable.sarapan)
                RecipeCategoryCard("Makan Siang", R.drawable.makansiang)
                RecipeCategoryCard("Makan Malam", R.drawable.makanmalam)
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Loading indicator
            if (isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
            }

            // Horizontal Scroll for Menu Cards
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(3) { index ->
                    when (index) {
                        0 -> MenuCard(
                            foodName = "Sushi Rolls dan Buah",
                            babyAge = "12 bulan",
                            imageRes = R.drawable.sushi,
                            poppinsFamily = Poppins,
                            navController = navController,
                            destination = Screen.Sushi.route
                        )
                        1 -> MenuCard(
                            foodName = "Popsicle Mangga",
                            babyAge = "6 bulan",
                            imageRes = R.drawable.popsicle,
                            poppinsFamily = Poppins,
                            navController = navController,
                            destination = Screen.Popsicle.route
                        )
                        2 -> MenuCard(
                            foodName = "Mie Pagi Ceria",
                            babyAge = "9 bulan",
                            imageRes = R.drawable.mie,
                            poppinsFamily = Poppins,
                            navController = navController,
                            destination = Screen.Mie.route
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(24.dp)) // Add space at the end to avoid content being hidden by BottomBar
        }
    }
}


@Composable
fun SearchField(searchQuery: String, onSearchQueryChange: (String) -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            value = searchQuery,
            onValueChange = onSearchQueryChange,
            placeholder = {
                androidx.compose.material3.Text("Cari Resep", fontFamily = Poppins, fontSize = 14.sp, color = Color(0xFF0D3B66))
            },
            modifier = Modifier
                .shadow(1.dp, RoundedCornerShape(8.dp))
                .height(52.dp)
                .fillMaxWidth()
                .background(Color(0x20FFF0E3), RoundedCornerShape(8.dp)),
            shape = RoundedCornerShape(8.dp),
            textStyle = TextStyle(color = Color.Black),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = "Search Icon",
                    tint = Color.Black,
                    modifier = Modifier.size(24.dp)
                )
            }
        )
    }
}

@Composable
fun RecipeCategoryCard(title: String, imageRes: Int) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .size(100.dp)
            .shadow(2.dp, RoundedCornerShape(8.dp)),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFFF9E1))
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = title,
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(60.dp)
            )
            androidx.compose.material3.Text(
                text = title,
                fontFamily = Poppins,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF0D3B66),
                fontSize = 12.sp
            )
        }
    }
}

@Composable
fun MenuCard(
    foodName: String,
    babyAge: String,
    imageRes: Int,
    poppinsFamily: FontFamily,
    navController: NavController,
    destination: String
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .height(320.dp)
            .width(194.dp)
            .shadow(4.dp, RoundedCornerShape(8.dp)),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFED974C))
    ) {
        Column {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = "Menu",
                contentScale = ContentScale.Crop,
                modifier = Modifier.height(200.dp)
            )
            androidx.compose.material3.Text(
                foodName,
                fontWeight = FontWeight.Bold,
                fontFamily = poppinsFamily,
                modifier = Modifier.padding(8.dp),
                textAlign = TextAlign.Center,
                color = Color.White
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
            ) {
                androidx.compose.material3.Text(babyAge,
                    fontFamily = poppinsFamily,
                    color = Color.White,
                    fontSize = 12.sp)
            }
            Button(
                onClick = {
                    navController.navigate(destination) // Navigate to the correct detail screen
                },
                modifier = Modifier
                    .padding(12.dp)
                    .height(36.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFBD758))
            ) {
                androidx.compose.material3.Text(
                    "Lihat Detail",
                    fontFamily = Poppins,
                    fontSize = 14.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}



@Composable
@Preview
fun KontenScreenPreview(){
    KontenScreen(navController = rememberNavController() )
}

