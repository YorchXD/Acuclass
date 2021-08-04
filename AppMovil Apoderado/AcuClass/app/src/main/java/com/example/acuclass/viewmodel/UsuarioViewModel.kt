package com.example.acuclass.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.acuclass.model.Alumno
import com.example.acuclass.model.ProveedorUsuarios
import com.example.acuclass.model.Usuario

class UsuarioViewModel: ViewModel()
{
    var usuario: Usuario? = null
    var proveedorUsuarios: ProveedorUsuarios = ProveedorUsuarios()

    fun buscarUsuario(email:String, clave:String): Usuario?
    {
        usuario = proveedorUsuarios.buscarUsuario(email, clave)
        return usuario
    }

    fun obtenerAlumnos(): ArrayList<Alumno>? {
        usuario = proveedorUsuarios.buscarUsuario("yorch5.77@gmail.com", "12345")
        return usuario?.alumnos
    }
}