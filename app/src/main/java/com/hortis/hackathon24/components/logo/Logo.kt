package com.hortis.hackathon24.components.logo

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.hortis.hackathon24.R

@Composable
fun Logo(
    modifier : Modifier = Modifier
) {
    Image(
        painter = painterResource(id = R.drawable.logo),
        contentDescription = "hortis logo",
        modifier = Modifier
            .size(115.dp)
            .aspectRatio(ratio = 1.5f),
        alignment = Alignment.CenterStart
    )
}