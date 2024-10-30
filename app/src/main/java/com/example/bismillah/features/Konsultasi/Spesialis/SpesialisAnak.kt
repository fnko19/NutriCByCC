package com.example.bismillah.features.Konsultasi.Spesialis

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bismillah.ui.theme.Poppins
import com.example.bismillah.R

@Composable
fun spesialisGizi(navController: NavController) {
    var searchText by remember { mutableStateOf("") }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFF8F8F8)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 50.dp, start = 16.dp, end = 16.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        painter = painterResource(id = R.drawable.back),
                        contentDescription = "Back",
                        modifier = Modifier.size(32.dp),
                        tint = Color.Black
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = "Daftar Dokter Spesialis Gizi",
                    fontFamily = Poppins,
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold, fontSize = 18.sp, color = Color.Black),
                    modifier = Modifier.padding(vertical = 18.dp)
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            SearchBarGizi()

            Spacer(modifier = Modifier.height(20.dp))

            Column(modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .weight(1f)
                .fillMaxHeight()
            ) {
                GiziCard(
                    imageRes = R.drawable.gizi1,
                    name = "dr. Mariana Komogi, Sp.GK., M.Clin.Med",
                    hospital = "Rumah Sakit Siloam Makassar"
                )
                GiziCard(
                    imageRes = R.drawable.gizi2,
                    name = "dr. Michelle Kartika Thompson, Sp.GK, IBCLC, MSc",
                    hospital = "Rumah Sakit Siloam Makassar"
                )
                GiziCard(
                    imageRes = R.drawable.gizi3,
                    name = "dr. Jonathan Aditya Patel, Sp.GK, RD, IBCLC",
                    hospital = "RSUP Dr. Tadjuddin Chalid"
                )
                GiziCard(
                    imageRes = R.drawable.gizi4,
                    name = "dr. Olivia Rahma Spencer, Sp.GK, RD, MSc",
                    hospital = "RSUP Dr. Tadjuddin Chalid"
                )
                GiziCard(
                    imageRes = R.drawable.gizi5,
                    name = "dr. Vika Pramesti, Sp.GK, MPH, RD",
                    hospital = "Rumah Sakit Umum Pusat dr. Wahidin Sudirohusodo"
                )
                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}

@Composable
fun SearchBarGizi() {
    OutlinedTextField(
        value = "",
        onValueChange = {},
        placeholder = { Text(text = "Cari dokter", fontFamily = Poppins, fontSize = 14.sp) },
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
fun GiziCard(imageRes: Int, name: String, hospital: String) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White) // Set card color to white
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = null,
                modifier = Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(20.dp))
            Column {
                Text(text = name, fontWeight = FontWeight.Bold, fontFamily = Poppins, fontSize = 14.sp, color = Color.Black)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = hospital, fontSize = 12.sp, fontFamily = Poppins, color = Color.Gray)
            }
        }
    }
}

@Preview
@Composable
fun spesialisGiziPreview(){
    spesialisGizi(navController = rememberNavController())
}