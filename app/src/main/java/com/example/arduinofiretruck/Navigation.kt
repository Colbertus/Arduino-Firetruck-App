package com.example.arduinofiretruck

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable

fun Navigation() {
    val navController = rememberNavController()
    val viewModel = hiltViewModel<BluetoothViewModel>()
    val state by viewModel.state.collectAsState()
    NavHost(navController = navController, startDestination = Screen.MainActivity.route) {
        composable(route = Screen.MainActivity.route) {
            GreetingScreen(navController = navController)
        }
        composable(route = Screen.BluetoothScreen.route) {
            BluetoothScreen(navController = navController)
        }
        composable(route = Screen.SettingsScreen.route) {
            SettingsScreen(navController = navController)
        }
        composable(route = Screen.DeviceScreen.route) {
            DeviceScreen(
                state = state,
                onStartScan = viewModel:: startScan,
                onStopScan = viewModel::stopScan,
                navController = navController
            )
        }
        composable(route = Screen.SpeakerControlScreen.route) {
            SpeakerControlScreen(navController = navController)
        }
    }
}


