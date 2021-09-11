package com.example.acuclass.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.acuclass.data.Repositorio.AlumnoRepository
import com.example.acuclass.data.bd.config.AcuClassApp.Companion.prefs

class AlumnosNotasViewModel: ViewModel()
{
    private val repository = AlumnoRepository()
    var alumnos = repository.getAlumnos(prefs.email!!).asLiveData()
}