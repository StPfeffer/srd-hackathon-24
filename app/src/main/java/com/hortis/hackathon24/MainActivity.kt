package com.hortis.hackathon24

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
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
fun mainView() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(
            topBar = {
//                        TopAppBar(
//                            colors = topAppBarColors(
//                                containerColor = MaterialTheme.colorScheme.primaryContainer,
//                                titleContentColor = MaterialTheme.colorScheme.primary,
//                            ),
//                            title = {
//                                Text("Top app bar")
//                            }
//                        )
            },
            bottomBar = {
                BottomAppBar(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    contentColor = MaterialTheme.colorScheme.primary,
                ) {
                    val navController = rememberNavController()
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Button(onClick = { navController.navigate("teste") }) {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_bluetooth_searching_24),
                                contentDescription = ""
                            )
                        }

                        Button(onClick = { navController.navigate("teste") }) {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_bluetooth_searching_24),
                                contentDescription = ""
                            )
                        }
                    }

                    NavHost(navController = navController, startDestination = "main") {
                        composable("main") {
                            Text(text = "main")
                        }

                        composable("teste") {
                            Text(text = "teste")
                        }
                    }

                }
            }
        ) { paddingValues ->
            Column(modifier = Modifier.padding(paddingValues)) {
                ConstraintLayout {
                    val (topImg, profile) = createRefs()

                    Box(
                        Modifier
                            .fillMaxWidth()
                            .height(245.dp)
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
                        Image(
                            painter = painterResource(id = R.drawable.baseline_bluetooth_searching_24),
                            contentDescription = "profile image",
                            modifier = Modifier
                                .width(100.dp)
                                .height(100.dp)
                                .clickable { }
                        )

                        Column(
                            Modifier
                                .height(100.dp)
                                .padding(start = 14.dp)
                                .weight(0.7f),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.Start
                        ) {
                            Text(
                                text = "Hello",
                                color = androidx.compose.ui.graphics.Color.White,
                                fontSize = 18.sp,
                            )
                            Text(
                                text = "",
                                color = androidx.compose.ui.graphics.Color.White,
                                fontSize = 22.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(top = 14.dp)
                            )
                        }
                    }

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