package com.hortis.hackathon24.components.button

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.hortis.hackathon24.R

@Composable
fun Upload(
    modifier: Modifier = Modifier,
    showIcon: Boolean = true,
    text: String = "Escolher fotos",
    weight: FontWeight = FontWeight.Normal,
    style: TextStyle = MaterialTheme.typography.labelLarge
) {
    Button(
        onClick = { },
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xff033f63)),
        contentPadding = PaddingValues(
            start = 16.dp,
            top = 10.dp,
            end = 24.dp,
            bottom = 10.dp
        ),
        modifier = modifier
            .requiredWidth(width = 364.dp)
            .height(56.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .requiredWidth(width = 364.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (showIcon) {
                    Image(
                        painter = painterResource(id = R.drawable.upload),
                        contentDescription = "icon",
                        colorFilter = ColorFilter.tint(Color(0xfff2f2f2)),
                        modifier = Modifier
                            .requiredSize(size = 18.dp)
                    )
                }
                Text(
                    text = text,
                    color = Color(0xfff2f2f2),
                    fontWeight = weight,
                    textAlign = TextAlign.Center,
                    lineHeight = 1.43.em,
                    style = style,
                    modifier = Modifier
                        .wrapContentHeight(align = Alignment.CenterVertically)
                )
            }
        }
    }
}
