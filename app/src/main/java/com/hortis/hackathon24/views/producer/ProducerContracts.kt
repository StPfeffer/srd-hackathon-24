package com.hortis.hackathon24.views.producer

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.hortis.hackathon24.R
import com.hortis.hackathon24.components.text.Title

@Composable
fun ProducerContracts(
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues
) {
    ConstraintLayout {
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .verticalScroll(
                    state = rememberScrollState()
                )
                .fillMaxWidth()
                .padding(
                    top = 24.dp,
                    start = 24.dp,
                    end = 24.dp
                )
        ) {
            Title(
                text = "Meus contratos",
                pStart = 4.dp
            )

            Box(
                modifier = modifier
                    .requiredWidth(width = 360.dp)
                    .requiredHeight(height = 480.dp)
                    .clip(shape = RoundedCornerShape(12.dp))
            ) {
                Row(
                    modifier = Modifier
                        .requiredWidth(width = 360.dp)
                        .requiredHeight(height = 480.dp)
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
                                .requiredHeight(height = 480.dp)
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier
                                    .fillMaxSize()
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .requiredHeight(height = 72.dp)
                                        .padding(
                                            start = 16.dp,
                                            end = 4.dp,
                                            top = 12.dp,
                                            bottom = 12.dp
                                        )
                                ) {
                                    Row(
                                        horizontalArrangement = Arrangement.spacedBy(
                                            16.dp,
                                            Alignment.Start
                                        ),
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier
                                            .weight(weight = 1f)
                                    ) {
                                        Column(
                                            verticalArrangement = Arrangement.spacedBy(
                                                4.dp,
                                                Alignment.Top
                                            ),
                                            modifier = Modifier
                                                .fillMaxWidth()
                                        ) {
                                            Text(
                                                text = "Pitaya - 10 Kg",
                                                color = Color(0xff1c1b1f),
                                                lineHeight = 1.5.em,
                                                style = androidx.compose.ui.text.TextStyle(
                                                    fontSize = 20.sp,
                                                    fontWeight = FontWeight.Bold,
                                                    letterSpacing = 0.15.sp
                                                ),
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                            )
                                            Text(
                                                text = "Estância Parzianello",
                                                color = Color(0xff1c1b1f),
                                                textAlign = TextAlign.Center,
                                                lineHeight = 1.43.em,
                                                style = androidx.compose.ui.text.TextStyle(
                                                    fontSize = 14.sp,
                                                    letterSpacing = 0.25.sp
                                                )
                                            )
                                        }
                                    }
                                    IconButton(
                                        onClick = { }
                                    ) {
                                        Column(
                                            verticalArrangement = Arrangement.spacedBy(
                                                10.dp,
                                                Alignment.CenterVertically
                                            ),
                                            horizontalAlignment = Alignment.CenterHorizontally,
                                            modifier = Modifier
                                                .requiredSize(size = 48.dp)
                                        ) {
                                            Row(
                                                horizontalArrangement = Arrangement.spacedBy(
                                                    10.dp,
                                                    Alignment.CenterHorizontally
                                                ),
                                                verticalAlignment = Alignment.CenterVertically,
                                                modifier = Modifier
                                                    .clip(shape = RoundedCornerShape(100.dp))
                                            ) {
                                                Row(
                                                    horizontalArrangement = Arrangement.spacedBy(
                                                        10.dp,
                                                        Alignment.CenterHorizontally
                                                    ),
                                                    verticalAlignment = Alignment.CenterVertically,
                                                    modifier = Modifier
                                                        .padding(all = 8.dp)
                                                ) {
                                                    Icon(
                                                        painter = painterResource(id = R.drawable.icon_vert),
                                                        contentDescription = "Icons/more_vert_24px",
                                                        tint = Color(0xff79747e)
                                                    )
                                                }
                                            }
                                        }
                                    }
                                }
                                Box(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .weight(weight = 1f)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.mipmap.pitaya_foreground),
                                        contentDescription = "media",
                                        modifier = Modifier
                                            .fillMaxSize()
                                    )
                                }
                                Column(
                                    verticalArrangement = Arrangement.spacedBy(
                                        32.dp,
                                        Alignment.Top
                                    ),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(all = 16.dp)
                                ) {
                                    Column(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                    ) {
                                        Text(
                                            text = "Pitaya",
                                            color = Color(0xff1c1b1f),
                                            lineHeight = 1.5.em,
                                            style = androidx.compose.ui.text.TextStyle(
                                                fontSize = 20.sp,
                                                fontWeight = FontWeight.Medium,
                                                letterSpacing = 0.15.sp
                                            ),
                                            modifier = Modifier
                                                .requiredWidth(width = 328.dp)
                                        )
                                        Text(
                                            text = "R$ 500,00",
                                            color = Color(0xff49454f),
                                            lineHeight = 1.43.em,
                                            style = androidx.compose.ui.text.TextStyle(
                                                fontSize = 16.sp,
                                                letterSpacing = 0.25.sp
                                            ),
                                            modifier = Modifier
                                                .requiredWidth(width = 328.dp)
                                        )
                                    }
                                    Text(
                                        text = "Pitaya fresca, produzida sem agrotóxicos, pronta para preparo ou consumo.",
                                        color = Color(0xff49454f),
                                        lineHeight = 1.43.em,
                                        style = androidx.compose.ui.text.TextStyle(
                                            fontSize = 14.sp,
                                            letterSpacing = 0.25.sp
                                        ),
                                        modifier = Modifier
                                            .fillMaxWidth()
                                    )
                                    Row(
                                        horizontalArrangement = Arrangement.spacedBy(
                                            8.dp,
                                            Alignment.Start
                                        ),
                                        modifier = Modifier
                                            .fillMaxWidth()
                                    ) {
                                        TextButton(
                                            onClick = { },
                                            shape = RoundedCornerShape(100.dp),
                                            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                                            contentPadding = PaddingValues(
                                                start = 16.dp,
                                                top = 10.dp,
                                                end = 24.dp,
                                                bottom = 10.dp
                                            )
                                        ) {
                                            Row(
                                                horizontalArrangement = Arrangement.spacedBy(
                                                    8.dp,
                                                    Alignment.CenterHorizontally
                                                ),
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Row(
                                                    horizontalArrangement = Arrangement.spacedBy(
                                                        8.dp,
                                                        Alignment.CenterHorizontally
                                                    ),
                                                    verticalAlignment = Alignment.CenterVertically
                                                ) {
                                                    Image(
                                                        painter = painterResource(id = R.drawable.bike),
                                                        contentDescription = "icon",
                                                        colorFilter = ColorFilter.tint(
                                                            Color(
                                                                0xff264653
                                                            )
                                                        ),
                                                        modifier = Modifier
                                                            .requiredSize(size = 18.dp)
                                                    )
                                                    Text(
                                                        text = "Previsto para 10/02, quarta-feira",
                                                        color = Color(0xff264653),
                                                        textAlign = TextAlign.Center,
                                                        lineHeight = 1.43.em,
                                                        style = MaterialTheme.typography.labelLarge,
                                                        modifier = Modifier
                                                            .wrapContentHeight(align = Alignment.CenterVertically)
                                                    )
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

    }
}