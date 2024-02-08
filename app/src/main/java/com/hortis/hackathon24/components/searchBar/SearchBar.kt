package com.hortis.hackathon24.components.searchBar

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.hortis.hackathon24.R

@Composable
fun SearchBar(
    modifier : Modifier = Modifier,
    top : Dp = 16.dp,
    start: Dp = 24.dp,
    end: Dp = 24.dp
) {
    Row(
        Modifier
            .padding(top = top, start = start, end = end)
            .fillMaxWidth()
    ) {
        TextField(
            value = "",
            onValueChange = {},
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                    tint = Color.White
                )
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(android.graphics.Color.parseColor("#033F63")),
                unfocusedContainerColor = Color(android.graphics.Color.parseColor("#033F63")),
                disabledContainerColor = Color(android.graphics.Color.parseColor("#033F63")),
            ),
            placeholder = {
                Text(
                    text = stringResource(R.string.placeholder_search),
                    color = Color.White
                )
            },
            modifier = modifier
                .fillMaxWidth()
                .heightIn(min = 56.dp)
                .border(
                    width = 1.dp,
                    color = Color.White,
                    shape = RoundedCornerShape(8.dp)
                )
        )
    }
}