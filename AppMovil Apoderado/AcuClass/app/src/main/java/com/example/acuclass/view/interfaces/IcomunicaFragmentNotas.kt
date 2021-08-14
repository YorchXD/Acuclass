package com.example.acuclass.view.interfaces

import com.example.acuclass.model.Alumno
import com.example.acuclass.model.Curso

interface IcomunicaFragmentNotas
{
    fun getAlumnos(): ArrayList<Alumno>?
    fun getCursos(): ArrayList<Curso>?
    fun setRunAlumno(runAlumno:String)
    fun vistaAlumnos()
    fun vistaCursos()
    fun vistaAsignaturas()
    fun vistaMenuPrincipal()
}