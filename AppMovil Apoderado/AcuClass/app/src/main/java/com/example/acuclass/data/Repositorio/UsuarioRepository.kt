package com.example.acuclass.data.Repositorio

import android.util.Log
import com.example.acuclass.data.Repositorio.ConversorDatos.ConversorUsuario
import com.example.acuclass.data.bd.config.AcuClassApp.Companion.db
import com.example.acuclass.data.bd.config.AcuClassApp.Companion.prefs
import com.example.acuclass.data.bd.entities.UsuarioEntity
import com.example.acuclass.data.model.Usuario
import com.example.acuclass.data.network.UsuarioService

class UsuarioRepository {
    private val usuarioService = UsuarioService()

    suspend fun getUsuario(email: String, clave:String): Usuario?
    {
        val usuarioResponse = kotlin.runCatching { usuarioService.getUsuarios(email) }

        usuarioResponse.onSuccess {
            if(it.body()!=null)
            {
                db.usuarioDAO().insertarUsuario(ConversorUsuario.convertirUsuarioEntity(it.body()!!))
            }
        }

        usuarioResponse.onFailure {
            Log.d("Error", it.toString())
        }

        val usuarioEntity: UsuarioEntity = db.usuarioDAO().getUsuario(email, clave)

        if(usuarioEntity!=null)
        {
            prefs.email = usuarioEntity.email
            prefs.runApoderado = usuarioEntity.run
            return ConversorUsuario.convertirUsuario(usuarioEntity)
        }

        return null
    }
}

