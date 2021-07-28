package com.example.acuclass.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.acuclass.model.ProveedorUsuarios
import com.example.acuclass.model.Usuario

class UsuarioViewModel: ViewModel()
{
    var usuario:Boolean = false

    fun obtenerUsuario(): Boolean
    {
        return usuario
    }

    fun buscarUsuario(email:String, clave:String)
    {
        usuario = ProveedorUsuarios.buscarUsuario(email, clave)
    }
}