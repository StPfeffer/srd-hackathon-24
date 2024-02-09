package com.hortis.hackathon24.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "anuncio")
class Anuncio(
    @PrimaryKey(true) val id: Int?,
    @ColumnInfo(name = "produto") var produto: String,
    @ColumnInfo(name = "quantidade") var quantidade: Int,
    @ColumnInfo(name = "imagem") var imagem: String,
    @ColumnInfo(name = "disponibilidade_inicial") val disponibilidadeInicial: String,
    @ColumnInfo(name = "disponibilidade_final") val disponibilidadeFinal: String,
    @ColumnInfo(name = "preco") var preco: Float,
    @ColumnInfo(name = "categoria") var strcategoria: String?,
    @ColumnInfo(name = "formapagamento") var strformaPagamento: String?,
    @ColumnInfo(name = "id_comprador") val comprador: Int?,
    @ColumnInfo(name = "id_usuario") val usuario: Int
) {
}