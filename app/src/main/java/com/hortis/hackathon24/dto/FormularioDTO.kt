package com.hortis.hackathon24.dto

import com.hortis.hackathon24.entity.Anuncio

class FormularioDTO(
    var categoria: String,
    var produto: String,
    var quantidade: String,
    var valor: String,
    var formaPgto: String,
    var imagem: String
) {

    fun buildAnuncio(): Anuncio {
        val anuncio: Anuncio = Anuncio(null, "", 0, "", "", "", 0f, "1", "null", null, 1)

        anuncio.strcategoria = this.categoria
        anuncio.produto = this.produto
        anuncio.quantidade = this.quantidade.toInt()
        anuncio.preco = this.valor.toFloat()
        anuncio.strformaPagamento = this.formaPgto
        anuncio.imagem = this.imagem

        return anuncio
    }

}