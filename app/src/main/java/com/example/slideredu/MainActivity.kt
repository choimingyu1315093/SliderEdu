package com.example.slideredu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.util.toRange
import com.example.slideredu.ui.theme.SliderEduTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SliderEduTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RangeSlider()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BasicSlider(modifier: Modifier = Modifier){
    var sliderValue by remember { mutableStateOf(0f) }

    Column {
        Text(
            text = "sliderValue ${sliderValue.toInt()}"
        )
        Slider(
            value = sliderValue,
            onValueChange = {
                sliderValue = it
            },
            valueRange = 0f..100f,
            colors = SliderDefaults.colors(
                thumbColor = Color.Red,
                activeTrackColor = Color.Black,
                inactiveTrackColor = Color.Cyan
            ),
            steps = 9
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RangeSlider(modifier: Modifier = Modifier){
    var sliderValue by remember { mutableStateOf(0f..100f) }

    Column {
        Text(
            text = "sliderValue ${sliderValue.start.toInt()} ~ ${sliderValue.endInclusive.toInt()}"
        )
        androidx.compose.material3.RangeSlider(
            value = sliderValue,
            onValueChange = {
                sliderValue = it
            },
            valueRange = 0f..100f,
        )
    }
}