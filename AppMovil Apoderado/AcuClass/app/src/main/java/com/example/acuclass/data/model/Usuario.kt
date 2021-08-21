package com.example.acuclass.data.model

import com.google.gson.annotations.SerializedName

data class Usuario(
    @SerializedName("nombre") var nombre: String,
    @SerializedName("email") var email: String,
    @SerializedName("clave") var clave: String,
    @SerializedName("run") var run: String,
    @SerializedName("alumnos") var alumnos: ArrayList<Alumno> = arrayListOf<Alumno>()
)