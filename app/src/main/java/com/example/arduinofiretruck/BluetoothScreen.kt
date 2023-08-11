package com.example.arduinofiretruck

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavController
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothSocket
import android.bluetooth.BluetoothManager

@Composable

fun BluetoothScreen(navController: NavController) {


    val ctx = LocalContext.current

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
    ) {
        Button(
            onClick = {
                      navController.navigate(Screen.MainActivity.route)
            },
            colors = ButtonDefaults.buttonColors(colorResource(R.color.white)),
            modifier = Modifier
                .size(75.dp)
                .offset(x = (-250.dp), y = 20.dp)
        ) {
            Icon (
                painter = painterResource(id = R.drawable.baseline_subdirectory_arrow_left_24),
                contentDescription = null,
                tint = Color.Black
                    )
        }
        Text(
            style = MaterialTheme.typography.displayMedium,
            fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
            text = "Bluetooth"
        )
        Text(
            text = "Steps to connect via Bluetooth",
            fontSize = 30.sp,
        )
        Text(
            text = "1. Click the button below to open the Bluetooth Low Energy App. " +
                    "If no devices are present upon opening the app, drag down on " +
                    "the tablet to refresh the page until devices start popping up. ",
            fontSize = 20.sp,
            modifier = Modifier
                .offset(y = 10.dp)
        )
        Text(
            text = "2. Upon looking at the list of devices, look for a device labeled" +
                    " 'DSD TECH'. If you cannot see the specific device, double " +
                    "check to see if the firetruck is turned on, it must be turned " +
                    "on in order to connect.",
            fontSize = 20.sp,
            modifier = Modifier
                .offset(y = 30.dp)
        )
        Text(
            text = "3. Once you have spotted the 'DSD TECH' device, click the " +
                    "green 'Connect' button on the right-hand side of the 'DSD TECH'" +
                    " row within the app.",
            fontSize = 20.sp,
            modifier = Modifier
                .offset(y = 50.dp)
        )
        Text(
            text = "4. Once the green 'Connect' has been hit, you will be taken to " +
                    "another screen within the app. " +
                    "If you see the text 'DISCONNECT' on the top-right side of the" +
                    " screen, that means that the bluetooth module is connected. If " +
                    "the text on the top-right hand side of the screen says 'CONNECT'" +
                    ", then the bluetooth did not connect on the first try. If this is the " +
                    "case, then keep clicking on the 'CONNECT' text on the top-right side until " +
                    "the text says 'DISCONNECT'. It may take a few tries, but if the firetruck" +
                    " is on, then it should eventually connect.",
            fontSize = 20.sp,
            modifier = Modifier
                .offset(y = 70.dp)
        )
        Text (
            text = "5. Once you are connected, click the square shaped button on the" +
                    " bottom and click on the firetruck's app window and re-enter " +
                    "the app. DISCLAIMER: closing the bluetooth app will disconnect " +
                    "you from controlling the firetruck. Once you are back on the " +
                    "app, click the back arrow on this screen and feel free to start" +
                    " controlling the firetruck. ",
            fontSize = 20.sp,
            modifier = Modifier
                .offset(y = 90.dp)
        )
        TextButton(
            onClick = {
                val appIntent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://play.google.com/store/apps/details?id=com.macdom.ble.blescanner&hl=en_US&gl=US")
                )
                ctx.startActivity(appIntent)
            },
            colors = ButtonDefaults.buttonColors(colorResource(R.color.white)),
            shape = RectangleShape,
            modifier = Modifier
                .offset(y = 100.dp)
                .width(300.dp)
                .size(100.dp)
        ) {
            Text(
                text = "Bluetooth App",
                color = colorResource(R.color.black),
                fontSize = 30.sp
            )

        }

    }
}



