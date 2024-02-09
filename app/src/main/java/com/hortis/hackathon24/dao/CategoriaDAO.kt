package com.hortis.hackathon24.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.hortis.hackathon24.entity.Categoria

@Dao
interface CategoriaDAO {

    @Query("SELECT * FROM categoria")
    fun getAll(): List<Categoria>

    @Query("SELECT * FROM categoria WHERE id IN (:categoriaIds)")
    fun loadAllByIds(categoriaIds: IntArray): List<Categoria>

    @Query(
        "SELECT * FROM categoria WHERE nome LIKE :nome LIMIT 1"
    )
    fun findByName(nome: String): Categoria

    @Insert
    fun insertAll(vararg categorias: Categoria)

    @Delete
    fun delete(categoria: Categoria)

}