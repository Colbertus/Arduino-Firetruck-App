/* This app will be used for controlling the Arduino Uno that will be used to control a model firetruck for the Huntsville Fire Department. Some included
* functionalities are bluetooth, direct motor controlling, the water pump, and the use of the speaker system. Still currently a work in progress. Uses navigation,
* compose, and bluetooth libraries for functionality. Created by Colby McClure at SMAP, with assistance of Philipp Lackner's code. */

package com.example.arduinofiretruck.presentation

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothManager
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.arduinofiretruck.screenswithnavigation.Navigation
import com.example.arduinofiretruck.R
import com.example.arduinofiretruck.ui.theme.ArduinoFiretruckTheme
import dagger.hilt.android.AndroidEntryPoint
import java.util.*


@RequiresApi(Build.VERSION_CODES.M)

// Android Entry Point is required for displaying the view models
@AndroidEntryPoint

public class MainActivity : ComponentActivity() {

    private val bluetoothManager by lazy {
        applicationContext.getSystemService(BluetoothManager::class.java)
    }

    private val bluetoothAdapter by lazy {
        bluetoothManager?.adapter
    }

    private val isBluetoothEnabled: Boolean
        get() = bluetoothAdapter?.isEnabled == true

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState);

        val enableBluetoothLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { /* not needed */ }

        val permissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) { perms ->
            val canEnableBluetooth = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                perms[android.Manifest.permission.BLUETOOTH_CONNECT] == true
            } else true

            if (canEnableBluetooth && !isBluetoothEnabled) {
                enableBluetoothLauncher.launch(
                    Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
                )
            }
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            permissionLauncher.launch(
                arrayOf(
                    android.Manifest.permission.BLUETOOTH_SCAN,
                    android.Manifest.permission.BLUETOOTH_CONNECT,
                )
            )
        }

        // Will set the main activity to the Navigation.kt file, which will direct the main screen to be the Greeting screen
        setContent {
            ArduinoFiretruckTheme {
                val viewModel = hiltViewModel<BluetoothViewModel>()
                val state by viewModel.state.collectAsState()
                Navigation(
                    state = state,
                    onStartScan = viewModel:: startScan,
                    onStopScan = viewModel::stopScan
                )
            }
            setTheme(R.style.Theme_ArduinoFiretruck)

            // Sets the screen orientation to portrait and locks it there
            this.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
            this.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LOCKED
        }
    }
}



