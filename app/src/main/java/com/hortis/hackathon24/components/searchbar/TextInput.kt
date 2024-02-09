package com.hortis.hackathon24.components.searchbar

import android.graphics.Color.parseColor
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@Composable
fun TextInput(
    modifier: Modifier = Modifier,
    placeholder: String,
    textColor: Color,
    background: Color,
    outline: Color,
    keyboard: KeyboardType = KeyboardType.Text
){
    var text by remember { mutableStateOf(TextFieldValue("")) }

    TextField(
        value = text,
        onValueChange = { text = it },
        placeholder = {
            Text(
                text = placeholder,
                color = textColor
            )
        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = background,
            unfocusedContainerColor = background,
            disabledContainerColor = background,
        ),
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp)
            .border(
                width = 1.dp,
                color = outline,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(
                start = 24.dp,
                end = 24.dp
            ),
        keyboardOptions = KeyboardOptions(keyboardType = keyboard)
    )
}