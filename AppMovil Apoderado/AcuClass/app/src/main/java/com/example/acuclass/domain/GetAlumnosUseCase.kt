package com.example.acuclass.domain

import com.example.acuclass.data.Repositorio.AlumnoRepository
import com.example.acuclass.data.Repositorio.UsuarioRepository
import com.example.acuclass.data.model.ProveedorUsuarios
import com.example.acuclass.data.model.Usuario

class GetAlumnosUseCase
{
    private val respository = AlumnoRepository()
    suspend operator fun invoke (email:String) = respository.getAlumnos(email)
}