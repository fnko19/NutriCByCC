package com.example.bismillah.features

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.layout.ContentScale
import androidx.compose.foundation.Image
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bismillah.ui.theme.NaplesYellow
import com.example.bismillah.ui.theme.SandyBrown
import com.example.bismillah.ui.theme.YaleBlue
import com.example.bismillah.R
import com.example.bismillah.ui.theme.Poppins
import com.example.bismillah.others.BottomBar
import androidx.navigation.NavHostController
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold

@Composable
fun HomeScreen(navController: NavHostController) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Background Image
        Image(
            painter = painterResource(id = R.drawable.bglp), // Ganti URL dengan gambar latar belakang Anda
            contentDescription = "Background Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Image(
            painter = painterResource(id = R.drawable.bglp3), // Ganti URL dengan gambar latar belakang Anda
            contentDescription = "Background Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
        )

        // Content on top of the background
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(18.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            // Bagian profil pengguna
            UserProfileSection()

            // Kategori aktivitas (Tumbuh, Kembang, Vaksin)
            ActivityCategories()

            // Peringatan stunting
            StuntingWarningSection()

            // Aktivitas stimulasi
            StimulationActivities()

            // Jurnal harian
            DailyJournalSection()

            Spacer(modifier = Modifier.height(16.dp))
        }
        // Add the BottomBar overlaying the images
        BottomBar(navController = navController, modifier = Modifier.align(Alignment.BottomCenter))
    }
}



@Composable
fun UserProfileSection() {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)) {
        // Bagian untuk Gambar Profil
        UserProfileImage() // Memanggil fungsi terpisah untuk gambar profil

        // Row untuk kedua kartu
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 1.dp), // Padding atas untuk jarak antara gambar dan kartu
            horizontalArrangement = Arrangement.SpaceBetween, // Mengatur jarak antara kartu
            verticalAlignment = Alignment.CenterVertically // Menyelaraskan konten secara vertikal
        ) {
            // Card pertama untuk profil
            Card(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp), // Mengisi ruang yang tersedia dan memberikan jarak antar kartu
                shape = RoundedCornerShape(10.dp),
                elevation = 4.dp
            ) {
                Row(
                    modifier = Modifier.padding(9.dp),
                    verticalAlignment = Alignment.CenterVertically, // Menyelaraskan gambar dan teks secara vertikal
                    horizontalArrangement = Arrangement.Start
                ) {
                    // Menambahkan Gambar di sini
                    Image(
                        painter = painterResource(id = R.drawable.daycare), // Ganti dengan ID gambar Anda
                        contentDescription = "User Image",
                        modifier = Modifier.size(30.dp) // Ukuran gambar
                    )

                    Spacer(modifier = Modifier.width(8.dp)) // Jarak antara gambar dan teks

                    Column {
                        Text(
                            text = "Halo, Indri",
                            fontFamily = Poppins,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = SandyBrown
                        )
                        Text(
                            text = "Selamat datang kembali di Nutric",
                            fontSize = 12.sp,
                            fontFamily = Poppins
                        )
                    }
                }
            }

            // Card kedua untuk informasi berat badan dan tumbuh kembang
            Card(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp), // Mengisi ruang yang tersedia dan memberikan jarak antar kartu
                shape = RoundedCornerShape(10.dp),
                elevation = 4.dp
            ) {
                Row(
                    modifier = Modifier.padding(9.3.dp),
                    verticalAlignment = Alignment.CenterVertically, // Menyelaraskan teks secara vertikal
                    horizontalArrangement = Arrangement.Start // Mengatur agar teks kanan
                ) {
                    Column(horizontalAlignment = Alignment.Start) {
                        Text(
                            text = "5.5 kg",
                            fontFamily = Poppins,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFFF9800)
                        )
                        Text(text = "Tumbuh kembang anak sehat!", fontSize = 12.sp, fontFamily = Poppins)
                    }
                }
            }
        }
    }
    Spacer(modifier = Modifier.height(40.dp))
}


@Composable
fun UserProfileImage() {
    // Menggunakan Row untuk menyelaraskan gambar dan teks secara horizontal
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp), // Padding bawah untuk jarak dengan konten lain
        verticalAlignment = Alignment.CenterVertically // Agar gambar dan teks sejajar secara vertikal
    ) {
        // Gambar profil dari drawable
        Image(
            painter = painterResource(id = R.drawable.pp), // Ganti "pp" dengan nama file di drawable
            contentDescription = "Profile Image",
            modifier = Modifier.size(50.dp)
        )

        // Spacer untuk memberikan jarak antara gambar dan teks
        Spacer(modifier = Modifier.width(8.dp)) // Memberikan jarak horizontal antara gambar dan teks

        // Kolom untuk menampilkan dua baris teks di sebelah gambar
        Column {
            Text(
                text = "Indri",
                fontFamily = Poppins,
                fontSize = 14.sp, // Ukuran teks
                fontWeight = FontWeight.Normal, // Berat font normal
                color = Color.Black // Warna teks hitam
            )
            Text(
                text = "0 Tahun, 6 Bulan", // Baris kedua
                fontFamily = Poppins,
                fontSize = 12.sp, // Ukuran teks lebih kecil untuk baris kedua
                fontWeight = FontWeight.Light, // Berat font lebih ringan
                color = Color.Gray // Warna teks abu-abu untuk kontras
            )
        }
        Spacer(modifier = Modifier.weight(1f))

        // Gambar lonceng yang diposisikan di kanan
        Image(
            painter = painterResource(id = R.drawable.bell), // Ganti "bell" dengan nama file di drawable
            contentDescription = "Bell Icon",
            modifier = Modifier.size(20.dp)
        )

    }
}

