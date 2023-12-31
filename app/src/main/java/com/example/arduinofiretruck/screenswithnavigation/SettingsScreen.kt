package com.example.arduinofiretruck.screenswithnavigation

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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.arduinofiretruck.R

@Composable

// The screen that will include all of the documentation for both the app and the arduino code along with the project manual
fun SettingsScreen(navController: NavController) {

    // The value used for the context of the screen and allowing transport to the web via a URL
    val ctx = LocalContext.current

    // The column that will be used for the screen and all of its contents
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
    ) {

        Text(
            style = MaterialTheme.typography.displayMedium,
            fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
            text = "Settings",
            fontSize = 50.sp
        )

        // The button that takes the user to the online project manual
        TextButton(
            onClick = {
                val urlIntent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://docs.google.com/document/d/1PY_xhP3uJRoFFLtjgHUj7D1yELH67P3XT6ZnWTKUn5o/edit?usp=sharing")
                )
                ctx.startActivity(urlIntent)
            },
            colors = ButtonDefaults.buttonColors(colorResource(R.color.white)),
            shape = RectangleShape,
            modifier = Modifier
                .offset(y = 100.dp)
                .width(200.dp)
                .size(100.dp)
        ) {
            Text(
                style = MaterialTheme.typography.displayMedium,
                text = "Manual",
                color = colorResource(R.color.black),
                fontSize = 30.sp
            )
        }

        // The button that takes the user to the github containing the code for the Arduino
        TextButton(
            onClick = {
                val urlIntent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://github.com/Colbertus/Fire-Truck")
                )
                ctx.startActivity(urlIntent)
            },
            colors = ButtonDefaults.buttonColors(colorResource(R.color.white)),
            shape = RectangleShape,
            modifier = Modifier
                .offset(y = 200.dp)
                .width(200.dp)
                .size(100.dp)
        ) {
            Text(
                style = MaterialTheme.typography.displayMedium,
                text = "Arduino Code",
                color = colorResource(R.color.black),
                fontSize = 25.sp
            )

        // The button that takes the user to the github containing the code for the app
        }
        TextButton(
            onClick = {
                val urlIntent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://github.com/Colbertus/Arduino-Firetruck-App")
                )
                ctx.startActivity(urlIntent)
            },
            colors = ButtonDefaults.buttonColors(colorResource(R.color.white)),
            shape = RectangleShape,
            modifier = Modifier
                .offset(y = 300.dp)
                .width(200.dp)
                .size(100.dp)
        ) {
            Text(
                style = MaterialTheme.typography.displayMedium,
                text = "App Code",
                color = colorResource(R.color.black),
                fontSize = 30.sp
            )
        }

        // The button that takes the user back to the main screen
        Button(
            onClick = {
                navController.navigate(Screen.MainActivity.route)
            },
            colors = ButtonDefaults.buttonColors(colorResource(R.color.white)),
            modifier = Modifier
                .offset(x = (-250).dp, y = (-350).dp)
                .size(75.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_subdirectory_arrow_left_24),
                contentDescription = null,
                tint = Color.Black,
                modifier = Modifier
                    .size(100.dp)
            )
        }
    }
}





