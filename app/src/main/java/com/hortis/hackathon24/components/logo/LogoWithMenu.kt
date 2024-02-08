package com.hortis.hackathon24.components.logo

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LogoWithMenu() {
    Row(
        Modifier
            .padding(top = 48.dp, start = 24.dp, end = 24.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
    ) {
        Column(
            Modifier
                .height(100.dp)
                .padding(start = 14.dp)
                .weight(0.7f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Logo()
        }
        IconButton(onClick = { Log.d("Click", "IconExample") }) {
            Icon(
                imageVector = Icons.Outlined.Menu,
                contentDescription = "Home Icon"
            )
        }
    }
}