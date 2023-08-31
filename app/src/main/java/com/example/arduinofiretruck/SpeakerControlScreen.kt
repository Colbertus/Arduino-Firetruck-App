package com.example.arduinofiretruck

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
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
import androidx.navigation.NavController

@Composable

fun SpeakerControlScreen(navController: NavController) {
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
                .offset(x = (-250).dp, y = 20.dp)
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
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            TextButton(
                onClick = {},
                colors = ButtonDefaults.buttonColors(colorResource(R.color.white)),
                shape = RectangleShape,
                modifier = Modifier
                    .offset(y = 100.dp)
                    .width(200.dp)
                    .size(100.dp)
            ) {
                Text(
                    text = "Siren",
                    color = colorResource(R.color.black),
                    fontSize = 30.sp
                )
                TextButton(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(colorResource(R.color.white)),
                    shape = RectangleShape,
                    modifier = Modifier
                        .offset(y = 100.dp)
                        .width(200.dp)
                        .size(100.dp)
                ) {

                }

            }
        }
    }
}


