package com.hortis.hackathon24.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.hortis.hackathon24.entity.FormaPagamento

@Dao
interface FormaPagamentoDAO {

    @Query("SELECT * FROM forma_pagamento")
    fun getAll(): List<FormaPagamento>

    @Query("SELECT * FROM forma_pagamento WHERE id IN (:formaPagamentoIds)")
    fun loadAllByIds(formaPagamentoIds: IntArray): List<FormaPagamento>

    @Query("SELECT * FROM forma_pagamento WHERE nome LIKE :nome LIMIT 1")
    fun findByName(nome: String): FormaPagamento

    @Insert
    fun insertAll(vararg formaspagamento: FormaPagamento)

    @Delete
    fun delete(formaspagamento: FormaPagamento)

}