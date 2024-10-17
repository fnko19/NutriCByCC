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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.Modifier
import com.example.bismillah.ui.theme.YaleBlue
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
        backgroundColor = YaleBlue,
        contentColor = Color.White,
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
                        modifier = Modifier.size(32.dp) // Set your desired size here
                    )
                },
                label = { Text(text = item.title, fontFamily = Poppins, fontSize = 16.sp ) },
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
    object Home : BottomNavItem("Home", R.drawable.home1, "home")
    object Konten : BottomNavItem("Konten", R.drawable.konten1, "konten")
    object Konsultasi : BottomNavItem("Konsul", R.drawable.konsultasi1, "konsultasi")
    object Profil : BottomNavItem("Profil", R.drawable.profil1, "profil")
}

@Composable
@Preview
fun BottomBarView(){
    BottomBar(navController = rememberNavController())
}

