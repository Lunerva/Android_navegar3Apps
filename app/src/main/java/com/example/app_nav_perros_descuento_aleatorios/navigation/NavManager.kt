package com.example.app_nav_perros_descuento_aleatorios.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.app_nav_perros_descuento_aleatorios.views.descuentoView
import com.example.app_nav_perros_descuento_aleatorios.views.perrosView
import com.example.app_nav_perros_descuento_aleatorios.views.aleatorioView

@Composable
fun NavManager(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Perros"  )
    {
        composable("Perros"){
            perrosView(navController)
        }
        composable("descuento"){
            descuentoView(navController = navController)
        }
        composable("aleatorio"){
            aleatorioView(navController)
        }
    }
}