package com.example.arduinofiretruck

sealed class Screen(val route: String) {
    object MainActivity : Screen("main_screen")
    object BluetoothScreen : Screen("bluetooth_screen")
    object SettingsScreen : Screen("settings_screen")

}