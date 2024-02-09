package com.hortis.hackathon24.components.announcement

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.hortis.hackathon24.entity.Anuncio
import com.hortis.hackathon24.entity.Usuario
import java.util.Locale

@Composable
fun HorizontalAnnouncementCard(
    modifier: Modifier = Modifier,
    anuncio: Anuncio,
    usuario: Usuario,
    navController: NavController
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .requiredHeight(height = 80.dp)
            .clip(shape = RoundedCornerShape(12.dp))
            .clickable {
                navController.navigate("contracts")
            },
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .requiredHeight(height = 80.dp)
                .padding(
                    start = 24.dp,
                    end = 24.dp
                ),
            horizontalArrangement = Arrangement.Center
        ) {
            Surface(
                shape = RoundedCornerShape(12.dp),
                border = BorderStroke(1.dp, Color(0xffcac4d0)),
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(12.dp))
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
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
                            Box(
                                modifier = Modifier
                                    .requiredSize(size = 40.dp)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .clip(shape = CircleShape)
                                        .background(color = Color(0xff033f63))
                                )
                                Text(
                                    text = usuario.nome[0].toString().uppercase(Locale.ROOT),
                                    color = Color(0xfff2f2f2),
                                    textAlign = TextAlign.Center,
                                    lineHeight = 1.5.em,
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Medium,
                                        letterSpacing = 0.15.sp
                                    ),
                                    modifier = Modifier
                                        .align(alignment = Alignment.Center)
                                        .offset(
                                            x = 0.dp,
                                            y = 0.dp
                                        )
                                        .requiredSize(size = 40.dp)
                                        .wrapContentHeight(align = Alignment.CenterVertically)
                                )
                            }
                            Column(
                                verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top),
                                modifier = Modifier
                                    .fillMaxWidth()
                            ) {
                                Text(
                                    text = anuncio.produto,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis,
                                    color = Color(0xff151515),
                                    lineHeight = 1.5.em,
                                    style = TextStyle(
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Medium,
                                        letterSpacing = 0.15.sp
                                    ),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                )

                                Row {
                                    Text(
                                        text = anuncio.quantidade.toString() + " Kg",
                                        color = Color(0xff151515),
                                        textAlign = TextAlign.Left,
                                        lineHeight = 1.43.em,
                                        style = TextStyle(
                                            fontSize = 14.sp,
                                            letterSpacing = 0.25.sp
                                        ),
                                        modifier = Modifier
                                            .requiredWidth(width = 37.dp)
                                    )

                                    Text(
                                        text = "R$ " + anuncio.preco.toString(),
                                        color = Color(0xff151515),
                                        textAlign = TextAlign.Right,
                                        lineHeight = 1.43.em,
                                        style = TextStyle(
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 18.sp,
                                            letterSpacing = 0.25.sp
                                        ),
                                        modifier = Modifier
                                            .fillMaxWidth()
                                    )
                                }
                            }
                        }
                        Box(
                            modifier = Modifier
                                .fillMaxHeight()
                                .requiredWidth(width = 80.dp)
                        ) {
                            val context = LocalContext.current
                            val drawableId = remember(anuncio.imagem) {
                                context.resources.getIdentifier(
                                    anuncio.imagem,
                                    "mipmap",
                                    context.packageName
                                )
                            }

                            Image(
                                painter = painterResource(id = drawableId),
                                contentDescription = "media",
                                modifier = Modifier
                                    .fillMaxSize()
                                    .scale(1.1f)
                            )
                        }
                    }
                }
            }
        }
    }
}
