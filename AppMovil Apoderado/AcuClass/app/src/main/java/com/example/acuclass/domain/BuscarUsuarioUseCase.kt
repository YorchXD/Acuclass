package com.example.acuclass.domain

import com.example.acuclass.data.UsuarioRepository
import com.example.acuclass.data.model.ProveedorUsuarios
import com.example.acuclass.data.model.Usuario
import java.net.ProtocolException

class BuscarUsuarioUseCase
{
    //private val respository = UsuarioRepository()
    operator fun invoke(email:String, clave:String): Usuario?{
        val usuarios: ArrayList<Usuario> = ProveedorUsuarios.usuarios

        if(!usuarios.isNullOrEmpty())
        {
            return usuarios.find { usuario -> usuario.email.equals(email) && usuario.clave.equals(clave) }
        }
        return null
    }
}