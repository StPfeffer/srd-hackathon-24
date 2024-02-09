package com.hortis.hackathon24.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.hortis.hackathon24.entity.Certificacao
import com.hortis.hackathon24.entity.Usuario

@Dao
interface CertificacaoDAO {
    @Query("SELECT * FROM certificacao")
    fun getAll(): List<Certificacao>

    @Query("SELECT * FROM certificacao WHERE id IN (:certificacaoIds)")
    fun loadAllByIds(certificacaoIds: IntArray): List<Certificacao>

    @Query(
        "SELECT * FROM certificacao WHERE nome LIKE :nome LIMIT 1"
    )
    fun findByName(nome: String): Certificacao

    @Insert
    fun insertAll(vararg certificacoes: Certificacao)

    @Delete
    fun delete(certificacao: Certificacao)

}