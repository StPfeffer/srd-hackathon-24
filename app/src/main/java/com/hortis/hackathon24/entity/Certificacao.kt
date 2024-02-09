package com.hortis.hackathon24.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Calendar
import java.util.GregorianCalendar

@Entity(tableName = "certificacao")
data class Certificacao(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "nome") val nome: String,
    @ColumnInfo(name = "validade") val validade: Calendar
) {}