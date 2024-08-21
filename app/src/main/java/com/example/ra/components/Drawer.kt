package com.example.ra.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ra.navigation.AppScreens

@Composable
fun Drawer(
    navController: NavController,
//    onMoviesClick: () -> Unit,
//    onAboutClick: () -> Unit
) {
    Column(
        modifier = Modifier
//            .background(Color.White)
            .fillMaxSize()
    ) {
        // Optional: Add a header for the drawer
        DrawerHeader()

        // Add the drawer items
        DrawerItem(
            icon = Icons.Default.PlayArrow,
            label = "Películas",
            onClick = {
                navController.navigate(AppScreens.MoviesScreen.route)
            }
        )
        DrawerItem(
            icon = Icons.Default.DateRange,
            label = "Próximamente",
            onClick = {
                navController.navigate(AppScreens.UpcomingScreen.route)
            }
        )
        DrawerItem(
            icon = Icons.Default.Info,
            label = "Acerca de",
            onClick = {
                navController.navigate(AppScreens.AboutScreen.route)
            }
        )
    }
}

@Composable
fun DrawerHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primaryContainer)
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Películas",
//            color = MaterialTheme.colorScheme.primary,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun DrawerItem(
    icon: ImageVector,
    label: String,
    onClick: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(16.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = label,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = label,
            fontSize = 18.sp
        )
    }
}
