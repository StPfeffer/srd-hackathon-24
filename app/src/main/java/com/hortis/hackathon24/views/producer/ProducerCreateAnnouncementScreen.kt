package com.hortis.hackathon24.views.producer

import android.content.Context
import android.graphics.Color.parseColor
import android.widget.Toast
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.room.Room
import com.hortis.hackathon24.R
import com.hortis.hackathon24.components.button.Upload
import com.hortis.hackathon24.components.datepicker.DatePicker
import com.hortis.hackathon24.components.searchbar.TextInput
import com.hortis.hackathon24.components.text.SubTitle
import com.hortis.hackathon24.components.text.Title
import com.hortis.hackathon24.dao.AnuncioDAO
import com.hortis.hackathon24.database.AppDatabase
import com.hortis.hackathon24.dto.FormularioDTO
import com.hortis.hackathon24.viewmodel.HomeViewModel

@Composable
fun ProducerCreateAnnouncementScreen(
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues,
    context: Context,
    navController: NavController
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
            var txtCategoria by rememberSaveable { mutableStateOf("") }
            var txtProduto by rememberSaveable { mutableStateOf("") }
            var txtQuilos by rememberSaveable { mutableStateOf("") }
            var floatPreco by rememberSaveable { mutableStateOf("") }
            var txtFormaPagamento by rememberSaveable { mutableStateOf("") }
//            var txtDisponibilidadeInicial by rememberSaveable { mutableStateOf("") }
//            var txtDisponibilidadeFinal by rememberSaveable { mutableStateOf("") }

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

            TextField(
                value = txtCategoria,
                onValueChange = { txtCategoria = it },
                placeholder = {
                    Text(
                        text = "Digite a categoria do produto",
                        color = Color(parseColor(stringResource(R.string.azul_primario)))
                    )
                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    disabledContainerColor = Color.White,
                ),
                modifier = modifier
                    .fillMaxWidth()
                    .heightIn(min = 56.dp)
                    .border(
                        width = 1.dp,
                        color = Color(parseColor(stringResource(R.string.azul_primario))),
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(
                        start = 24.dp,
                        end = 24.dp
                    ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )

            SubTitle(
                text = "Nome do produto",
                pStart = 0.dp,
                pTop = 16.dp
            )

            TextField(
                value = txtProduto,
                onValueChange = { txtProduto = it },
                placeholder = {
                    Text(
                        text = "Digite o nome do produto",
                        color = Color(parseColor(stringResource(R.string.azul_primario)))
                    )
                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    disabledContainerColor = Color.White,
                ),
                modifier = modifier
                    .fillMaxWidth()
                    .heightIn(min = 56.dp)
                    .border(
                        width = 1.dp,
                        color = Color(parseColor(stringResource(R.string.azul_primario))),
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(
                        start = 24.dp,
                        end = 24.dp
                    ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
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

            TextField(
                value = txtQuilos,
                onValueChange = { txtQuilos = it },
                placeholder = {
                    Text(
                        text = "Digite a quantidade do produto em quilos",
                        color = Color(parseColor(stringResource(R.string.azul_primario)))
                    )
                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    disabledContainerColor = Color.White,
                ),
                modifier = modifier
                    .fillMaxWidth()
                    .heightIn(min = 56.dp)
                    .border(
                        width = 1.dp,
                        color = Color(parseColor(stringResource(R.string.azul_primario))),
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(
                        start = 24.dp,
                        end = 24.dp
                    ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
            )

            SubTitle(
                text = "Disponibilidade Inicial",
                pStart = 0.dp,
                pTop = 16.dp
            )

            DatePicker()

            SubTitle(
                text = "Disponibilidade Final",
                pStart = 0.dp,
                pTop = 16.dp
            )

            DatePicker()

            SubTitle(
                text = "Valor",
                pStart = 0.dp,
                pTop = 16.dp
            )

            TextField(
                value = floatPreco,
                onValueChange = { floatPreco = it },
                placeholder = {
                    Text(
                        text = "Digite o preço do produto",
                        color = Color(parseColor(stringResource(R.string.azul_primario)))
                    )
                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    disabledContainerColor = Color.White,
                ),
                modifier = modifier
                    .fillMaxWidth()
                    .heightIn(min = 56.dp)
                    .border(
                        width = 1.dp,
                        color = Color(parseColor(stringResource(R.string.azul_primario))),
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(
                        start = 24.dp,
                        end = 24.dp
                    ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
            )

            SubTitle(text = "Forma de pagamento", pStart = 0.dp, pTop = 16.dp)

            TextField(
                value = txtFormaPagamento,
                onValueChange = { txtFormaPagamento = it },
                placeholder = {
                    Text(
                        text = "Digite a forma de pagamento",
                        color = Color(parseColor(stringResource(R.string.azul_primario)))
                    )
                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    disabledContainerColor = Color.White,
                ),
                modifier = modifier
                    .fillMaxWidth()
                    .heightIn(min = 56.dp)
                    .border(
                        width = 1.dp,
                        color = Color(parseColor(stringResource(R.string.azul_primario))),
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(
                        start = 24.dp,
                        end = 24.dp
                    ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )

            Spacer(
                modifier = Modifier
                    .padding(top = 64.dp)
            )

            Button(
                onClick = {
                    val db = Room.databaseBuilder(
                        context,
                        AppDatabase::class.java, "hortis"
                    ).fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build()

                    val anuncioDao: AnuncioDAO = db.anuncioDAO()

                    val anuncioDTO = FormularioDTO(
                        txtCategoria,
                        txtProduto,
                        txtQuilos,
                        floatPreco,
                        txtFormaPagamento,
                        "pitaya_foreground"
                    )

                    anuncioDao.insertAll(anuncioDTO.buildAnuncio())

                    Toast.makeText(context, "Anuncio cadastrado", Toast.LENGTH_SHORT).show()
                    navController.navigate("announcements")
                },
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xff033f63)),
                contentPadding = PaddingValues(
                    start = 16.dp,
                    top = 10.dp,
                    end = 24.dp,
                    bottom = 10.dp
                ),
                modifier = modifier
                    .requiredWidth(width = 364.dp)
                    .height(56.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(
                        8.dp,
                        Alignment.CenterHorizontally
                    ),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .requiredWidth(width = 364.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(
                            8.dp,
                            Alignment.CenterHorizontally
                        ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        if (false) {
                            Image(
                                painter = painterResource(id = R.drawable.upload),
                                contentDescription = "icon",
                                colorFilter = ColorFilter.tint(Color(0xfff2f2f2)),
                                modifier = Modifier
                                    .requiredSize(size = 18.dp)
                            )
                        }
                        Text(
                            text = "Criar Anúncio",
                            color = Color(0xfff2f2f2),
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            lineHeight = 1.43.em,
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier
                                .wrapContentHeight(align = Alignment.CenterVertically)
                        )
                    }
                }
            }
        }


//    ConstraintLayout {
//        var txtCategoria by rememberSaveable { mutableStateOf("") }
//        var txtProduto by rememberSaveable { mutableStateOf("") }
//        var intQuilos by rememberSaveable { mutableIntStateOf(0) }
//        var floatPreco by rememberSaveable { mutableFloatStateOf(0F) }
//        var txtFormaPagamento by rememberSaveable { mutableStateOf("") }
////        var txtDisponibilidadeInicial by rememberSaveable { mutableStateOf("") }
////        var txtDisponibilidadeFinal by rememberSaveable { mutableStateOf("") }
//
//
//        Column(
//            modifier = Modifier
//                .padding(paddingValues)
//                .verticalScroll(
//                    state = rememberScrollState()
//                )
//                .fillMaxWidth()
//                .padding(
//                    start = 24.dp,
//                    end = 24.dp
//                )
//        ) {
//            Title(
//                text = "Criar anúncio de produto",
//                pStart = 0.dp,
//                pTop = 24.dp
//            )
//
//            SubTitle(
//                text = "Categoria do produto",
//                pStart = 0.dp,
//                pTop = 16.dp
//            )
//
//            TextInput(
//                placeholder = "Digite a categoria do produto",
//                textColor = Color(parseColor(stringResource(R.string.azul_primario))),
//                background = Color.White,
//                outline = Color(parseColor(stringResource(R.string.azul_primario)))
//            )
//
//            SubTitle(
//                text = "Nome do produto",
//                pStart = 0.dp,
//                pTop = 16.dp
//            )
//
//            TextInput(
//                placeholder = "Digite o nome do produto",
//                textColor = Color(parseColor(stringResource(R.string.azul_primario))),
//                background = Color.White,
//                outline = Color(parseColor(stringResource(R.string.azul_primario)))
//            )
//
//            SubTitle(
//                text = "Fotos do produto",
//                pStart = 0.dp,
//                pTop = 16.dp
//            )
//
//            Upload()
//
//            SubTitle(
//                text = "Quantidade em quilogramas",
//                pStart = 0.dp,
//                pTop = 16.dp
//            )
//
//            TextInput(
//                placeholder = "Digite a quantidade do produto em quilos",
//                textColor = Color(parseColor(stringResource(R.string.azul_primario))),
//                background = Color.White,
//                outline = Color(parseColor(stringResource(R.string.azul_primario))),
//                keyboard = KeyboardType.Decimal
//            )
//
//            SubTitle(
//                text = "Disponibilidade",
//                pStart = 0.dp,
//                pTop = 16.dp
//            )
//
//            DatePicker()
//
//            DatePicker()
//
////            SubTitle(
////                text = "Selos e Certificados",
////                pStart = 0.dp,
////                pTop = 16.dp
////            )
////
////            TextInput(
////                placeholder = "Informe os selos e certificados do produto",
////                textColor = Color(parseColor(stringResource(R.string.azul_primario))),
////                background = Color.White,
////                outline = Color(parseColor(stringResource(R.string.azul_primario)))
////            )
//
//            SubTitle(
//                text = "Valor",
//                pStart = 0.dp,
//                pTop = 16.dp
//            )
//
//            TextInput(
//                placeholder = "Digite o preço do produto",
//                textColor = Color(parseColor(stringResource(R.string.azul_primario))),
//                background = Color.White,
//                outline = Color(parseColor(stringResource(R.string.azul_primario))),
//                keyboard = KeyboardType.Decimal
//            )
//
//            SubTitle(text = "Forma de pagamento", pStart = 0.dp, pTop = 16.dp)
//
//            TextInput(
//                placeholder = "Digite a forma de pagamento",
//                textColor = Color(parseColor(stringResource(R.string.azul_primario))),
//                background = Color.White,
//                outline = Color(parseColor(stringResource(R.string.azul_primario)))
//            )
//
//            Spacer(
//                modifier = Modifier
//                    .padding(top = 64.dp)
//            )
//
////            Upload(
////                showIcon = false,
////                text = "Criar Anúncio",
////                weight = FontWeight.Bold,
////                style = MaterialTheme.typography.bodyLarge
////            )
//
//            Button(
//                onClick = {
//                    val db = Room.databaseBuilder(
//                        context,
//                        AppDatabase::class.java, "hortis"
//                    ).fallbackToDestructiveMigration()
//                        .allowMainThreadQueries()
//                        .build()
//
//                    val anuncioDao: AnuncioDAO = db.anuncioDAO()
//
//                    val anuncioDTO = FormularioDTO(txtCategoria,
//                        txtProduto,
//                        intQuilos,
//                        floatPreco,
//                        txtFormaPagamento,
//                        "pitaya_foreground")
//
//                    anuncioDao.insertAll(anuncioDTO.buildAnuncio())
//
//                    Toast.makeText(context, "Anuncio cadastrado", Toast.LENGTH_SHORT).show()
//
//                },
//                shape = RoundedCornerShape(12.dp),
//                colors = ButtonDefaults.buttonColors(containerColor = Color(0xff033f63)),
//                contentPadding = PaddingValues(
//                    start = 16.dp,
//                    top = 10.dp,
//                    end = 24.dp,
//                    bottom = 10.dp
//                ),
//                modifier = modifier
//                    .requiredWidth(width = 364.dp)
//                    .height(56.dp)
//            ) {
//                Row(
//                    horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
//                    verticalAlignment = Alignment.CenterVertically,
//                    modifier = Modifier
//                        .requiredWidth(width = 364.dp)
//                ) {
//                    Row(
//                        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
//                        verticalAlignment = Alignment.CenterVertically
//                    ) {
//                        if (false) {
//                            Image(
//                                painter = painterResource(id = R.drawable.upload),
//                                contentDescription = "icon",
//                                colorFilter = ColorFilter.tint(Color(0xfff2f2f2)),
//                                modifier = Modifier
//                                    .requiredSize(size = 18.dp)
//                            )
//                        }
//                        Text(
//                            text = "Criar Anúncio",
//                            color = Color(0xfff2f2f2),
//                            fontWeight = FontWeight.Bold,
//                            textAlign = TextAlign.Center,
//                            lineHeight = 1.43.em,
//                            style = MaterialTheme.typography.bodyLarge,
//                            modifier = Modifier
//                                .wrapContentHeight(align = Alignment.CenterVertically)
//                        )
//                    }
//                }
//            }
//
//            Spacer(
//                modifier = Modifier
//                    .padding(bottom = 64.dp)
//            )
//        }
//    }
    }
}