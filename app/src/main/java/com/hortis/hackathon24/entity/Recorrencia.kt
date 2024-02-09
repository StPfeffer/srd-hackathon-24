package com.hortis.hackathon24.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "recorrencia")
data class Recorrencia(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "nome") val nome: String,
    @ColumnInfo(name = "frequencia") val frequencia: Int,
    @ColumnInfo(name = "tipo") val validade: String
) {}