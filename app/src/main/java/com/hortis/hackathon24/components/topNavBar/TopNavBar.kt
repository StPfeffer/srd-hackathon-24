package com.hortis.hackathon24.components.topNavBar

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.hortis.hackathon24.R
import com.hortis.hackathon24.components.logo.Logo
import com.hortis.hackathon24.components.logo.LogoWithMenu
import com.hortis.hackathon24.components.searchBar.SearchBar

@Composable
fun TopNavBar(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(185.dp)
            .clip(
                shape = RoundedCornerShape(
                    topStart = 0.dp,
                    topEnd = 0.dp,
                    bottomStart = 12.dp,
                    bottomEnd = 12.dp
                )
            )
            .background(color = Color(0xff033f63))
    ) {
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(
                    x = 16.dp,
                    y = 68.dp
                )
                .requiredWidth(width = 161.dp)
                .requiredHeight(height = 46.dp)
                .fillMaxWidth()
                .padding(
                    start = 24.dp,
                    end = 24.dp,
                    bottom = 16.dp
                )
        ) {
            Logo()
        }

        Icon(
            painter = painterResource(id = R.drawable.menu_top),
            contentDescription = "Icons/more_24px",
            tint = Color(0xffffbf1f),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(
                    x = 352.dp,
                    y = 84.dp
                )
                .padding(bottom = 16.dp)
        )

        var text by remember { mutableStateOf(TextFieldValue("")) }

        TextField(
            value = text,
            onValueChange = { text = it },
            label = {
                Text(
                    text = "Pesquisar",
                    color = Color.White
                )
            },
            placeholder = {
                Text(
                    text = stringResource(R.string.placeholder_search),
                    color = Color.LightGray
                )
            },
            textStyle = TextStyle(color = Color.White),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(top = 96.dp, bottom = 16.dp, start = 16.dp, end = 16.dp)
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = Color.White,
                    shape = RoundedCornerShape(8.dp)
                ),
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
        )
    }
}
