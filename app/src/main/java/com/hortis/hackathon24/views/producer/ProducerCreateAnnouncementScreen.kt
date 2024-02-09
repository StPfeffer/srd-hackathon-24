package com.hortis.hackathon24.views.producer

import android.graphics.Color.parseColor
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.hortis.hackathon24.R
import com.hortis.hackathon24.components.button.Upload
import com.hortis.hackathon24.components.datepicker.DatePicker
import com.hortis.hackathon24.components.searchbar.TextInput
import com.hortis.hackathon24.components.text.SubTitle
import com.hortis.hackathon24.components.text.Title

@Composable
fun ProducerCreateAnnouncementScreen(
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues
) {
    ConstraintLayout {
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .verticalScroll(
                    state = rememberScrollState()
                )
                .fillMaxWidth()
                .padding(
                    start = 24.dp,
                    end = 24.dp
                )
        ) {
            Title(
                text = "Criar anúncio de produto",
                pStart = 0.dp,
                pTop = 24.dp
            )

            SubTitle(
                text = "Categoria do produto",
                pStart = 0.dp,
                pTop = 16.dp
            )

            TextInput(
                placeholder = "Digite a categoria do produto",
                textColor = Color(parseColor(stringResource(R.string.azul_primario))),
                background = Color.White,
                outline = Color(parseColor(stringResource(R.string.azul_primario)))
            )

            SubTitle(
                text = "Nome do produto",
                pStart = 0.dp,
                pTop = 16.dp
            )

            TextInput(
                placeholder = "Digite o nome do produto",
                textColor = Color(parseColor(stringResource(R.string.azul_primario))),
                background = Color.White,
                outline = Color(parseColor(stringResource(R.string.azul_primario)))
            )

            SubTitle(
                text = "Fotos do produto",
                pStart = 0.dp,
                pTop = 16.dp
            )

            Upload()

            SubTitle(
                text = "Quantidade em quilogramas",
                pStart = 0.dp,
                pTop = 16.dp
            )

            TextInput(
                placeholder = "Digite a quantidade do produto em quilos",
                textColor = Color(parseColor(stringResource(R.string.azul_primario))),
                background = Color.White,
                outline = Color(parseColor(stringResource(R.string.azul_primario))),
                keyboard = KeyboardType.Decimal
            )

            SubTitle(
                text = "Disponibilidade",
                pStart = 0.dp,
                pTop = 16.dp
            )

            DatePicker()

            SubTitle(
                text = "Selos e Certificados",
                pStart = 0.dp,
                pTop = 16.dp
            )

            TextInput(
                placeholder = "Informe os selos e certificados do produto",
                textColor = Color(parseColor(stringResource(R.string.azul_primario))),
                background = Color.White,
                outline = Color(parseColor(stringResource(R.string.azul_primario)))
            )

            SubTitle(
                text = "Valor",
                pStart = 0.dp,
                pTop = 16.dp
            )

            TextInput(
                placeholder = "Digite o preço do produto",
                textColor = Color(parseColor(stringResource(R.string.azul_primario))),
                background = Color.White,
                outline = Color(parseColor(stringResource(R.string.azul_primario))),
                keyboard = KeyboardType.Decimal
            )

            SubTitle(text = "Forma de pagamento", pStart = 0.dp, pTop = 16.dp)

            TextInput(
                placeholder = "Digite o preço do produto",
                textColor = Color(parseColor(stringResource(R.string.azul_primario))),
                background = Color.White,
                outline = Color(parseColor(stringResource(R.string.azul_primario)))
            )

            Spacer(
                modifier = Modifier
                    .padding(top = 64.dp)
            )

            Upload(
                showIcon = false,
                text = "Criar Anúncio",
                weight = FontWeight.Bold,
                style = MaterialTheme.typography.bodyLarge
            )

            Spacer(
                modifier = Modifier
                    .padding(bottom = 64.dp)
            )
        }
    }
}