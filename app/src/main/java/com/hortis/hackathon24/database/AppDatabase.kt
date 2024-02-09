package com.hortis.hackathon24.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hortis.hackathon24.dao.UsuarioDAO
import com.hortis.hackathon24.entity.Usuario

@Database(entities = [Usuario::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun usuarioDAO(): UsuarioDAO
}