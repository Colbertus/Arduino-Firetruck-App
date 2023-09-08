package com.example.arduinofiretruck
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.manalkaff.jetstick.JoyStick


@Composable

fun FiretruckController(navController: NavController) {

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
                    .offset(x = (-130).dp, y = 20.dp)
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
                text = "Controller",
                fontSize = 50.sp,
                modifier = Modifier
                    .offset(x = (-40).dp)
            )
        }
        JoyStick(
            Modifier.padding(30.dp),
            size = 150.dp,
            dotSize = 30.dp
        ){ x: Float, y: Float ->
            Log.d("JoyStick", "$x, $y")
        }
    }

}


