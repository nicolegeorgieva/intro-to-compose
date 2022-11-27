package com.example.introtocompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.introtocompose.ui.theme.IntroToComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IntroToComposeTheme {
                MyApp()
                // A surface container using the 'background' color from the theme
            }
        }
    }
}

@Composable
fun MyApp() {
    var moneyCounter by remember {
        mutableStateOf(0)
    }

    var moneyCounter2 by remember {
        mutableStateOf(0)
    }

    Surface(
        modifier = Modifier.fillMaxSize(), color = Color(0xFF546E7A)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row() {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    ShowMoney(money = moneyCounter)
                    Spacer(modifier = Modifier.height(60.dp))
                    CreateCircle(
                        name = "Button 1",
                        onClick = {
                            moneyCounter += 1
                        }
                    )
                }

                Spacer(modifier = Modifier.width(40.dp))

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    ShowMoney(money = moneyCounter2)
                    Spacer(modifier = Modifier.height(60.dp))
                    CreateCircle(
                        name = "Button 2",
                        onClick = {
                            moneyCounter2 += 10
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun ShowMoney(money: Int) {
    Text(
        text = "$${money}",
        style = TextStyle(
            color = Color.White, fontSize = 35.sp, fontWeight = FontWeight.ExtraBold
        )
    )
}

@Composable
fun CreateCircle(name: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(3.dp)
            .size(105.dp)
            .clickable {
                onClick()
            }, shape = CircleShape, elevation = 4.dp
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(text = name, modifier = Modifier)
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    IntroToComposeTheme {
        MyApp()
    }
}