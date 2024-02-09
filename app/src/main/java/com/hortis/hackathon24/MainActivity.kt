package com.hortis.hackathon24

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.hortis.hackathon24.components.announcement.AnnouncementCard
import com.hortis.hackathon24.components.bottomNavBar.BottomNavBar
import com.hortis.hackathon24.components.card.HorizontalCard
import com.hortis.hackathon24.components.topNavBar.TopNavBar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MainView()
        }
    }
}

@Preview
@Composable
fun MainView() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(
            bottomBar = {
                BottomNavBar()
            }
        ) { paddingValues ->
            ConstraintLayout {
                val (topImg, profile) = createRefs()

                Column(
                    modifier = Modifier
                        .padding(paddingValues)
                        .verticalScroll(state = rememberScrollState())
                ) {
                    TopNavBar()

                    AnnouncementCard()

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 24.dp, start = 24.dp, end = 24.dp)
                            .shadow(3.dp, shape = RoundedCornerShape(20.dp))
                            .background(
                                color = Color.White,
                                shape = RoundedCornerShape(20.dp)
                            )
                    )
                    {
                        Column(
                            modifier = Modifier
                                .padding(
                                    top = 12.dp,
                                    bottom = 12.dp,
                                    end = 12.dp,
                                    start = 8.dp
                                )
                                .height(90.dp)
                                .width(90.dp)
                                .background(
                                    color = Color(android.graphics.Color.parseColor("#b6c2fe")),
                                    shape = RoundedCornerShape(20.dp)
                                ),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.baseline_bluetooth_searching_24),
                                contentDescription = "",
                                modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
                            )
                            Text(
                                text = "Video Call",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                fontStyle = FontStyle.Italic,
                                color = Color(android.graphics.Color.parseColor("#5e3bee"))
                            )
                        }

                        Column(
                            modifier = Modifier
                                .padding(
                                    top = 12.dp,
                                    bottom = 12.dp,
                                    end = 12.dp,
                                    start = 8.dp
                                )
                                .height(90.dp)
                                .width(90.dp)
                                .background(
                                    color = Color(android.graphics.Color.parseColor("#b6c2fe")),
                                    shape = RoundedCornerShape(20.dp)
                                ),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.baseline_bluetooth_searching_24),
                                contentDescription = "",
                                modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
                            )
                            Text(
                                text = "Notification",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                fontStyle = FontStyle.Italic,
                                color = Color(android.graphics.Color.parseColor("#5e3bee"))
                            )
                        }

                        Column(
                            modifier = Modifier
                                .padding(
                                    top = 12.dp,
                                    bottom = 12.dp,
                                    end = 12.dp,
                                    start = 8.dp
                                )
                                .height(90.dp)
                                .width(90.dp)
                                .background(
                                    color = Color(android.graphics.Color.parseColor("#b6c2fe")),
                                    shape = RoundedCornerShape(20.dp)
                                ),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.baseline_bluetooth_searching_24),
                                contentDescription = "",
                                modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
                            )
                            Text(
                                text = "Voice Call",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                fontStyle = FontStyle.Italic,
                                color = Color(android.graphics.Color.parseColor("#5e3bee"))
                            )
                        }

                    }

                    HorizontalCard()
                }
            }
        }
    }
}