package com.example.bismillah.features.Pertumbuhan

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.bismillah.others.BottomBar
import com.example.bismillah.ui.theme.Poppins
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import androidx.compose.ui.graphics.Color

@Composable
fun PertumbuhanScreen(navController: NavHostController) {
    val auth = FirebaseAuth.getInstance()
    val firestore = FirebaseFirestore.getInstance()
    val user = auth.currentUser

    var height by remember { mutableStateOf("0") }
    var weight by remember { mutableStateOf("0") }
    var growthHistory by remember { mutableStateOf<List<Map<String, String>>>(emptyList()) }
    var age by remember { mutableStateOf("") }

    LaunchedEffect(user) {
        user?.let {
            firestore.collection("users")
                .document(it.uid)
                .collection("growth")
                .orderBy("date", Query.Direction.DESCENDING)
                .get()
                .addOnSuccessListener { querySnapshot ->
                    val history = querySnapshot.documents.map { document ->
                        mapOf(
                            "date" to (document.getString("date") ?: ""),
                            "height" to (document.getString("height") ?: ""),
                            "weight" to (document.getString("weight") ?: ""),
                            "status" to (document.getString("status") ?: "")
                        )
                    }
                    growthHistory = history
                }
                .addOnFailureListener {
                    //tangkap error isi disini
                }

            firestore.collection("users")
                .document(it.uid)
                .get()
                .addOnSuccessListener { document ->
                    age = document.getString("age") ?: "Usia tidak tersedia"
                }
                .addOnFailureListener {
                    //tangkap error isi disini
                }
        }
    }

    Scaffold(
        bottomBar = {
            BottomBar(navController = navController)
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color(0xFFF7F7F7)),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start=16.dp, top=48.dp, end=16.dp)
            ) {
                Text(
                    text = "Pertumbuhan",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    fontFamily = Poppins,
                    color = Color(0xFF0D3B66)
                )

                Spacer(modifier = Modifier.height(16.dp))
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(Color.White),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(
                                text = user?.displayName ?: "Nama Anak",
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp,
                                fontFamily = Poppins,
                                color = Color(0xFF0D3B66)
                            )
                            Text(
                                text = age,
                                fontSize = 12.sp,
                                fontFamily = Poppins ,
                                color = Color(0xFF0D3B66)
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "History",
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    fontFamily = Poppins,
                    color = Color(0xFF0D3B66)
                )

                Spacer(modifier = Modifier.height(8.dp))

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    colors = CardDefaults.cardColors(Color.White),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    LazyColumn {
                        items(growthHistory) { entry ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(text = entry["date"] ?: "", fontFamily = Poppins, fontSize = 12.sp, color = Color(0xFF0D3B66))
                                Text(text = "${entry["height"]} cm", fontFamily = Poppins, fontSize = 12.sp, color = Color(0xFF0D3B66))
                                Text(text = "${entry["weight"]} kg", fontFamily = Poppins, fontSize = 12.sp, color = Color(0xFF0D3B66))
                                Text(text = entry["status"] ?: "", fontFamily = Poppins, fontSize = 12.sp, color = Color(0xFF0D3B66))
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        navController.navigate("tambahTumbuh")
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFC107)),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp)
                ) {
                    Text(
                        "Tambah Data Pertumbuhan",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontFamily = Poppins,
                    )
                }
            }
        }
    }
}

@Composable
fun GrowthCard(label: String, value: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            //.weight(1f)
            .padding(horizontal = 4.dp),
        colors = CardDefaults.cardColors(Color(0xFFF5F5F5)),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = label, fontWeight = FontWeight.Bold, fontSize = 14.sp, fontFamily = Poppins, color = Color(0xFF0D3B66))
            Text(text = value, fontSize = 14.sp, fontFamily = Poppins, color = Color(0xFF0D3B66))
        }
    }
}

