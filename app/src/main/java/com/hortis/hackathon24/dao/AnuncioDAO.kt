package com.hortis.hackathon24.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.hortis.hackathon24.entity.Anuncio

@Dao
interface AnuncioDAO {

    @Query("SELECT * FROM anuncio")
    fun getAll(): List<Anuncio>

    @Query("SELECT * FROM anuncio WHERE id IN (:anuncioIds)")
    fun loadAllByIds(anuncioIds: IntArray): List<Anuncio>

    @Query(
        "SELECT * FROM anuncio WHERE id_usuario LIKE :nome LIMIT 1"
    )
    fun findByName(nome: String): Anuncio

    @Insert
    fun insertAll(vararg anuncios: Anuncio)

    @Delete
    fun delete(anuncio: Anuncio)

    @Query(
        "DELETE FROM anuncio WHERE 1 = 1"
    )
    fun deleteAll()

}