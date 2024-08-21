package com.example.ra.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.NavType.Companion.StringType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ra.data.movies
import com.example.ra.screens.AboutScreen
import com.example.ra.screens.MovieDetailScreen
import com.example.ra.screens.MoviesScreen
import com.example.ra.screens.UpcomingDetailsScreen
import com.example.ra.screens.UpcomingScreen
import com.example.ra.viewmodel.MoviesViewModel


@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.MoviesScreen.route) {

        val viewModel = MoviesViewModel()

        composable(route = AppScreens.MoviesScreen.route) {
            MoviesScreen(movies, navController)
        }

        composable(
            route = AppScreens.MovieScreen.route,
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id")
            id?.let {
                MovieDetailScreen(navController, id)
            }
        }

        composable(route = AppScreens.AboutScreen.route) {
            AboutScreen(navController)
        }

        composable(route = AppScreens.UpcomingScreen.route) {
            UpcomingScreen(navController, viewModel)
        }

        composable(
            route = AppScreens.UpcomingDetailsScreen.route,
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id")
            id?.let {
                UpcomingDetailsScreen(navController, id, viewModel)
            }
        }
    }
}