package com.example.arduinofiretruck.screenswithnavigation

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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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

fun SpeakerControlScreen(navController: NavController) {
    var sliderPosition by remember { mutableFloatStateOf(0f) }

    val ctx = LocalContext.current

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = {
                    navController.navigate(Screen.MainActivity.route)
                },
                colors = ButtonDefaults.buttonColors(colorResource(R.color.white)),
                modifier = Modifier
                    .offset(x = (-80).dp, y = 20.dp)
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

            Text(
                style = MaterialTheme.typography.displayMedium,
                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                fontSize = 50.sp,
                text = "Speaker Control",
                modifier = Modifier
                    .offset(x = (-40).dp)
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextButton(
                onClick = {},
                colors = ButtonDefaults.buttonColors(colorResource(R.color.white)),
                shape = RectangleShape,
                modifier = Modifier
                    .offset(x = (-80).dp, y = 100.dp)
                    .width(200.dp)
                    .size(100.dp)
            ) {
                Text(
                    style = MaterialTheme.typography.displayMedium,
                    text = "Siren",
                    color = colorResource(R.color.black),
                    fontSize = 30.sp
                )
            }
                TextButton(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(colorResource(R.color.white)),
                    shape = RectangleShape,
                    modifier = Modifier
                        .offset(x = 80.dp, y = 100.dp)
                        .width(200.dp)
                        .size(100.dp)
                ) {
                    Text(
                        style = MaterialTheme.typography.displayMedium,
                        text = "Horn",
                        color = colorResource(R.color.black),
                        fontSize = 30.sp
                    )
                }

        }
        TextButton(
            onClick = {},
            colors = ButtonDefaults.buttonColors(colorResource(R.color.white)),
            shape = RectangleShape,
            modifier = Modifier
                .offset(y = 300.dp)
                .width(200.dp)
                .size(100.dp)
        ) {
            Text(
                style = MaterialTheme.typography.displayMedium,
                text = "Stop Sound",
                color = colorResource(R.color.black),
                fontSize = 30.sp
            )
        }
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            colors = SliderDefaults.colors(
                thumbColor = colorResource(R.color.white),
                activeTrackColor = colorResource(R.color.black),
                inactiveTrackColor = colorResource(R.color.black)
            ),
            modifier = Modifier
                .offset(y = 400.dp)
                .width(500.dp)
                .size(100.dp)
        )
    }
}


