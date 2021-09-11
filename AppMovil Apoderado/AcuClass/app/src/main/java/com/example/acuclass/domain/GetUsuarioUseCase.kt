package com.example.acuclass.domain

import com.example.acuclass.data.Repositorio.UsuarioRepository

class GetUsuarioUseCase
{
    private val respository = UsuarioRepository()
    suspend operator fun invoke (email:String, clave:String) = respository.getUsuario(email, clave)
}