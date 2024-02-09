package com.hortis.hackathon24.components.text

import android.graphics.Color.parseColor
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Title(
    modifier: Modifier = Modifier,
    text: String
) {
    Text(
        text = text,
        fontSize = 22.sp,
        fontWeight = FontWeight.Bold,
        color = Color(parseColor("#151515")),
        modifier = Modifier
            .padding(
                start = 24.dp,
                top = 24.dp,
                bottom = 8.dp
            )
    )
}