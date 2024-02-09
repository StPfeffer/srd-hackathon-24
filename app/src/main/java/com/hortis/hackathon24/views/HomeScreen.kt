package com.hortis.hackathon24.views

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import com.hortis.hackathon24.views.market.MarketHomeScreen
import com.hortis.hackathon24.views.producer.ProducerHomeScreen

@Composable
fun HomeScreen(
    paddingValues: PaddingValues,
    isProducer: Boolean
) {
    if (isProducer) {
        ProducerHomeScreen(paddingValues = paddingValues)
    } else {
        MarketHomeScreen(paddingValues = paddingValues)
    }
}