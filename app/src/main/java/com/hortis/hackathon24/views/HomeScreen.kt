package com.hortis.hackathon24.views

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.hortis.hackathon24.database.AppDatabase
import com.hortis.hackathon24.views.market.MarketHomeScreen
import com.hortis.hackathon24.views.producer.ProducerHomeScreen

@Composable
fun HomeScreen(
    paddingValues: PaddingValues,
    isProducer: Boolean,
    db: AppDatabase,
    navController: NavController
) {
    if (isProducer) {
        ProducerHomeScreen(paddingValues = paddingValues, db = db, navController = navController)
    } else {
        MarketHomeScreen(paddingValues = paddingValues)
    }
}