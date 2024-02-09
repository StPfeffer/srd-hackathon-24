package com.hortis.hackathon24.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categoria")
data class Categoria(
    @PrimaryKey(true) val id: Int?,
    @ColumnInfo(name = "nome") val nome: String
) {
}