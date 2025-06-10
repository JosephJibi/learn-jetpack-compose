package com.example.learnjetpackcompose

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.learnjetpackcompose.constants.Routes
import com.example.learnjetpackcompose.ui.screens.loginscreen.LoginScreen
import com.example.learnjetpackcompose.ui.screens.homescreen.HomeScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Routes.loginScreen,
        builder = {
            composable(Routes.homeScreen + "/{name}") {
                val user = it.arguments?.getString("name")
                HomeScreen(name = user ?: "unknown")
            }
            composable(Routes.loginScreen) { LoginScreen(navController) }
        })
}