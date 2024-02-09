package com.hortis.hackathon24.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.room.Room
import com.hortis.hackathon24.dao.AnuncioDAO
import com.hortis.hackathon24.dao.UsuarioDAO
import com.hortis.hackathon24.database.AppDatabase
import com.hortis.hackathon24.entity.Usuario
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow


class HomeViewModel(application: Application) : AndroidViewModel(application) {

    // Expose screen UI state
    private val _listOfUsuarios = MutableStateFlow<MutableList<Usuario>>(mutableListOf())
    val listOfUsuario: StateFlow<MutableList<Usuario>> = _listOfUsuarios.asStateFlow()

    // Handle business logic
    fun loadUsers(applicationContext: Context) {
        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "hortis"
        ).fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()

        val usuarioDAO: UsuarioDAO = db.usuarioDAO()

        usuarioDAO.insertAll(Usuario(1, "nome1"), Usuario(2, "nome2"))

        _listOfUsuarios.value.addAll(usuarioDAO.getAll())
        db.close()
    }
}