package com.hortis.hackathon24.components.notfound

import android.graphics.Color.parseColor
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.em

@Composable
fun NotFound(
    modifier: Modifier = Modifier,
    text: String
) {
    Text(
        text = text,
        color = Color(parseColor("#2C2C2C")),
        textAlign = TextAlign.Center,
        lineHeight = 1.43.em,
        style = MaterialTheme.typography.labelLarge,
        modifier = Modifier
            .wrapContentHeight(align = Alignment.CenterVertically))
}