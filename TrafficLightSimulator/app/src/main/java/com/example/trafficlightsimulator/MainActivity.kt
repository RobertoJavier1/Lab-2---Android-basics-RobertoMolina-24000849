package com.example.trafficlightsimulator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.trafficlightsimulator.ui.theme.TrafficLightSimulatorTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme{
                //surface para definir un fondo
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background //color del tema claro o oscuro
                ) {
                    TrafficLightScreen()
                }
            }
        }
    }
}


enum class Light {Red,Yellow,Green}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TrafficLightScreen() {
    //para saber en que estado esta el semaforo en ese momento
    var actualLight by rememberSaveable() {mutableStateOf(Light.Red)}

    //LaunchedEffect ese una funcion de jetpack compose esta disenada para lanzar corrutinas relacionada a la vida del composable
    //el unit no cambia entonces solo se lanza una vez, si el composable se destruye se cancela la corrutina
    LaunchedEffect(Unit) {
        while(true){
            actualLight = Light.Red
            delay(2000)
            actualLight = Light.Green
            delay(2000)
            actualLight = Light.Yellow
            delay(1000)
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Traffic Light Simulator "
                    )
                }
            )
        }
    ) { paddingValues -> //espacio para que el contenido no quede cubierto por la topbar
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Card(
                modifier = Modifier
                    .width(200.dp)
                    .padding(vertical = 100.dp),
                    shape = MaterialTheme.shapes.large,
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF000000))

            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    //actualLight se va actualizando con LaunchedEffect
                    Circle(actualLight== Light.Red,Color.Red)
                    Spacer(Modifier.height(16.dp))

                    Circle(actualLight== Light.Yellow,Color.Yellow)
                    Spacer(Modifier.height(16.dp))

                    Circle(actualLight== Light.Green,Color.Green)
                    Spacer(Modifier.height(16.dp))
                }

            }
        }
    }



}

@Composable
fun Circle (on: Boolean,wcolor: Color){
    Box(
        modifier = Modifier
            .size(110.dp)
            .clip(CircleShape)
            .background(
                if (on)
                    wcolor
                else Color.Gray
            )
    )
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "Traffic Light Simulator"
)
@Composable
fun GreetingPreview() {
    MaterialTheme{
        TrafficLightScreen()
    }
}