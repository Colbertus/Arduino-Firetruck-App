package com.example.arduinofiretruck.screenswithnavigation

// This class applies names to each screen that will be used for the app
sealed class Screen(val route: String) {
    object MainActivity : Screen("main_screen")
    object BluetoothScreen : Screen("bluetooth_screen")
    object SettingsScreen : Screen("settings_screen")
    object DeviceScreen: Screen("device_screen")
    object SpeakerControlScreen: Screen("speaker_control_screen")

    object FiretruckController: Screen("firetruck_controller")

}
