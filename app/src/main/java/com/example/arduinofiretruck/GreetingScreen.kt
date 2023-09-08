package com.example.arduinofiretruck

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable

// The function used for the main menu screen of the app
fun GreetingScreen(navController: NavController) {

    // The overhead column that will be used for the main menu screen and all of its contents
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)

    ) {
        Text(
            style = MaterialTheme.typography.displayMedium,
            fontWeight = FontWeight.Bold,
            text = "Hello Firefighter!",
            fontSize = 30.sp
        )
        Text(
            style = MaterialTheme.typography.displayMedium,
            fontWeight = FontWeight.Bold,
            text = "Welcome to the Firetruck App!",
            fontSize = 30.sp
        )

        //The row that is still under the column that will be used for the buttons
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {

            //The button used for the bluetooth screen containing the icon and text
            Button(
                onClick = {
                    navController.navigate(Screen.DeviceScreen.route)

                },
                colors = ButtonDefaults.buttonColors(colorResource(R.color.white)),
                modifier = Modifier
                    .size(125.dp)
                    .offset(x = 40.dp, y = 20.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_bluetooth_connected_24),
                    contentDescription = null,
                    tint = Color.Black,
                    modifier = Modifier
                        .size(75.dp)
                )
            }
            Text(
                text = "Bluetooth Connection",
                style = MaterialTheme.typography.displayMedium,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier
                    .offset(x = (-110).dp, y = 110.dp)
            )

            // The button used for the speaker control screen containing the icon and text
            Button(
                onClick = {
                          navController.navigate(Screen.SpeakerControlScreen.route)
                },
                colors = ButtonDefaults.buttonColors(colorResource(R.color.white)),
                modifier = Modifier
                    .size(125.dp)
                    .offset(x = 90.dp, y = 20.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_volume_up_24),
                    contentDescription = null,
                    tint = Color.Black,
                    modifier = Modifier
                        .size(75.dp)
                )
            }
            Text(
                text = "Speaker Control",
                style = MaterialTheme.typography.displayMedium,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier
                    .offset(x = (-40).dp, y = 110.dp)
            )
        }

        // The firetruck icon that is placed in the center of the screen
        Icon(
            painter = painterResource(id = R.drawable.baseline_fire_truck_24),
            contentDescription = null,
            modifier = Modifier
                .padding(2.dp)
                .size(300.dp)
                .offset(y = 50.dp)
        )

        // The button used for the remote controller screen containing the icon and text
        Button(
            onClick = {
                navController.navigate(Screen.FiretruckController.route)
                      },
            colors = ButtonDefaults.buttonColors(colorResource(R.color.white)),
            modifier = Modifier
                .offset(y = (100).dp)
                .size(125.dp)
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
            text = "Remote Controller",
            style = MaterialTheme.typography.displayMedium,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier
                .offset(y = 110.dp)
        )

        // Button used for the settings screen containing the icon
        Button(
            onClick = {
                navController.navigate(Screen.SettingsScreen.route)
            },
            colors = ButtonDefaults.buttonColors(colorResource(R.color.white)),
            modifier = Modifier
                .offset(x = 240.dp, y = 80.dp)
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
