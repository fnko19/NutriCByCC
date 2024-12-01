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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.bismillah.others.BottomBar
import com.example.bismillah.ui.theme.Poppins
import androidx.navigation.compose.rememberNavController
import com.example.bismillah.R
import com.example.bismillah.others.Screen
import com.example.bismillah.ui.theme.NaplesYellow
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun KontenScreen(navController: NavHostController) {
    val auth = FirebaseAuth.getInstance()
    var userName by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(true) }

    LaunchedEffect(auth.currentUser) {
        val user = auth.currentUser
        user?.let {
            userName = it.displayName ?: it.email ?: "Nama Tidak Tersedia"
            isLoading = false
        } ?: run {
            userName = "Pengguna tidak terdaftar"
            isLoading = false
        }
    }

    Scaffold(
        bottomBar = {
            BottomBar(navController = navController)
        }
    ) { innerPadding ->
        var searchQuery by remember { mutableStateOf("") }
        var selectedCategory by remember { mutableStateOf("Sarapan") }
        var isLoading by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(innerPadding)
                .padding(top = 20.dp, start = 20.dp, end = 20.dp, bottom = 64.dp)
        ) {

            Text(
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

            Text(
                text = "Haloo mamanya $userName! \nMau masak apa hari ini? ",
                fontSize = 14.sp,
                fontFamily = Poppins,
                color = Color(0xFF0D3B66),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                textAlign = TextAlign.Left
            )

            Spacer(modifier = Modifier.height(12.dp))


            SearchBar()

            Spacer(modifier = Modifier.height(24.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                RecipeCategoryCard("Sarapan", R.drawable.sarapan)
                RecipeCategoryCard("Makan Siang", R.drawable.makansiang)
                RecipeCategoryCard("Makan Malam", R.drawable.makanmalam)
            }

            Spacer(modifier = Modifier.height(24.dp))

            if (isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
            }

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
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}


@Composable
fun SearchBar() {
    var searchText by remember { mutableStateOf("") }
    OutlinedTextField(
        value = searchText,
        onValueChange = { searchText = it },
        placeholder = { Text(text = "Cari resep", fontFamily = Poppins, fontSize = 14.sp, color = Color.Black) },
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.search),
                contentDescription = "Search Icon",
                tint = Color.Black,
                modifier = Modifier.size(20.dp)
            )
        }
    )
}

@Composable
fun RecipeCategoryCard(title: String, imageRes: Int) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .size(90.dp)
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
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F5F5))
    ) {
        Column {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = "Menu",
                contentScale = ContentScale.Crop,
                modifier = Modifier.height(180.dp)
            )
            androidx.compose.material3.Text(
                foodName,
                fontWeight = FontWeight.Bold,
                fontFamily = poppinsFamily,
                modifier = Modifier.padding(8.dp),
                textAlign = TextAlign.Center,
                color = Color.Black
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
            ) {
                androidx.compose.material3.Text(babyAge,
                    fontFamily = poppinsFamily,
                    color = Color.Black,
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

