package com.hortis.hackathon24.components.dropdown

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropDown(
    modifier: Modifier = Modifier,
    placeholder: String,
    textColor: Color,
    background: Color,
    outline: Color
) {
    var isExpanded by remember {
        mutableStateOf(false)
    }

    var option by remember {
        mutableStateOf("")
    }

    Box(modifier = Modifier.fillMaxWidth()) {
        ExposedDropdownMenuBox(
            expanded = isExpanded,
            onExpandedChange = { newValue ->
                isExpanded = newValue
            },
            modifier = modifier
                .fillMaxWidth()
                .heightIn(min = 56.dp)
                .border(
                    width = 1.dp,
                    color = outline,
                    shape = RoundedCornerShape(8.dp)
                )
                .background(background)
        ) {
            TextField(
                value = option,
                onValueChange = {},
                readOnly = true,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)
                },
                placeholder = {
                    Text(text = placeholder)
                },
                colors = ExposedDropdownMenuDefaults.textFieldColors(),
                modifier = Modifier.menuAnchor()
            )

            ExposedDropdownMenu(
                expanded = isExpanded,
                onDismissRequest = {
                    isExpanded = false
                }
            ) {
                DropdownMenuItem(
                    text = {
                        Text(
                            text = "Categoria 1",
                            color = textColor
                        )
                    },
                    onClick = {
                        option = "Categoria 1"
                        isExpanded = false
                    }
                )
                DropdownMenuItem(
                    text = {
                        Text(
                            text = "Categoria 2",
                            color = textColor
                        )
                    },
                    onClick = {
                        option = "Categoria 2"
                        isExpanded = false
                    }
                )
                DropdownMenuItem(
                    text = {
                        Text(
                            text = "Categoria 3",
                            color = textColor
                        )
                    },
                    onClick = {
                        option = "Categoria 3"
                        isExpanded = false
                    }
                )
            }
        }
    }
}
