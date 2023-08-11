package com.example.arduinofiretruck

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable

fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainActivity.route) {
        composable(route = Screen.MainActivity.route) {
            Greeting(navController = navController)
        }
        composable(route = Screen.BluetoothScreen.route) {
            BluetoothScreen(navController = navController)
        }
        composable(route = Screen.SettingsScreen.route) {
            SettingsScreen(navController = navController)
        }
    }
}


