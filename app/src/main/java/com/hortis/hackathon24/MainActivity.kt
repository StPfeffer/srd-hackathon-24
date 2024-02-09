package com.hortis.hackathon24

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.hortis.hackathon24.components.bottomnavbar.BottomNavBar
import com.hortis.hackathon24.components.button.FAB
import com.hortis.hackathon24.components.topnavbar.TopNavBar
import com.hortis.hackathon24.dao.AnuncioDAO
import com.hortis.hackathon24.dao.UsuarioDAO
import com.hortis.hackathon24.database.AppDatabase
import com.hortis.hackathon24.entity.Anuncio
import com.hortis.hackathon24.entity.Usuario
import com.hortis.hackathon24.views.Announcements
import com.hortis.hackathon24.views.HomeScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "hortis"
        ).fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()

        val usuarioDAO: UsuarioDAO = db.usuarioDAO()

        usuarioDAO.insertAll(Usuario(1, "nome1"), Usuario(2, "nome2"))

        val anuncioDao : AnuncioDAO = db.anuncioDAO()

        anuncioDao.insertAll(
            Anuncio(1, "Carambola", 5, "carambola_foreground", "01-02-2024", "01-05-2024", 43F, 1, null, null, null, null, 1),
            Anuncio(2, "Jiló", 5, "carambola_foreground", "01-02-2024", "01-05-2024", 43F, 1, null, null, null, null, 2),
            Anuncio(3, "Mirtilo", 12, "carambola_foreground", "01-02-2024", "01-05-2024", 43F, 1, null, null, null, null, 2),
            Anuncio(4, "Um produto com nome bem grande, isso vai quebrar", 65, "carambola_foreground", "01-02-2024", "01-05-2024", 43F, 1, null, null, null, null, null),
            Anuncio(5, "Pitaya", 2, "carambola_foreground", "01-02-2024", "01-05-2024", 43F, 1, null, null, null, null, 1),
            Anuncio(6, "Batata Roxa", 75, "carambola_foreground", "01-02-2024", "01-05-2024", 43F, 1, null, null, null, null, null),
            Anuncio(7, "Cenoura Branca", 34, "carambola_foreground", "01-02-2024", "01-05-2024", 43F, 1, null, null, null, null, null),
            Anuncio(8, "Produto bem Raro", 1, "carambola_foreground", "01-02-2024", "01-05-2024", 43F, 1, null, null, null, null, null),
            Anuncio(9, "Teste", 567, "carambola_foreground", "01-02-2024", "01-05-2024", 43F, 1, null, null, null, null, null))

        setContent {
            MainView(true, usuarioDAO.getAll(), db)
        }
    }
}

@Composable
fun MainView(
    isProducer: Boolean = false,
    listOfUsuarios: List<Usuario>,
    db: AppDatabase
) {
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
                    HomeScreen(paddingValues, isProducer, db)
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
