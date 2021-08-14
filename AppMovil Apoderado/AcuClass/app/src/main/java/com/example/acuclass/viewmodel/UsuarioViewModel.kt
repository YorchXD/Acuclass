package com.example.acuclass.viewmodel

import androidx.lifecycle.ViewModel
import com.example.acuclass.model.Alumno
import com.example.acuclass.model.Curso
import com.example.acuclass.model.ProveedorUsuarios
import com.example.acuclass.model.Usuario

class UsuarioViewModel: ViewModel()
{
    private var usuario: Usuario? = null
    private var proveedorUsuarios: ProveedorUsuarios = ProveedorUsuarios()

    fun buscarUsuario(email:String, clave:String): Usuario?
    {
        this.usuario = proveedorUsuarios.buscarUsuario(email, clave)
        return this.usuario
    }

    fun obtenerAlumnos(): ArrayList<Alumno>? {
        this.usuario = proveedorUsuarios.buscarUsuario("yorch5.77@gmail.com", "12345")
        return this.usuario?.alumnos
    }

    fun obtenerCursos(run: String?): ArrayList<Curso>? {
        this.usuario = proveedorUsuarios.buscarUsuario("yorch5.77@gmail.com", "12345")
        return this.usuario?.alumnos?.find { alumno-> alumno.run.equals(run) }?.cursos
    }

    fun setProveedorUsuario(proveedorUsuario:ProveedorUsuarios)
    {
        this.proveedorUsuarios = proveedorUsuario
    }
}