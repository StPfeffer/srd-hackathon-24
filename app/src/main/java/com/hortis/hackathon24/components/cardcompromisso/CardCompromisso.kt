package com.hortis.hackathon24.components.cardcompromisso

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.hortis.hackathon24.R

@Composable
fun Horizontalcard(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .requiredWidth(width = 360.dp)
            .requiredHeight(height = 80.dp)
            .clip(shape = RoundedCornerShape(12.dp))
    ) {
        Row(
            modifier = Modifier
                .requiredWidth(width = 360.dp)
                .requiredHeight(height = 80.dp)
        ) {
            Surface(
                shape = RoundedCornerShape(12.dp),
                border = BorderStroke(1.dp, Color(0xffcac4d0)),
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(12.dp))
            ) {
                Box(
                    modifier = Modifier
                        .requiredWidth(width = 360.dp)
                        .requiredHeight(height = 80.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.Start),
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .weight(weight = 1f)
                                .padding(all = 16.dp)
                        ) {
                            Column(
                                verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top),
                                modifier = Modifier
                                    .fillMaxWidth()
                            ) {
                                Text(
                                    text = "Alface americana",
                                    color = Color(0xff151515),
                                    lineHeight = 1.5.em,
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Medium,
                                        letterSpacing = 0.15.sp
                                    ),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                )
                                Text(
                                    text = "40 kg restantes • R$ 74,90",
                                    color = Color(0xff264653),
                                    textAlign = TextAlign.Center,
                                    lineHeight = 1.43.em,
                                    style = TextStyle(
                                        fontSize = 14.sp,
                                        letterSpacing = 0.25.sp
                                    )
                                )
                            }
                        }
                        Box(
                            modifier = Modifier
                                .fillMaxHeight()
                                .requiredWidth(width = 80.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.baseline_bluetooth_searching_24),
                                contentDescription = "media",
                                modifier = Modifier
                                    .fillMaxSize()
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun HorizontalcardPreview() {
    Horizontalcard(Modifier)
}