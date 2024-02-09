package com.hortis.hackathon24.components.bottomNavBar

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hortis.hackathon24.R
import com.hortis.hackathon24.views.Announcements

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
                    painter = painterResource(id = R.drawable.baseline_bluetooth_searching_24),
                    contentDescription = ""
                )
            }

            Button(onClick = {
                navController.navigate("announcements") {
                    launchSingleTop = true
                }
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_bluetooth_searching_24),
                    contentDescription = ""
                )
            }
        }
    }
}