package com.hortis.hackathon24.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.hortis.hackathon24.entity.Recorrencia

@Dao
interface RecorrenciaDAO {

    @Query("SELECT * FROM recorrencia")
    fun getAll(): List<Recorrencia>

    @Query("SELECT * FROM recorrencia WHERE id IN (:recorrenciaIds)")
    fun loadAllByIds(recorrenciaIds: IntArray): List<Recorrencia>

    @Query(
        "SELECT * FROM recorrencia WHERE nome LIKE :nome LIMIT 1"
    )
    fun findByName(nome: String): Recorrencia

    @Insert
    fun insertAll(vararg recorrencias: Recorrencia)

    @Delete
    fun delete(recorrencia: Recorrencia)

}