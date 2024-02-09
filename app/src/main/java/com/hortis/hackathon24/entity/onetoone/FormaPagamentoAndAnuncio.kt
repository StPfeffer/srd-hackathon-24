package com.hortis.hackathon24.entity.onetoone

import androidx.room.Embedded
import androidx.room.Relation
import com.hortis.hackathon24.entity.Anuncio
import com.hortis.hackathon24.entity.Categoria
import com.hortis.hackathon24.entity.FormaPagamento

class FormaPagamentoAndAnuncio(@Embedded val formaPagamento: FormaPagamento,
                               @Relation(
                                   parentColumn = "id",
                                   entityColumn = "id_formapagamento"
                               )
                               val anuncio: Anuncio
) {
}