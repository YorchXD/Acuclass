package com.example.acuclass.data.model

import com.google.gson.annotations.SerializedName

data class Curso (
    @SerializedName("profesorEncargado") var profesorEncargado: Profesor,
    @SerializedName("tipoCurso") var tipoCurso: Nivel,
    @SerializedName("letra") var letra: String,
    @SerializedName("anio") var anio: Int,
    @SerializedName("tipoDivAnual") var tipoDivAnual: TipoDivisionAnual
    )