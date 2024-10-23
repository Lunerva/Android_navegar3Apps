package com.example.app_nav_perros_descuento_aleatorios.components
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.app_nav_perros_descuento_aleatorios.R



@Composable
fun TitleView(name: String){
    Text(text = name, fontSize = 40.sp, fontWeight = FontWeight.Bold)
}

@Composable
fun Space(){
    Spacer(modifier = Modifier.height(10.dp))
}

@Composable
fun MainButton(name:String, backColor: Color, color: Color, onClick:() -> Unit){
    Button(onClick = onClick, colors = ButtonDefaults.buttonColors(
        contentColor = color,
        containerColor = backColor
    ) ) {
        Text(text = name)
    }
}




@Composable
fun contentDescuento(){

    var precio by remember {
        mutableStateOf("")
    }
    var desc by remember {
        mutableStateOf("")
    }

    var descuento by remember {
        mutableStateOf("")
    }
    var total by remember {
        mutableStateOf("")
    }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        OutlinedTextField(
            value = precio,
            onValueChange = { precio = it },
            modifier = Modifier.fillMaxWidth().padding(horizontal = 30.dp)
        )
        OutlinedTextField(
            value = desc,
            onValueChange = { desc = it },
            modifier = Modifier.fillMaxWidth().padding(horizontal = 30.dp)
        )

        Row{
            Button(onClick = {
                descuento = ((desc.toFloat()/100)*precio.toFloat()).toString()
                total = (precio.toFloat()-descuento.toFloat()).toString()
            }) {
                Text(text = "Calcular")
            }
            Button(onClick = {
                precio=""
                desc=""
                descuento=""
                total=""
            }) {
                Text(text = "Limpiar")
            }
        }
        Text(
            text = "Descuento de $ $descuento",
            fontSize = 30.sp
        )
        Text(
            text = "Total de $ $total",
            fontSize = 30.sp
        )
    }


}
