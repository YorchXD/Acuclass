package com.example.acuclass.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.acuclass.data.model.Curso
import com.example.acuclass.domain.GetAlumnosUseCase

class CursosNotasViewModel: ViewModel()
{
    var cursos = MutableLiveData<ArrayList<Curso>>()
    var buscarUsuarioUseCase = GetAlumnosUseCase()

    fun obtenerAlumnos(runAlumno:String)
    {
        //val alumnos = buscarUsuarioUseCase.invoke("yorch5.77@gmail.com", "12345")?.alumnos
        //cursos.value = alumnos?.find { alumno-> alumno.run.equals(runAlumno) }?.cursos
    }
}