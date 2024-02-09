package com.hortis.hackathon24.components.text

import android.graphics.Color.parseColor
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SubTitle(
    modifier: Modifier = Modifier,
    text: String,
    pStart: Dp = 24.dp,
    pEnd: Dp = 24.dp,
    pBottom: Dp = 8.dp,
    pTop: Dp = 0.dp
) {
    Text(
        text = text,
        fontSize = 20.sp,
        fontWeight = FontWeight.SemiBold,
        color = Color(parseColor("#151515")),
        modifier = Modifier
            .padding(
                start = pStart,
                top = pTop,
                bottom = pBottom,
                end = pEnd
            )
    )
}