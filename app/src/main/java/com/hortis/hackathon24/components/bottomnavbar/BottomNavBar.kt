package com.hortis.hackathon24.components.bottomnavbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.hortis.hackathon24.R

@Composable
fun BottomNavBar(
    navController: NavController
) {
    BottomAppBar(
        containerColor = Color(android.graphics.Color.parseColor("#FFFBFE")),
        contentColor = MaterialTheme.colorScheme.primary,
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                modifier = Modifier
                    .padding(
                        start = 10.dp,
                        end = 10.dp
                    )
                    .background(Color(android.graphics.Color.TRANSPARENT)),
                onClick = {
                    navController.navigate("home")
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                )) {
                Icon(
                    Icons.Filled.Home,
                    contentDescription = "Início",
                    modifier = Modifier.size(40.dp),
                    tint = Color.Black
                )
            }

            Button(
                modifier = Modifier
                    .padding(
                        start = 10.dp,
                        end = 10.dp
                    )
                    .background(Color(android.graphics.Color.TRANSPARENT)),
                onClick = {
                    navController.navigate("contracts") {
                        launchSingleTop = true
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                )) {
                Icon(
                    Icons.Filled.List,
                    contentDescription = "Contratos",
                    modifier = Modifier.size(40.dp),
                    tint = Color.Black
                )
            }

            Button(
                modifier = Modifier
                    .padding(
                        start = 10.dp,
                        end = 10.dp
                    )
                    .background(Color(android.graphics.Color.TRANSPARENT)),
                onClick = {
                    navController.navigate("announcements") {
                        launchSingleTop = true
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                )) {
                Icon(
                    Icons.Filled.DateRange,
                    contentDescription = "Anúncios",
                    modifier = Modifier.size(40.dp),
                    tint = Color.Black
                )
            }

        }
    }
}