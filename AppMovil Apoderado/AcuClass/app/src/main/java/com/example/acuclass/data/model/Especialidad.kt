package com.example.acuclass.data.model

import com.google.gson.annotations.SerializedName

class Especialidad (
    @SerializedName("id") val id:Int,
    @SerializedName("nombre") val nombre: String
)