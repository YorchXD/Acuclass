package com.example.acuclass.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.acuclass.data.model.Alumno
import com.example.acuclass.domain.BuscarUsuarioUseCase


class AlumnoViewModel: ViewModel()
{
    var alumnos = MutableLiveData<ArrayList<Alumno>>()
    var buscarUsuarioUseCase = BuscarUsuarioUseCase()

    fun obtenerAlumnos() {
        alumnos.value = buscarUsuarioUseCase.invoke("yorch5.77@gmail.com", "12345")?.alumnos
    }
}