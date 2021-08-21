package com.example.acuclass.data.model

import com.google.gson.annotations.SerializedName

data class Alumno (
    @SerializedName("nombre") var nombre: String,
    @SerializedName("run") var run: String,
    @SerializedName("cursos") var cursos: ArrayList<Curso> = arrayListOf<Curso>()
)