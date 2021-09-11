package com.example.acuclass.data.Repositorio.ConversorDatos

import com.example.acuclass.data.bd.entities.UsuarioEntity
import com.example.acuclass.data.model.Usuario

class ConversorUsuario
{
    companion object{
        fun convertirUsuarioEntity(usuario:Usuario): UsuarioEntity
        {
            return UsuarioEntity(usuario.nombre, usuario.run, usuario.email, usuario.clave)
        }

        fun convertirUsuario(usuario:UsuarioEntity): Usuario
        {
            return Usuario(usuario.nombre, usuario.run, usuario.email, usuario.clave)
        }
    }
}