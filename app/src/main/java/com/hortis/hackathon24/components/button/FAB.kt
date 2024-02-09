package com.hortis.hackathon24.components.button

import android.graphics.Color.parseColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController

@Composable
fun FAB(
    modifier: Modifier = Modifier,
    text: String,
    navController: NavHostController
) {

    val onClick = { navController.navigate("create_announcement") {
        launchSingleTop = true
    } }

    ExtendedFloatingActionButton(
        text = {
            Text(
                text = text,
                color = Color.White
            )
        },
        onClick = onClick,
        icon = {
            Icon(
                Icons.Filled.Add, "",
                tint = Color.White
            )
        },
        containerColor = Color(parseColor("#033F63"))
    )

}