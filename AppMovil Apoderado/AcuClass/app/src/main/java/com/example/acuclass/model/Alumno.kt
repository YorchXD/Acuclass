package com.example.acuclass.model

data class Alumno (
    val nombre: String,
    val run: String,
    val cursos: ArrayList<Curso> = arrayListOf<Curso>()
)