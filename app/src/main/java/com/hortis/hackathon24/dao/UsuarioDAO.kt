package com.hortis.hackathon24.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.hortis.hackathon24.entity.Usuario

@Dao
interface UsuarioDAO {
    @Query("SELECT * FROM usuario")
    fun getAll(): List<Usuario>

    @Query("SELECT * FROM usuario WHERE id IN (:usuarioIds)")
    fun loadAllByIds(usuarioIds: IntArray): List<Usuario>

    @Query(
        "SELECT * FROM usuario WHERE nome LIKE :nome LIMIT 1"
    )
    fun findByName(nome: String): Usuario

    @Query(
        "SELECT * FROM usuario WHERE id LIKE :id LIMIT 1"
    )
    fun findById(id: Int): Usuario

    @Insert
    fun insertAll(vararg usuarios: Usuario)

    @Delete
    fun delete(usuario: Usuario)

}