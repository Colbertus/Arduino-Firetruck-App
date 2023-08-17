package com.example.arduinofiretruck

import android.bluetooth.BluetoothAdapter
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.os.Looper
import android.text.style.BackgroundColorSpan
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.navigation.NavController
import com.example.arduinofiretruck.ConnectThread.handler
import com.example.arduinofiretruck.ui.theme.ArduinoFiretruckTheme
import android.bluetooth.BluetoothManager as BluetoothManager1
import android.bluetooth.BluetoothManager as BluetoothManager2
import java.io.IOException
import java.util.*

public class MainActivity : AppCompatActivity() {
    // private static final String TAG = "MY_APP_DEBUG_TAG";
    // private static final int REQUEST_ENABLE_BT = 1;
    // public static Handler handler;
    // private final static int ERROR_READ = 0;
    // BluetoothDevice arduinoBTModule = null;
    // UUID arduinoUUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContent {
            this.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
            this.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LOCKED
            Navigation()
        }
        // BluetoothManager bluetoothManager = getSystemService(BluetoothManager.class);
        // BluetoothAdapter bluetoothAdapter = bluetoothManager.getAdapter();

         /* handler = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case ERROR_READ:
                        Toast.makeText(getApplicationContext(), "Error reading data", Toast.LENGTH_SHORT).show();
                        break;
                }
            }

        } */

    }
}


@Composable

fun Greeting(navController: NavController) {

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)

            ) {
        Text(
            style = MaterialTheme.typography.displayMedium,
            fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
            text = "Hello Firefighter!",
            fontSize = 30.sp
        )
        Text(
            style = MaterialTheme.typography.displayMedium,
            fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
            text = "Welcome to the Firetruck App",
            fontSize = 30.sp
        )
        Icon(
            painter = painterResource(id = R.drawable.baseline_fire_truck_24),
            contentDescription = null,
            modifier = Modifier
                .padding(2.dp)
                .size(300.dp)
                .offset(y = 250.dp)
        )
        Button(
            onClick = {
                      // navController.navigate(Screen.BluetoothScreen.route)


            },
            colors = ButtonDefaults.buttonColors(colorResource(R.color.white)),
            modifier = Modifier
                .offset(x = (-200).dp, y = (-200).dp)
                .size(150.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_bluetooth_connected_24),
                contentDescription = null,
                tint = Color.Black,
                modifier = Modifier
                    .size(75.dp)
            )
        }
        Button(
            onClick = {

            },
            colors = ButtonDefaults.buttonColors(colorResource(R.color.white)),
            modifier = Modifier
                .offset(x = 200.dp, y = (-350).dp)
                .size(150.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_volume_up_24),
                contentDescription = null,
                tint = Color.Black,
                modifier = Modifier
                    .size(75.dp)

            )
        }
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(colorResource(R.color.white)),
            modifier = Modifier
                .size(150.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_control_camera_24),
                contentDescription = null,
                tint = Color.Black,
                modifier = Modifier
                    .size(75.dp)
            )
        }
        Text(
            text = "Bluetooth Connection",
            style = MaterialTheme.typography.displayMedium,
            fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier
                 .offset(x = (-190).dp, y = (-490).dp)
        )
        Text(
            text = "Speaker Control",
            style = MaterialTheme.typography.displayMedium,
            fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier
                .offset(x = 200.dp, y = (-520).dp)
        )
        Text(
            text = "Remote Controller",
            style = MaterialTheme.typography.displayMedium,
            fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier
                .offset(y = (-45).dp)
        )
        Button(
            onClick = {
                      navController.navigate(Screen.SettingsScreen.route)
            },
            colors = ButtonDefaults.buttonColors(colorResource(R.color.white)),
            modifier = Modifier
                .offset(x = 250.dp, y = (-40).dp)
                .size(75.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_settings_24),
                contentDescription = null,
                tint = Color.Black,
                modifier = Modifier
                    .size(75.dp)
            )
        }
    }

}




