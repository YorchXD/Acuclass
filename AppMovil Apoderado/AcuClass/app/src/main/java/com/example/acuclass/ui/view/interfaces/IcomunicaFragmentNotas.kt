package com.example.acuclass.ui.view.interfaces

import com.example.acuclass.data.model.Alumno
import com.example.acuclass.data.model.Curso

interface IcomunicaFragmentNotas
{
    //fun getAlumnos(): ArrayList<Alumno>?
    //fun getCursos(): ArrayList<Curso>?
    fun setRunAlumno(runAlumno:String)
    fun getRunAlumno():String
    fun vistaAlumnos()
    fun vistaCursos()
    fun vistaAsignaturas()
    fun vistaMenuPrincipal()
}