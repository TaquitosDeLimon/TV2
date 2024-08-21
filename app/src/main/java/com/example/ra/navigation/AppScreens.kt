package com.example.ra.navigation

sealed class AppScreens(val route: String) {
    object MoviesScreen: AppScreens("movies_screen")
    object MovieScreen: AppScreens("movie_screen/{id}") {
        fun createRoute(id: Int) = "movie_screen/$id"
    }
    object AboutScreen: AppScreens("about")
    object UpcomingScreen: AppScreens("upcoming_screen")
    object UpcomingDetailsScreen: AppScreens("upcoming_details_screen/{id}") {
        fun createRoute(id: Int) = "upcoming_details_screen/$id"
    }



}