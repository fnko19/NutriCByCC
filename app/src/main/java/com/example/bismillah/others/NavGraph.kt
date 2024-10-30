package com.example.bismillah.others

import androidx.compose.runtime.Composable
import androidx.compose.runtime.internal.composableLambda
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.bismillah.auth.SigninScreen
import com.example.bismillah.auth.SignupScreen
import com.example.bismillah.user.UserViewModel
import com.example.bismillah.auth.SplashScreen
import com.example.bismillah.auth.StartScreen
import com.example.bismillah.features.HomeScreen
import com.example.bismillah.features.Konsultasi.Spesialis.spesialisAnakPage
import com.example.bismillah.features.Konsultasi.Spesialis.spesialisGizi
import com.example.bismillah.features.Konsultasi.Spesialis.spesialisGiziPreview
import com.example.bismillah.features.Konsultasi.konsultasiScreen
import com.example.bismillah.features.Konten.KontenScreen
import com.example.bismillah.features.Konten.MiePage
import com.example.bismillah.features.Konten.PopSiclePage
import com.example.bismillah.features.Konten.sushiPage
import com.example.bismillah.features.PerkembanganScreen
import com.example.bismillah.features.PertumbuhanScreen
import com.example.bismillah.features.VaksinScreen

@Composable
fun NavGraph(navController: NavHostController, userViewModel: UserViewModel = viewModel()){

    NavHost(navController = navController, startDestination = Screen.Splash.route){
        composable(Screen.Splash.route) {
            SplashScreen(navController)
        }
        composable(Screen.Start.route){
            StartScreen(navController)
        }
        composable(Screen.SignIn.route) {
            SigninScreen(navController)
        }
        composable(Screen.SignUp.route){
            SignupScreen(navController)
        }
        composable(Screen.Home.route){
            HomeScreen(navController)
        }
        composable(Screen.Konten.route){
            KontenScreen(navController)
        }
        composable(Screen.Tumbuh.route){
            PertumbuhanScreen(navController)
        }
        composable(Screen.Kembang.route){
            PerkembanganScreen(navController)
        }
        composable(Screen.Vaksin.route){
            VaksinScreen(navController)
        }
        composable(Screen.Sushi.route){
            sushiPage(navController)
        }
        composable(Screen.Popsicle.route){
            PopSiclePage(navController)
        }
        composable(Screen.Mie.route){
            MiePage(navController)
        }
        composable(Screen.SpesialisGizi.route){
            spesialisGizi(navController)
        }
        composable(Screen.SpesialisAnak.route){
            spesialisAnakPage(navController)
        }
        composable(Screen.Konsultasi.route){
            konsultasiScreen(navController)
        }

    }
}

// Define the screens in your app
sealed class Screen(val route: String) {
    data object Splash : Screen("splash")
    data object Start : Screen("start")
    data object SignIn : Screen("signIn")
    data object SignUp : Screen("signup")
    data object Home : Screen("home")
    data object Konten : Screen("konten")
    data object Konsultasi : Screen("konsultasi")
    data object Profil : Screen ("profil")
    data object Tumbuh : Screen("tumbuh")   // Rute baru
    data object Kembang : Screen("kembang")   // Rute baru
    data object Vaksin : Screen("vaksin")
    data object Sushi : Screen("sushi")
    data object Popsicle : Screen("Popsicle")
    data object Mie : Screen("mie")
    data object SpesialisAnak : Screen("spesialisAnak")
    data object SpesialisGizi : Screen("spesialisGizi")
}