package com.example.bismillah.others

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.compose.foundation.layout.*
import com.example.bismillah.R
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.Modifier
import com.example.bismillah.ui.theme.Poppins

@Composable
fun BottomBar(navController: NavHostController, modifier: Modifier = Modifier) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Konten,
        BottomNavItem.Konsultasi,
        BottomNavItem.Profil
    )

    BottomNavigation(
        backgroundColor = Color.White,
        contentColor = Color.Black,
        modifier = modifier
    ) {
        val navBackStackEntry = navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry.value?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = item.title,
                        tint = Color.Black,
                        modifier = Modifier.size(32.dp) // Set your desired size here
                    )
                },
                label = { Text(text = item.title, color = Color.Black, fontFamily = Poppins, fontSize = 11.sp ) },
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}


sealed class BottomNavItem(val title: String, val icon: Int, val route: String) {
    object Home : BottomNavItem("Home", R.drawable.home2, "home")
    object Konten : BottomNavItem("Resep", R.drawable.konten2, "konten")
    object Konsultasi : BottomNavItem("Konsultasi", R.drawable.konsultasi2, "konsultasi")
    object Profil : BottomNavItem("Profil", R.drawable.profil2, "profil")
}

@Composable
@Preview
fun BottomBarView(){
    BottomBar(navController = rememberNavController())
}

