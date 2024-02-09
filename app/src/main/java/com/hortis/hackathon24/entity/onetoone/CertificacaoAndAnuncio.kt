package com.hortis.hackathon24.entity.onetoone

import androidx.room.Embedded
import androidx.room.Relation
import com.hortis.hackathon24.entity.Anuncio
import com.hortis.hackathon24.entity.Certificacao

class CertificacaoAndAnuncio(
    @Embedded val certificacao: Certificacao,
    @Relation(
        parentColumn = "id",
        entityColumn = "id_certificacao"
    )
    val anuncio: Anuncio
) {
}