@Composable
fun ActivityCategories() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        ActivityCategory(icon = painterResource(id = R.drawable.tumbuh), title = "Tumbuh")
        ActivityCategory(icon = painterResource(id = R.drawable.kembang), title = "Kembang")
        ActivityCategory(icon = painterResource(id = R.drawable.vaksin), title = "Vaksin")
    }
    Spacer(modifier = Modifier.height(16.dp))
}

@Composable
fun ActivityCategory(icon: Painter, title: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(painter = icon, contentDescription = title, modifier = Modifier.size(50.dp), tint = Color.Unspecified)
        Text(text = title,  fontFamily = Poppins, fontSize = 12.sp, fontWeight = FontWeight.Bold, color = YaleBlue)
    }
}

@Composable
fun StuntingWarningSection() {
    Card(
        backgroundColor = SandyBrown,
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            // Teks pertama
            Row(
                modifier = Modifier.fillMaxWidth(), // Mengisi lebar maksimum
                verticalAlignment = Alignment.CenterVertically // Sejajarkan secara vertikal
            ) {
                Text(
                    text = "Waspada Stunting! Kondisi ini dapat menghambat pertumbuhan dan perkembangan anak secara fisik dan kognitif. Pastikan asupan gizi tercukupi sejak dini!",
                    fontFamily = Poppins,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = YaleBlue,
                    modifier = Modifier
                        .weight(2.5f) // Membuat teks mengisi ruang yang tersisa
                        .fillMaxWidth(), // Mengisi lebar maksimum
                    textAlign = TextAlign.Justify // Menyelaraskan teks
                )
                /*Button(
                    onClick = { /* TODO: Navigate to detailed section */ },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = LemonChiffon, // Warna background button
                        contentColor = YaleBlue // Warna teks button
                    ),
                    modifier = Modifier
                        .padding(12.dp)
                        .width(80.dp) // Ganti 120.dp dengan lebar yang diinginkan
                        .height(32.dp), // Ganti 40.dp dengan tinggi yang diinginkan
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Text(text = "Lihat detail",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = Poppins,
                        modifier = Modifier.padding(0.dp)
                    )
                }*/
            }
        }
    }
    Spacer(modifier = Modifier.height(16.dp))
}

@Composable
fun StimulationActivities() {
    Column {
        Text(
            text = "Kegiatan Stimulasi",
            fontFamily = Poppins,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))

        StimulationActivity(
            activity = "Ajak Indri bermain menumpuk balok untuk melatih motorik halus"
        )
        StimulationActivity(
            activity = "Perkenalkan Indri pada berbagai suara, seperti suara burung, musik"
        )
        StimulationActivity(
            activity = "Bantu Indri belajar mengguling ke depan dan ke belakang"
        )
    }
    Spacer(modifier = Modifier.height(16.dp))
}

@Composable
fun StimulationActivity(activity: String) {
    Card(
        backgroundColor = NaplesYellow, // Warna oranye
        shape = RoundedCornerShape(0.dp), // Menambahkan sudut yang melengkung
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp) // Memberikan padding vertikal antar Card
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp), // Memberikan padding di dalam Card
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = activity,
                modifier = Modifier.weight(1f),
                fontFamily = Poppins,
                fontSize = 12.sp
            )
            Checkbox(checked = false, onCheckedChange = {})
        }
    }
}



@Composable
fun DailyJournalSection() {
    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier.fillMaxWidth(),
        backgroundColor = SandyBrown,
    ){
        Column(modifier = Modifier.padding(10.dp)) {
            Text(text = "Jurnal Harian Perkembangan Anak",  fontFamily = Poppins, fontSize = 14.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(10.dp))
            Card(
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(8.dp)) {
                    Text(text = "09 Oktober 2024", fontFamily = Poppins, fontSize = 13.sp, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "• Hari ini Indri mulai merangkak untuk pertama kali!")
                    Text(text = "• Indri mengucapkan kata pertamanya, \"Papa!\"")
                    Text(text = "• Hari ini Indri berdiri sendiri dengan berpegangan pada meja")
                }
            }
        }
    }
}

@Preview
@Composable
fun HomescreenPreview() {
    HomeScreen(navController = rememberNavController())
}
