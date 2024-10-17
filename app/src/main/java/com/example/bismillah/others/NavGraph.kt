package com.example.bismillah.others

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.bismillah.auth.SigninScreen
import com.example.bismillah.auth.SignupScreen
import com.example.bismillah.user.UserViewModel
import com.example.bismillah.auth.SplashScreen
import com.example.bismillah.features.HomeScreen
import com.example.bismillah.features.KontenScreen

@Composable
fun NavGraph(navController: NavHostController, userViewModel: UserViewModel = viewModel()){
    NavHost(navController = navController, startDestination = Screen.Splash.route){
        composable(Screen.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(Screen.SignIn.route) {
            SigninScreen(navController = navController)
        }
        composable(Screen.SignUp.route){
            SignupScreen(navController = navController)
        }
        composable(Screen.Home.route){
            HomeScreen(navController = navController)
        }
        composable(Screen.Konten.route){
            KontenScreen(navController = navController)
        }


    }
}

// Define the screens in your app
sealed class Screen(val route: String) {
    data object Splash : Screen("splash")
    data object SignIn : Screen("signIn")
    data object SignUp : Screen("signup")
    data object Home : Screen("home")
    data object Konten : Screen("konten")
    data object Konsultasi : Screen("konsultasi")
    data object Profil : Screen ("profil")
}