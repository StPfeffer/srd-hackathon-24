package com.hortis.hackathon24.components.searchbar

import android.graphics.Color.parseColor
import androidx.compose.foundation.border
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.hortis.hackathon24.R

@Composable
fun SearchBar(
    modifier: Modifier = Modifier
) {
    var text by remember { mutableStateOf(TextFieldValue("")) }

    TextField(
        value = text,
        onValueChange = { text = it },
        label = {
            Text(text = "Pesquisar")
        },
        placeholder = {
            Text(
                text = stringResource(R.string.placeholder_search),
                color = Color.White
            )
        },
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null,
                tint = Color.White
            )
        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color(parseColor(stringResource(R.string.azul_primario))),
            unfocusedContainerColor = Color(parseColor(stringResource(R.string.azul_primario))),
            disabledContainerColor = Color(parseColor(stringResource(R.string.azul_primario))),
        ),
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp)
            .border(
                width = 1.dp,
                color = Color.White,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(
                start = 24.dp,
                end = 24.dp
            )
    )
}
