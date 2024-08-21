package com.example.ra.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Card
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.ra.components.Drawer
import com.example.ra.components.TopAppBar
import com.example.ra.data.Movie
import com.example.ra.data.movies
import com.example.ra.navigation.AppScreens

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MoviesScreen(movies, NavController(context = LocalContext.current))
}

@Composable
fun MoviesScreen(movies: List<Movie>, navController: NavController) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Drawer(navController)
            }
        },
    ) {
        Scaffold(
            topBar = { TopAppBar("Películas", drawerState, scope) }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
//                    .background(Color(0xFFF0F0F0))
                    .padding(8.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                movies.forEach { movie ->
                    MovieCard(movie = movie, navController)
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }

        }
    }
}

@Composable
fun MovieCard(movie: Movie, navController: NavController) {
    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .clickable {
                navController.navigate(AppScreens.MovieScreen.createRoute(movie.id))
            }
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {
//            AsyncImage(
//                model = "https://example.com/image.jpg",
//                contentDescription = "Translated description of what the image contains"
//            )
            Image(
                painter = rememberImagePainter(data = movie.image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = movie.title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
//                    style = MaterialTheme.typography.h6.copy(
//                    )
                )
                Text(
                    text = "Director: ${movie.director}",
//                    style = MaterialTheme.typography.body2.copy(fontSize = 14.sp)
                )
//                Text(
//                    text = "Year: ${movie.releaseYear}",
////                    style = MaterialTheme.typography.body2.copy(fontSize = 14.sp)
//                )
                Text(
                    text = "Género: ${movie.genre}",
//                    style = MaterialTheme.typography.body2.copy(fontSize = 14.sp)
                )
//                Text(
//                    text = movie.description,
////                    style = MaterialTheme.typography.body2.copy(fontSize = 12.sp),
//                    maxLines = 3,
//                    overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis
//                )
            }
        }
    }

}
