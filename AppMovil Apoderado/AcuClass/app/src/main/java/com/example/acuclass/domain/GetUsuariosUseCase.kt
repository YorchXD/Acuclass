package com.example.acuclass.domain

import com.example.acuclass.data.UsuarioRepository
import com.example.acuclass.data.model.Usuario

class GetUsuariosUseCase
{
    private val respository = UsuarioRepository()
    suspend operator fun invoke ():ArrayList<Usuario>? = respository.getUsuarios()
}