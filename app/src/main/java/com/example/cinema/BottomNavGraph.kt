package com.example.cinema

import androidx.compose.runtime.Composable

@Composable
fun BottomNavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ){
        compaseble(route = BottomBarScreen.Home.route){
            HomeScreen()
        }
    }
}


