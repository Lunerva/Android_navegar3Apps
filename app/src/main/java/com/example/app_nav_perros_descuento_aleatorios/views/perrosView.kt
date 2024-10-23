package com.example.app_nav_perros_descuento_aleatorios.views

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.app_nav_perros_descuento_aleatorios.components.TitleBar
import com.example.app_nav_perros_descuento_aleatorios.components.MainButton
import com.example.app_nav_perros_descuento_aleatorios.components.Space

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun perrosView(navController:NavController){
    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(
                title = { TitleBar(name = "Edad en Perros")},
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color.Magenta)
            )

    }){
        perrosViewContent(navController)
    }

}


@Composable
fun perrosViewContent(navController: NavController){
    val context = LocalContext.current
    Column(

        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        var edad by remember { mutableStateOf("") }
        var resultado by remember {
            mutableStateOf("")
        }
        Space()
        Space()
        Space()
        Space()
        Text(
            text="Mis Años Perrunos",
            modifier= Modifier.padding(16.dp),
            textAlign = TextAlign.Center,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif,
            color = Color.Magenta

        )
        Space()
        Space()
        OutlinedTextField(
            value = edad,
            onValueChange = { edad = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = { Text("Mi edad humana") }

        )
        Space()
        Space()
        ElevatedButton(
            onClick = {
                //require(edad.toInt()>=0)
                if(edad.compareTo("")==0){
                    Toast.makeText(context,"ingrese un valor valido por favor", Toast.LENGTH_SHORT).show()
                }else {
                    var res = 0
                    res = edad.toInt() * 7
                    resultado = res.toString()
                    Toast.makeText(context, "edad perruna: " + resultado, Toast.LENGTH_SHORT).show()
                }
            })
        {
            Text("Calcular")
        }
        ElevatedButton(onClick = {
            edad = ""
            resultado = ""
        }) {
            Text("Borrar")
        }

        OutlinedTextField(
            value = resultado,
            readOnly = true,
            onValueChange = { resultado = it },
            label = { Text("Edad Perruna") }
        )

        Space()
        Space()
        MainButton(name = "Descuento view", backColor = Color.Magenta, color = Color.White) {
            navController.navigate("descuento")
        }

    }
}

