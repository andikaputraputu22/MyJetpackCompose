package com.moonlightsplitter.myjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Khusus contoh penggunaan state pada checkbox
            Column() {
                val checkboxState = remember {
                    mutableStateOf(false)
                }
                CustomCheckbox(text = "Checkbox 1", state = checkboxState.value) {
                    checkboxState.value = it
                    // Atau bisa pakai ini juga
//                    checkboxState.value = !checkboxState.value
                }
            }
        }
    }
}

@Composable
fun CustomCheckbox(text: String, state: Boolean, onCheckboxPressed: ((Boolean) -> Unit)?) {
    Row(
        modifier = Modifier.padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(checked = state, onCheckedChange = onCheckboxPressed)
        Spacer(modifier = Modifier.padding(4.dp))
        Text(text = text)
    }
}

@Composable
fun CustomButton(text: String, color: Color) {
    Button(onClick = {},
    modifier = Modifier
        .padding(16.dp)
        .clip(RoundedCornerShape(8.dp)),
    colors = ButtonDefaults.buttonColors(backgroundColor = color)) {
        Text(text = text, color = Color.White)
    }
}

@Composable
fun CobaRowColumn() {
    Column(modifier = Modifier.padding(16.dp)) {
        Column(
            modifier = Modifier
                .border(width = 1.dp, color = Color.Red)
                .fillMaxWidth()
                .height(200.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "I love you")
            Text(text = "I miss you")
        }
        Spacer(modifier = Modifier.padding(16.dp))
        Row(
            modifier = Modifier
                .border(width = 1.dp, color = Color.Red)
                .fillMaxWidth()
                .height(200.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "I love you", modifier = Modifier.align(Alignment.CenterVertically))
            Text(text = "I miss you", modifier = Modifier.align(Alignment.CenterVertically))
        }
    }
}

@Composable
fun CobaBox() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(0.5f)
        .background(color = Color.Yellow)
        .padding(16.dp)) {
        Box(modifier = Modifier
            .size(200.dp)
            .background(color = Color.Blue)
            .padding(16.dp)
            .border(width = 2.dp, color = Color.Black)
            .padding(16.dp)
            .border(width = 2.dp, color = Color.Black))
        Box(modifier = Modifier
            .offset(x = 250.dp, y = 250.dp)
            .size(64.dp)
            .border(width = 1.dp, color = Color.Red)) {

        }
    }
}