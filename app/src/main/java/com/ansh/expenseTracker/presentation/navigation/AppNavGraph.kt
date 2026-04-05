package com.ansh.expenseTracker.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavGraph(navController : NavHostController) {
    NavHost(navController = navController , startDestination = "dashboard") {
        composable("dashboard") { /* DashboardScreen() */ }
        composable("transactions") { /* TransactionScreen() */ }
        composable("goal") { /* GoalScreen() */ }
        composable("insights") { /* InsightsScreen() */ }
    }
}