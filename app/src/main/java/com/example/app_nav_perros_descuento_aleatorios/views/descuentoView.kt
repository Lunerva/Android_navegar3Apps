package com.example.app_nav_perros_descuento_aleatorios.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.app_nav_perros_descuento_aleatorios.components.TitleBar
import com.example.app_nav_perros_descuento_aleatorios.components.contentDescuento
import com.example.app_nav_perros_descuento_aleatorios.components.MainButton
import com.example.app_nav_perros_descuento_aleatorios.components.MainIconButton
import com.example.app_nav_perros_descuento_aleatorios.components.Space

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun descuentoView(navController:NavController){
    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(
                title = { TitleBar(name = "Descuento")},
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color.Yellow)
                ,
                navigationIcon = {
                    MainIconButton(icon = Icons.Default.ArrowBack) {
                        navController.popBackStack()
                    }
                }
            )
        }){
        descuentoViewContent(navController)
    }

}


@Composable
fun descuentoViewContent(navController: NavController){
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
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        OutlinedTextField(
            value = precio,
            onValueChange = { precio = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp),
            placeholder = { Text(text = "ingrese el numero") }
        )
        Space()
        OutlinedTextField(
            value = desc,
            onValueChange = { desc = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp),
            placeholder = { Text(text = "ingrese el descuento") }
        )
        Space()

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

        Space()
        Space()
        Space()
        Space()
        MainButton(name = "aleatorio view", backColor = Color.Yellow, color = Color.White) {
            navController.navigate("aleatorio")
        }
    }
}

