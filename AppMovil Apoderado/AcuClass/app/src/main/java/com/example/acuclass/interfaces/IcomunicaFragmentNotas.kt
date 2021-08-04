package com.example.acuclass.interfaces

import com.example.acuclass.model.Alumno
import com.example.acuclass.viewmodel.UsuarioViewModel

interface IcomunicaFragmentNotas
{
    fun getAlumnos(): ArrayList<Alumno>?
}