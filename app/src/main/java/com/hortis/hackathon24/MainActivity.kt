package com.hortis.hackathon24

import android.annotation.SuppressLint
import android.content.Context
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
import com.hortis.hackathon24.dao.AnuncioDAO
import com.hortis.hackathon24.database.AppDatabase
import com.hortis.hackathon24.entity.Anuncio
import com.hortis.hackathon24.viewmodel.HomeViewModel
import com.hortis.hackathon24.views.Announcements
import com.hortis.hackathon24.views.HomeScreen
import com.hortis.hackathon24.views.producer.ProducerCreateAnnouncementScreen

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

        val anuncioDao : AnuncioDAO = db.anuncioDAO()

        anuncioDao.insertAll(
            Anuncio(null, "Carambola", 5, "pitaya_foreground", "01-02-2024", "01-05-2024", 43F, 1, null, null, null, null, 1),
            Anuncio(null, "Pitaya", 5, "pitaya_foreground", "01-02-2024", "01-05-2024", 84F, 1, null, null, null, null, null),
            Anuncio(null, "Jiló", 5, "pitaya_foreground", "01-02-2024", "01-05-2024", 31F, 1, null, null, null, null, null),
            Anuncio(null, "Mirtilo", 5, "pitaya_foreground", "01-02-2024", "01-05-2024", 43F, 1, null, null, null, null, 2),
            Anuncio(null, "Maracujá", 5, "pitaya_foreground", "01-02-2024", "01-05-2024", 12F, 1, null, null, null, null, null),
            Anuncio(null, "Cenoura Branca", 5, "pitaya_foreground", "01-02-2024", "01-05-2024", 43F, 1, null, null, null, null, 1),
            Anuncio(null, "Batata Roxa", 5, "pitaya_foreground", "01-02-2024", "01-05-2024", 43F, 1, null, null, null, null, null)
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
            },
            floatingActionButton = {
                if (isProducer) {
                    FAB(
                        text = "Criar anúncio",
                        navController = navController
                    )
                }
            }
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
                        db
                    )
                }

                composable("create_announcement") {
                    ProducerCreateAnnouncementScreen(
                        paddingValues = paddingValues
                    )
                }
            }

        }
    }
}
