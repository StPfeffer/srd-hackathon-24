package com.hortis.hackathon24.repository

import com.hortis.hackathon24.dao.UsuarioDAO
import com.hortis.hackathon24.entity.Usuario

class UsuarioRepository(private val usuarioDAO: UsuarioDAO) {

    fun getAllUsuarios(): List<Usuario> = usuarioDAO.getAll()

}