package com.hortis.hackathon24

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.hortis.hackathon24.components.bottomnavbar.BottomNavBar
import com.hortis.hackathon24.components.button.FAB
import com.hortis.hackathon24.components.dialog.AlertDialogExample
import com.hortis.hackathon24.components.topnavbar.TopNavBar
import com.hortis.hackathon24.dao.AnuncioDAO
import com.hortis.hackathon24.database.AppDatabase
import com.hortis.hackathon24.entity.Anuncio
import com.hortis.hackathon24.viewmodel.HomeViewModel
import com.hortis.hackathon24.views.Announcements
import com.hortis.hackathon24.views.HomeScreen
import com.hortis.hackathon24.views.producer.ProducerContracts
import com.hortis.hackathon24.views.producer.ProducerCreateAnnouncementScreen
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "hortis"
        ).fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()

        val viewModel by viewModels<HomeViewModel>()

        val anuncioDao: AnuncioDAO = db.anuncioDAO()

//        var formularioDTO: FormularioDTO = FormularioDTO(
//            "Frutas",
//            "Mirtilo",
//            1,
//            2.99F,
//            "PIX",
//            ""
//        )
//
//        val anuncio = formularioDTO.buildAnuncio()
//
//        anuncioDao.insertAll(anuncio)

        anuncioDao.deleteAll()

        anuncioDao.insertAll(
            Anuncio(
                null,
                "Carambola",
                5,
                "carambola_foreground",
                "01-02-2024",
                "01-05-2024",
                43F,
                "Fruta",
                "PIX",
                null,
                1
            ),
            Anuncio(
                null,
                "Pitaya",
                5,
                "pitaya_foreground",
                "01-02-2024",
                "01-05-2024",
                84F,
                "Fruta",
                "PIX",
                null,
                2
            ),
            Anuncio(
                null,
                "Jiló",
                5,
                "jilo_foreground",
                "01-02-2024",
                "01-05-2024",
                31F,
                "Hortaliça",
                "PIX",
                null,
                1
            ),
            Anuncio(
                null,
                "Mirtilo",
                5,
                "mirtilo_foreground",
                "01-02-2024",
                "01-05-2024",
                43F,
                "Fruta",
                "PIX",
                null,
                2
            ),
            Anuncio(
                null,
                "Maracujá",
                5,
                "maracuja_foreground",
                "01-02-2024",
                "01-05-2024",
                12F,
                "Fruta",
                "PIX",
                null,
                1
            ),
            Anuncio(
                null,
                "Cenoura Branca",
                5,
                "cenoura_foreground",
                "01-02-2024",
                "01-05-2024",
                43F,
                "Tuberculo",
                "PIX",
                null,
                2
            ),
            Anuncio(
                null,
                "Batata Roxa",
                5,
                "batata_foreground",
                "01-02-2024",
                "01-05-2024",
                43F,
                "Tuberculo",
                "PIX",
                null,
                1
            )
        )

        setContent {
//            MainView(true, db, viewModel)
            MainView(true, db, viewModel, application)
        }
    }
}

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun MainView(
    isProducer: Boolean = false,
    db: AppDatabase,
    homeViewModel: HomeViewModel,
    context: Context
) {
    val listOfUsuarios by homeViewModel.listOfUsuario.collectAsState()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        val navController = rememberNavController()

        Scaffold(
            topBar = {
                TopNavBar(isProducer = isProducer)
            },
            bottomBar = {
                BottomNavBar(navController)
            }
//            ,
//            floatingActionButton = {
//                if (isProducer) {
//                    FAB(
//                        text = "Criar anúncio",
//                        navController = navController
//                    )
//                }
//            }
        ) { paddingValues ->
            NavHost(
                navController = navController,
                startDestination = "home"
            ) {
                composable("home") {
                    HomeScreen(paddingValues, isProducer, db, navController)
                }

                composable("announcements") {
                    Announcements(
                        Modifier
                            .padding(paddingValues)
                            .verticalScroll(state = rememberScrollState()),
                        paddingValues,
                        db,
                        navController
                    )
                }

                composable("create_announcement") {
                    ProducerCreateAnnouncementScreen(
                        paddingValues = paddingValues
                    )
                }

                composable("contracts") {
                    ProducerContracts(
                        paddingValues = paddingValues
                    )
                }
            }

        }
    }
}
