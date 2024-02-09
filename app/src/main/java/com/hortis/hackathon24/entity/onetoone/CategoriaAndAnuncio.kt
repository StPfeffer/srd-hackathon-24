package com.hortis.hackathon24.entity.onetoone

import androidx.room.Embedded
import androidx.room.Relation
import com.hortis.hackathon24.entity.Anuncio
import com.hortis.hackathon24.entity.Categoria

data class CategoriaAndAnuncio(@Embedded val categoria: Categoria,
                               @Relation(
                                   parentColumn = "id",
                                   entityColumn = "id_categoria"
                               )
                               val anuncio: Anuncio) {
}