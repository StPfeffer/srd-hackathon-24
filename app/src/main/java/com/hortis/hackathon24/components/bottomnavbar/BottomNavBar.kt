package com.hortis.hackathon24.components.bottomnavbar

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.hortis.hackathon24.R

@Composable
fun BottomNavBar(
    navController : NavController
) {
    BottomAppBar(
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        contentColor = MaterialTheme.colorScheme.primary,
    ) {


        Row(modifier = Modifier.fillMaxWidth()) {
            Button(onClick = {
                navController.navigate("home")
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.home),
                    contentDescription = "Início"
                )
            }

            Button(onClick = {
                navController.navigate("announcements") {
                    launchSingleTop = true
                }
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.anuncios),
                    contentDescription = "Anúncios"
                )
            }
        }
    }
}