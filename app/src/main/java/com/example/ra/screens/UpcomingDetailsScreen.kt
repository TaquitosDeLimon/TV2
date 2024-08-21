package com.example.ra.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import com.example.ra.components.TopAppBarSecondary
import com.example.ra.viewmodel.MoviesViewModel

@Preview(showBackground = true)
@Composable
fun UpcomingDetailScreenPreview() {
    UpcomingDetailsScreen(navController = NavController(context = LocalContext.current), id = 2, viewModel = MoviesViewModel())
}

@Composable
fun UpcomingDetailsScreen(navController: NavController, id: Int, viewModel: MoviesViewModel) {

    val result by viewModel.movies.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchPopularMovies()
    }

    val movieList = result?.results

    val movie = movieList?.find { movie -> movie.id == id}
    Log.d("Movie", movie?.title ?: "Error")

    Scaffold(
        topBar = { TopAppBarSecondary(title = movie?.title ?: "Error", navController) },
    ) { innerPadding ->
        Row(
            modifier = Modifier
                .padding(innerPadding)
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp, 16.dp, 0.dp, 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Image(
                    painter = rememberImagePainter("https://image.tmdb.org/t/p/w500${movie?.poster_path}"),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(250.dp)
                        .height(400.dp)
                        .clip(RoundedCornerShape(12.dp))
                )
            }
            Column(
                modifier = Modifier
                    .weight(3f)
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Estreno",
//                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
//                            color = MaterialTheme.colorScheme.primary,
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = movie?.release_date ?: "Error",
                            fontWeight = FontWeight.Bold,
                            fontSize = 40.sp,
                            color = MaterialTheme.colorScheme.primary,
                        )
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                    ) {
                        Text(
                            text = "Lenguaje original: ${movie?.original_language ?: "Error"}",
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Título original: ${movie?.original_title ?: "Error"}",
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Promedio: ${movie?.vote_average ?: "Error"}",
                        )
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                    ) {
                        Text(
                            text = "Descripción",
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            color = MaterialTheme.colorScheme.primary,
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = movie?.overview ?: "Error",
                        )
                    }
                }
            }
        }
    }
}
