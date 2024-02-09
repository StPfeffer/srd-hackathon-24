package com.hortis.hackathon24

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.hortis.hackathon24.components.bottomnavbar.BottomNavBar
import com.hortis.hackathon24.components.button.FAB
import com.hortis.hackathon24.components.topnavbar.TopNavBar
import com.hortis.hackathon24.database.AppDatabase
import com.hortis.hackathon24.viewmodel.HomeViewModel
import com.hortis.hackathon24.views.Announcements
import com.hortis.hackathon24.views.HomeScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val db = Room.databaseBuilder(
//            applicationContext,
//            AppDatabase::class.java, "hortis"
//        ).fallbackToDestructiveMigration()
//            .allowMainThreadQueries()
//            .build()

        val viewModel by viewModels<HomeViewModel>()

//
//        val usuarioDAO: UsuarioDAO = db.usuarioDAO()
//
//        usuarioDAO.insertAll(Usuario(1, "nome1"), Usuario(2, "nome2"))
//
//        val anuncioDao : AnuncioDAO = db.anuncioDAO()
//
//        anuncioDao.insertAll(Anuncio(1, "Carambola", 5, "carambola_foreground", "01-02-2024", "01-05-2024",
//            43F, 1, null, null, null, null))

        setContent {
//            MainView(true, db, viewModel)
            MainView(true, viewModel)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainView(
    isProducer: Boolean = false,
//    db: AppDatabase,
    homeViewModel: HomeViewModel
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
            },
            floatingActionButton = {
                if (isProducer) {
                    FAB(text = "Criar anúncio")
                }
            }
        ) { paddingValues ->
            NavHost(
                navController = navController,
                startDestination = "home"
            ) {
                composable("home") {
//                    HomeScreen(paddingValues, isProducer, db)
                    HomeScreen(paddingValues, isProducer)
                }

                composable("announcements") {
                    Announcements(
                        Modifier
                            .padding(paddingValues)
                            .verticalScroll(state = rememberScrollState()),
                        listOfUsuarios
                    )
                }

//                composable("contracts") {
//                    ContractScreen(Modifier, paddingValues)
//                }
//
//                composable("orders") {
//                    OrderScreen(Modifier, paddingValues)
//                }
            }

        }
    }
}
