package com.example.acuclass.model

enum class TipoDivisionAnual(val orden:Int) {
    TRIMESTRAL(1){ override fun convertirString() = "Trimestral"},
    SEMESTRAL(2){ override fun convertirString() = "Semestral"},
    ANUAL(3){ override fun convertirString() = "Anual"};

    abstract fun convertirString(): String
}