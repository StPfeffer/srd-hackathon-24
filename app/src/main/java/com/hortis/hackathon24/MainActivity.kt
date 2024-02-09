package com.hortis.hackathon24

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hortis.hackathon24.components.bottomNavBar.BottomNavBar
import com.hortis.hackathon24.components.topNavBar.TopNavBar
import com.hortis.hackathon24.views.AnnouncementScreen
import com.hortis.hackathon24.views.HomeScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MainView(true)
        }
    }
}

@Composable
fun MainView(
    isProducer: Boolean = false
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        val navController = rememberNavController()

        Scaffold(
            topBar = {
                TopNavBar(isProducer = isProducer)
            },
            bottomBar = {
                BottomNavBar(navController)
            }
        ) { paddingValues ->
            NavHost(
                navController = navController,
                startDestination = "home"
            ) {
                composable("home") {
                    HomeScreen(paddingValues, isProducer)
                }

                composable("announcements") {
                    AnnouncementScreen(Modifier, paddingValues)
                }

//                composable("contracts") {
//                    ContractScreen(Modifier, paddingValues)
//                }
//
//                composable("orders") {
//                    OrderScreen(Modifier, paddingValues)
//                }
            }

        }
    }
}
