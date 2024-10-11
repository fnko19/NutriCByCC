package com.example.bismillah

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
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
import coil.compose.rememberImagePainter
import com.example.bismillah.ui.theme.NaplesYellow
import com.example.bismillah.ui.theme.SandyBrown
import com.example.bismillah.ui.theme.YaleBlue
import androidx.compose.ui.res.painterResource
import com.example.bismillah.R // Pastikan path ini benar sesuai dengan package app Anda

@Composable
fun LandingPage() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Background Image
        Image(
            painter = painterResource(id = R.drawable.bglp2), // Ganti URL dengan gambar latar belakang Anda
            contentDescription = "Background Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // Content on top of the background
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
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
    }
}

@Composable
fun UserProfileSection() {
    Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
        // Bagian untuk Gambar Profil
        UserProfileImage() // Memanggil fungsi terpisah untuk gambar profil

        // Row untuk kedua kartu
        Row(
            modifier = Modifier.fillMaxWidth().padding(top = 1.dp), // Padding atas untuk jarak antara gambar dan kartu
            horizontalArrangement = Arrangement.SpaceBetween // Mengatur jarak antara kartu
        ) {
            // Card pertama untuk profil
            Card(
                modifier = Modifier.weight(1f).padding(end = 8.dp), // Mengisi ruang yang tersedia dan memberikan jarak antar kartu
                shape = RoundedCornerShape(10.dp),
                elevation = 4.dp
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Column {
                        Text(text = "Halo, Indri", fontSize = 13.sp, fontWeight = FontWeight.Bold, color = SandyBrown)
                        Text(text = "Selamat datang kembali di Nutric", fontSize = 11.sp)
                    }
                }
            }

            // Card kedua untuk informasi berat badan dan tumbuh kembang
            Card(
                modifier = Modifier.weight(1f).padding(start = 8.dp), // Mengisi ruang yang tersedia dan memberikan jarak antar kartu
                shape = RoundedCornerShape(10.dp),
                elevation = 4.dp
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start // Mengatur agar teks kanan
                ) {
                    Column(horizontalAlignment = Alignment.Start) {
                        Text(text = "5.5 kg", fontSize = 13.sp, fontWeight = FontWeight.Bold, color = Color(0xFFFF9800))
                        Text(text = "Tumbuh kembang anak sehat!", fontSize = 11.sp)
                    }
                }
            }
        }
    }
}

@Composable
fun UserProfileImage() {
    // Menggunakan Row untuk menyelaraskan gambar dan teks secara horizontal
    Row(
        modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp), // Padding bawah untuk jarak dengan konten lain
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
                fontSize = 16.sp, // Ukuran teks
                fontWeight = FontWeight.Normal, // Berat font normal
                color = Color.Black // Warna teks hitam
            )
            Text(
                text = "0 Tahun, 6 Bulan", // Baris kedua
                fontSize = 14.sp, // Ukuran teks lebih kecil untuk baris kedua
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
        Icon(painter = icon, contentDescription = title, modifier = Modifier.size(50.dp))
        Text(text = title, fontSize = 14.sp, fontWeight = FontWeight.Bold)
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
            modifier = Modifier.padding(16.dp)
        ) {
            // Teks pertama
            Row(
                modifier = Modifier.fillMaxWidth(), // Mengisi lebar maksimum
                verticalAlignment = Alignment.CenterVertically // Sejajarkan secara vertikal
            ) {
                Text(
                    text = "Indri menunjukkan gejala stunting. Pantau lebih lanjut untuk rekomendasi gizi dan saran dokter.",
                    fontWeight = FontWeight.Bold,
                    color = YaleBlue,
                    modifier = Modifier.weight(1f) // Membuat teks mengisi ruang yang tersisa
                )
                Button(
                    onClick = { /* TODO: Navigate to detailed section */ },
                    modifier = Modifier.padding(start = 8.dp) // Padding kiri untuk memisahkan tombol dari teks
                ) {
                    Text(text = "Lihat detail")
                }
            }
        }
    }
    Spacer(modifier = Modifier.height(16.dp))
}


@Composable
fun StimulationActivities() {
    Column {
        Text(text = "Kegiatan Stimulasi", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))

        StimulationActivity(
            activity = "Ajak Indri bermain menumpuk balok untuk melatih motorik halus"
        )
        StimulationActivity(
            activity = "Ajak Pani melihat bayangannya di cermin untuk membantu mengenali diri sendiri"
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
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = activity, modifier = Modifier.weight(1f), fontSize = 14.sp)
        Checkbox(checked = false, onCheckedChange = {})
    }
    Spacer(modifier = Modifier.height(8.dp))
}

@Composable
fun DailyJournalSection() {
    Column {
        Text(text = "Jurnal Harian Perkembangan Anak", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))
        Card(
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "09 Oktober 2024", fontSize = 14.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "• Hari ini Indri mulai merangkak untuk pertama kali!")
                Text(text = "• Indri mengucapkan kata pertamanya, \"Papa!\"")
                Text(text = "• Hari ini Indri berdiri sendiri dengan berpegangan pada meja")
            }
        }
    }
}

@Preview
@Composable
fun LandingPagePreview() {
    LandingPage()
}
