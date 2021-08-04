package com.example.acuclass.model

data class Usuario(
    val nombre: String,
    val email: String,
    val clave: String,
    val run: String,
    val alumnos: ArrayList<Alumno> = arrayListOf<Alumno>()
)