package com.hortis.hackathon24.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.constraintlayout.compose.ConstraintLayout
import com.hortis.hackathon24.entity.Usuario

@Composable
fun Announcements(
    modifier: Modifier,
    listOfUsuarios: List<Usuario>
) {
    ConstraintLayout {
        Column(
            modifier = modifier
        ) {
            listOfUsuarios.forEach { usuario: Usuario ->
                Text(text = usuario.nome)
            }
        }
    }
}
