package com.hortis.hackathon24.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.math.BigDecimal
import java.math.BigInteger
import java.util.Calendar

@Entity(tableName = "anuncio")
class Anuncio(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "produto") val produto: String,
    @ColumnInfo(name = "quantidade") val quantidade: Int,
    @ColumnInfo(name = "imagem") val imagem: String,
    @ColumnInfo(name = "disponibilidade_inicial") val disponibilidadeInicial: String,
    @ColumnInfo(name = "disponibilidade_final") val disponibilidadeFinal: String,
    @ColumnInfo(name = "preco") val preco: Float,
    @ColumnInfo(name = "id_usuario") val usuario: Int,
    @ColumnInfo(name = "id_certificacao") val certificacao: Int?,
    @ColumnInfo(name = "id_categoria") val categoria: Int?,
    @ColumnInfo(name = "id_formapagamento") val formaPagamento: Int?,
    @ColumnInfo(name = "id_recorrencia") val recorrencia: Int?,
    @ColumnInfo(name = "id_comprador") val comprador: Int?
) {
}