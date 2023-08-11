package com.example.arduinofiretruck
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp




@Composable

fun FiretruckController() {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
    ) {
        Text(
            style = MaterialTheme.typography.displayMedium,
            fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
            text = "Controller",
            fontSize = 50.sp
        )



    }
}

@Preview(showBackground = true, device = "id:Kindle Fire 7 (2022)")
@Composable
fun FiretruckControllerPreview() {
    FiretruckController()
}