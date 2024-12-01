package com.example.bismillah.features.Konsultasi.Spesialis.Gizi

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.bismillah.R
import com.example.bismillah.features.Konsultasi.DetailDokterScreen

@Composable
fun JonathanPage(navController: NavController) {
    DetailDokterScreen(
        imageRes = R.drawable.gizi3,
        name = "dr. Michelle Kartika Thompson, Sp.GK, MSc",
        description = "dr. Michelle adalah spesialis gizi dengan pengalaman dalam nutrisi anak dan dewasa.",
        hospital = "RS Siloam Makassar",
        practiceTime = "Selasa - Sabtu 09:00-13:00",
        waNumber = "081212341234"
    )
}

@Composable
fun MarianaPage(navController: NavController) {
    DetailDokterScreen(
        imageRes = R.drawable.gizi2,
        name = "dr. Mariana Komogi, Sp.GK., M.Clin.Med",
        description = "dr. Mariana adalah ahli gizi klinik yang berfokus pada perbaikan gizi masyarakat.",
        hospital = "RS Siloam Makassar",
        practiceTime = "Senin - Jumat 10:00-14:00",
        waNumber = "081298765432"
    )
}

@Composable
fun MichellePage(navController: NavController) {
    DetailDokterScreen(
        imageRes = R.drawable.gizi4,
        name = "dr. Michelle Kartika Thompson, Sp.GK, MSc",
        description = "dr. Michelle adalah spesialis gizi dengan pengalaman dalam nutrisi anak dan dewasa.",
        hospital = "RS Siloam Makassar",
        practiceTime = "Selasa - Sabtu 09:00-13:00",
        waNumber = "081212341234"
    )
}

@Composable
fun OliviaPage(navController: NavController) {
    DetailDokterScreen(
        imageRes = R.drawable.gizi5,
        name = "dr. Michelle Kartika Thompson, Sp.GK, MSc",
        description = "dr. Michelle adalah spesialis gizi dengan pengalaman dalam nutrisi anak dan dewasa.",
        hospital = "RS Siloam Makassar",
        practiceTime = "Selasa - Sabtu 09:00-13:00",
        waNumber = "081212341234"
    )
}

@Composable
fun VikaPage(navController: NavController) {
    DetailDokterScreen(
        imageRes = R.drawable.gizi1,
        name = "dr. Vika Pramesti, Sp.GK, MPH, RD",
        description = "dr. Vika adalah dokter spesialis gizi klinik yang memiliki keahlian dalam menangani obesitas dan malnutrisi.",
        hospital = "RSUP dr. Wahidin Sudirohusodo",
        practiceTime = "Senin - Jumat 15:00-16:40",
        waNumber = "081234567890"
    )
}