package com.hortis.hackathon24.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.math.BigInteger
import java.util.Calendar

@Entity(tableName = "anuncio")
class Anuncio(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "produto") val produto: String,
    @ColumnInfo(name = "quantidade") val quantidade: Int,
    @ColumnInfo(name = "imagem") val imagem: String,
    @ColumnInfo(name = "anunciocol") val anunciocol: String,
    @ColumnInfo(name = "disponibilidade_inicial") val disponibilidadeInicial: Calendar,
    @ColumnInfo(name = "disponibilidade_final") val disponibilidadeFinal: Calendar,
    @ColumnInfo(name = "id_usuario") val preco: BigInteger,
    @ColumnInfo(name = "id_certificacao") val usuario: Usuario,
    @ColumnInfo(name = "id_categoria") val certificacao: Certificacao,
    @ColumnInfo(name = "id_formapagamento") val formaPagamento: FormaPagamento,
    @ColumnInfo(name = "id_recorrencia") val recorrencia: Recorrencia
) {
}