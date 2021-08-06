package com.example.acuclass.model

class Profesor(
    val nombre: String,
    val run: String,
    val especialidades: ArrayList<Especialidad> = arrayListOf<Especialidad>()
)