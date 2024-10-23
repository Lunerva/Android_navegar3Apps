package com.example.app_nav_perros_descuento_aleatorios.views

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.app_nav_perros_descuento_aleatorios.components.MainButton
import com.example.app_nav_perros_descuento_aleatorios.components.MainIconButton
import com.example.app_nav_perros_descuento_aleatorios.components.Space
import com.example.app_nav_perros_descuento_aleatorios.components.TitleBar
import  com.example.app_nav_perros_descuento_aleatorios.viewModel.LoteriaViewModel



@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun aleatorioView(navController: NavController){
    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(
                title = { TitleBar(name = "Aleatorio") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color.Green),
                navigationIcon = {
                    MainIconButton(icon = Icons.Default.ArrowBack) {
                        navController.popBackStack()
                    }
                }
            )
        }){
        aleatorioViewContent(navController)
    }

}


@Composable
fun aleatorioViewContent(navController: NavController){

    val viewModel: LoteriaViewModel= viewModel()
    LoteriaView(viewModel = viewModel,navController)


}



@Composable
fun LoteriaView(viewModel:LoteriaViewModel,navController: NavController){
    val lottonNumbers = viewModel.lotoNumbers.value
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement =  Arrangement.Center,
        horizontalAlignment =  Alignment.CenterHorizontally
    ) {
        if(lottonNumbers.isEmpty()){
            Text(text = "Loteria", fontSize = 40.sp, fontWeight = FontWeight.Bold)
        }else{
            LotteyNumbers(lottonNumbers)
        }
        Button(onClick = {  viewModel.generateLotoNumbers() }) {
            Text(text = "Generar", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        }

        Space()
        Space()
        Space()
        Space()
        MainButton(name = "perros view", backColor = Color.Green, color = Color.White) {
            navController.navigate("Perros")
        }

    }
}

@Composable
fun LotteyNumbers(lottonNumbers: List<Int>){
    LazyRow(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)) {
        items(lottonNumbers){
                number -> Box(
            contentAlignment = Alignment.Center, modifier = Modifier
                .padding(horizontal = 8.dp)
                .size(48.dp)
                .background(
                    Color.Red, CircleShape
                )
        ) {
            Text(text = number.toString(), color = Color.White, fontSize = 24.sp)
        }
        }
    }
}