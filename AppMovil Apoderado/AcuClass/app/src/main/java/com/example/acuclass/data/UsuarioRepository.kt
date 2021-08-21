package com.example.acuclass.data

import com.example.acuclass.data.model.ProveedorUsuarios
import com.example.acuclass.data.model.Usuario
import com.example.acuclass.data.network.UsuarioService

class UsuarioRepository
{
    private val api = UsuarioService()
    suspend fun getUsuarios(): ArrayList<Usuario>
    {
        val response: ArrayList<Usuario> = api.getUsuarios()
        ProveedorUsuarios.usuarios = response
        return response
    }

}