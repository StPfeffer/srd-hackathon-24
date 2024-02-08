package com.hortis.hackathon24

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import com.hortis.hackathon24.components.bottomNavBar.BottomNavBar
import com.hortis.hackathon24.components.searchBar.SearchBar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
//            Hackathon24Theme {
            // A surface container using the 'background' color from the theme
//            }
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
            Column(modifier = Modifier.padding(paddingValues)) {
                ConstraintLayout {
                    val (topImg, profile) = createRefs()

                    Box(
                        Modifier
                            .fillMaxWidth()
                            .height(185.dp)
                            .constrainAs(topImg) {
                                top.linkTo(parent.top)
                                start.linkTo(parent.start)
                            }
                            .background(
                                color = Color(android.graphics.Color.parseColor("#033F63")),
                                shape = RoundedCornerShape(
                                    bottomEnd = 10.dp,
                                    bottomStart = 10.dp
                                )
                            )
                    )

                    Row(
                        Modifier
                            .padding(top = 48.dp, start = 24.dp, end = 24.dp)
                            .fillMaxWidth()
                    ) {
                        Column(
                            Modifier
                                .height(100.dp)
                                .padding(start = 14.dp)
                                .weight(0.7f),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.Start
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.logo),
                                contentDescription = "hortis logo",
                                modifier = Modifier.size(100.dp),
                                alignment = Alignment.CenterStart
                            )
                        }
                        IconButton(onClick = { Log.d("Click", "IconExample") }) {
                            Icon(
                                imageVector = Icons.Outlined.Menu,
                                contentDescription = "Home Icon"
                            )
                        }
                    }

                    SearchBar()

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 24.dp, start = 24.dp, end = 24.dp)
                            .shadow(3.dp, shape = RoundedCornerShape(20.dp))
                            .background(
                                color = androidx.compose.ui.graphics.Color.White,
                                shape = RoundedCornerShape(20.dp)
                            )
                            .constrainAs(profile) {
                                top.linkTo(topImg.bottom)
                                bottom.linkTo(topImg.bottom)
//                                start.linkTo(parent.start)
//                                end.linkTo(parent.end)
                            }
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
                }
            }
        }
    }
}