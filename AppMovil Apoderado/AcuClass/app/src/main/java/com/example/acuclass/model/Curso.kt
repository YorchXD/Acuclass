package com.example.acuclass.model

data class Curso (
    val profesorEncargado: Profesor,
    val tipoCurso: Nivel,
    val letra: String,
    val anio: Int,
    val tipoDivAnual: TipoDivisionAnual
    )