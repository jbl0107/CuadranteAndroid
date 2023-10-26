package com.example.cuadrante

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cuadrante.ui.theme.CuadranteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CuadranteTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    QuadrantFinal()
                }
            }
        }
    }
}

@Composable
fun QuadrantFinal(modifier: Modifier = Modifier) {

    //el fillMaxWidth es para q ocupe all el ancho disponible. Este es su valor por defecto salvo q haya algo q lo cambie. Aqui esta solo por asegurar
    Column (modifier = modifier.fillMaxWidth()) {

        Row(Modifier.weight(1f)) { //este weight es para q el espacio disponible en la dirección horizontal (ancho) se divide equitativamente entre los 2
            // Quadrant en el Row. Cada Quadrant dentro del Row obtiene una parte igual del espacio horizontal disponible
            Quadrant(
                title = "Text Compose",
                text = "Displays text and follows the recommended Material Design guidelines.",
                color = Color(0xFFEADDFF),
                modifier = Modifier.weight(1f) //este weight es para q dentro del espacio que se les asignó en el Row, el espacio disponible se divide equitativamente
                // entre el title y el text dentro de cada Quadrant. Cada Quadrant se divide verticalmente de manera equitativa.

            )

            Quadrant(
                title = "Image Compose",
                text = "Creates a composable that lays out and draws a given Painter class object.",
                color = Color(0xFFD0BCFF),
                modifier = Modifier.weight(1f)

            )
        }

        Row(Modifier.weight(1f)) {
            Quadrant(
                title = "Row Compose",
                text = "A layout composable that places its children in a horizontal sequence",
                color = Color(0xFFB69DF8),
                modifier = Modifier.weight(1f)

            )

            Quadrant(
                title = "Column Compose",
                text = "A layout composable that places its children in a horizontal sequence",
                color = Color(0xFFF6EDFF),
                modifier = Modifier.weight(1f)

            )
        }

    }
}

@Composable
fun Quadrant(title: String, text: String, color: Color, modifier: Modifier = Modifier) {

    Column(verticalArrangement = Arrangement.Center , horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize() //se utiliza para que ocupe all espacio disponible en su contenedor. En este caso, lo hace por defecto
            .background(color)
            .padding(16.dp)


    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(bottom = 16.dp)
        )
        Text(
            text = text,
            textAlign = TextAlign.Justify,
            modifier = modifier
        )
    }

}





@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    CuadranteTheme {
        QuadrantFinal()
    }
}