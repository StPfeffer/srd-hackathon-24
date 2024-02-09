package com.hortis.hackathon24.entity.onetoone

import androidx.room.Embedded
import androidx.room.Relation
import com.hortis.hackathon24.entity.Anuncio
import com.hortis.hackathon24.entity.Usuario

data class UsuarioAndAnuncio(
    @Embedded val usuario: Usuario,
    @Relation(
        parentColumn = "id",
        entityColumn = "id_usuario"
    )
    val anuncio: Anuncio
) {
}