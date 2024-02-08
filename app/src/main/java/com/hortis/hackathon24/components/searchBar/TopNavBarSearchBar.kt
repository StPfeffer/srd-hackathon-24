package com.hortis.hackathon24.components.searchBar

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun TopNavBarSearchBar(
    top : Dp = 16.dp,
    start: Dp = 24.dp,
    end: Dp = 24.dp
) {
    Box(
        Modifier
            .padding(top = top, start = start, end = end)
            .fillMaxWidth()
    ) {
        SearchBar()
    }
}