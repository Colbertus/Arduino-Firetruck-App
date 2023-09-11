package com.example.arduinofiretruck.screenswithnavigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.arduinofiretruck.presentation.BluetoothScreen
import com.example.arduinofiretruck.presentation.BluetoothUiState
import com.example.arduinofiretruck.presentation.components.DeviceScreen

@Composable

// This function is used to navigate between screens that are contained within the app itself
fun Navigation(state: BluetoothUiState,
               onStartScan: () -> Unit,
               onStopScan: () -> Unit) {
    val navController = rememberNavController()

    /*
    // Prepares the view model for the bluetooth screen
    val viewModel = hiltViewModel<BluetoothViewModel>()
    val state by viewModel.state.collectAsState()
    */


    // This function sets the main screen and sets up the architecture for the other screens of the app and their respective routes
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
                onStartScan = onStartScan,
                onStopScan = onStopScan,
                navController = navController
            )
        }

        composable(route = Screen.SpeakerControlScreen.route) {
            SpeakerControlScreen(navController = navController)
        }

        composable(route = Screen.FiretruckController.route) {
            FiretruckController(navController = navController)
        }
    }
}


