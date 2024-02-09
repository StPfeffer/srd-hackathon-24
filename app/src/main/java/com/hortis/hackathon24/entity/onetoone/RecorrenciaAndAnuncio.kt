package com.hortis.hackathon24.entity.onetoone

import androidx.room.Embedded
import androidx.room.Relation
import com.hortis.hackathon24.entity.Anuncio
import com.hortis.hackathon24.entity.Categoria
import com.hortis.hackathon24.entity.Recorrencia

class RecorrenciaAndAnuncio(@Embedded val recorrencia: Recorrencia,
                            @Relation(
                                parentColumn = "id",
                                entityColumn = "id_recorrencia"
                            )
                            val anuncio: Anuncio
) {
}