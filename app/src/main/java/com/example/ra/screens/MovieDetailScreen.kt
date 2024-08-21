package com.example.ra.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.graphics.Color
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

@Preview(showBackground = true)
@Composable
fun MovieDetailScreenPreview() {
    MovieDetailScreen(navController = NavController(context = LocalContext.current), id = 2)
}

@Composable
fun MovieDetailScreen(navController: NavController, id: Int) {
    val movie = movies.find { movie -> movie.id == id }

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
        topBar = { TopAppBar(title = movie?.title ?: "Error", drawerState, scope) }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
//                    .background(Color(0xFFF0F0F0))
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                Image(
                    painter = rememberImagePainter(movie?.image ?: ""),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(500.dp)
                        .clip(RoundedCornerShape(12.dp))
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = movie?.title ?: "Error",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                   color = MaterialTheme.colorScheme.primary,
//            style = MaterialTheme.typography.h4.copy(
//            )
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Director: ${movie?.director ?: "Error"}",
//            style = MaterialTheme.typography.body1.copy(fontSize = 18.sp)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Año: ${movie?.releaseYear ?: "Error"}",
//            style = MaterialTheme.typography.body1.copy(fontSize = 18.sp)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Género: ${movie?.genre ?: "Error"}",
//            style = MaterialTheme.typography.body1.copy(fontSize = 18.sp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Descripción",
//            style = MaterialTheme.typography.h6.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = MaterialTheme.colorScheme.primary,
                )

                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = movie?.description ?: "Error",
//            style = MaterialTheme.typography.body2.copy(fontSize = 16.sp)
                )
            }
        }
    }
}
