package com.hortis.hackathon24.dto

import com.hortis.hackathon24.entity.Anuncio

class FormularioDTO(
    var categoria: String,
    var produto: String,
    var quantidade: Int,
    var valor: Float,
    var formaPgto: String,
    var imagem: String
) {

    fun buildAnuncio(): Anuncio {
        val anuncio: Anuncio = Anuncio(null, "", 0, "", "", "", 0f, "1", "null", null, 1)

        anuncio.strcategoria = this.categoria
        anuncio.produto = this.produto
        anuncio.quantidade = this.quantidade
        anuncio.preco = this.valor
        anuncio.strformaPagamento = this.formaPgto
        anuncio.imagem = this.imagem

        return anuncio
    }

}