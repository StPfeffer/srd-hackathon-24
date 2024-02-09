package com.hortis.hackathon24.views.producer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.hortis.hackathon24.components.announcement.HorizontalAnnouncementCard
import com.hortis.hackathon24.components.notfound.NotFound
import com.hortis.hackathon24.components.seemore.SeeMore
import com.hortis.hackathon24.components.text.Title
import com.hortis.hackathon24.dao.AnuncioDAO
import com.hortis.hackathon24.dao.UsuarioDAO
import com.hortis.hackathon24.database.AppDatabase

@Composable
fun ProducerHomeScreen(
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues,
    db: AppDatabase,
    navController: NavController
) {
    ConstraintLayout {
        val anuncioDAO: AnuncioDAO = db.anuncioDAO()
        val usuarioDAO: UsuarioDAO = db.usuarioDAO()

        val anuncios = anuncioDAO.getAll()

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .verticalScroll(
                    state = rememberScrollState()
                )
                .fillMaxWidth()
        ) {
            Title(
                text = "Meus compromissos",
                pTop = 24.dp
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (anuncios.isEmpty()) {
                    NotFound(text = "Não foram encontrados compromissos.")
                } else {
                    var i = 0
                    for (anuncio in anuncios) {
                        if (anuncio.comprador != null) {
                            val usuario = usuarioDAO.findById(anuncio.usuario)

                            HorizontalAnnouncementCard(
                                anuncio = anuncio,
                                usuario = usuario,
                                navController = navController
                            )

                            Spacer(
                                modifier.padding(top = 8.dp)
                            )

                            i++

                            if (i == 3) {
                                SeeMore(
                                    text = "Ver mais compromissos",
                                    route = "announcements",
                                    navController = navController
                                )

                                break
                            }
                        }
                    }

                    if (i == 0) {
                        NotFound(text = "Não foram encontrados compromissos.")
                    }
                }
            }

            Title(
                text = "Anúncios abertos",
                pTop = 24.dp
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 80.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (anuncios.isEmpty()) {
                    NotFound(text = "Não foram encontrados anúncios.")
                } else {
                    var i = 0
                    for (anuncio in anuncios) {
                        if (anuncio.comprador == null) {
                            val usuario = usuarioDAO.findById(anuncio.usuario)

                            HorizontalAnnouncementCard(
                                anuncio = anuncio,
                                usuario = usuario,
                                navController = navController
                            )

                            Spacer(
                                modifier.padding(top = 8.dp)
                            )

                            i++

                            if (i == 3) {
                                SeeMore(
                                    text = "Ver mais anúncios",
                                    route = "announcements",
                                    navController = navController
                                )

                                break
                            }
                        }
                    }

                    if (i == 0) {
                        NotFound(text = "Não foram encontrados anúncios.")
                    }
                }
            }
        }
    }
}