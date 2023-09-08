/* This app will be used for controlling the Arduino Uno that will be used to control a model firetruck for the Huntsville Fire Department. Some included
* functionalities are bluetooth, direct motor controlling, the water pump, and the use of the speaker system. Still currently a work in progress. Uses navigation,
* compose, and bluetooth libraries for functionality. Created by Colby McClure at SMAP, with assistance of Philipp Lackner's code. */

package com.example.arduinofiretruck

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothManager
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Build
import android.os.Bundle
import android.os.Looper
import android.text.style.BackgroundColorSpan
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.getSystemService
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import com.example.arduinofiretruck.ui.theme.ArduinoFiretruckTheme
import dagger.hilt.android.AndroidEntryPoint
import android.bluetooth.BluetoothManager as BluetoothManager1
import android.bluetooth.BluetoothManager as BluetoothManager2
import java.io.IOException
import java.util.*
import androidx.compose.runtime.LaunchedEffect as LaunchedEffect1


@RequiresApi(Build.VERSION_CODES.M)

// Android Entry Point is required for displaying the view models
@AndroidEntryPoint

public class MainActivity : AppCompatActivity() {
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



