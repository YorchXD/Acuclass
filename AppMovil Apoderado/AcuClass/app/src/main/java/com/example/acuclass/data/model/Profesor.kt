package com.example.acuclass.data.model

import com.google.gson.annotations.SerializedName

class Profesor(
    @SerializedName("nombre") var nombre: String,
    @SerializedName("run") var run: String,
    @SerializedName("especialidades") var especialidades: ArrayList<Especialidad> = arrayListOf<Especialidad>()
)