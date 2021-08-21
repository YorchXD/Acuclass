package com.example.acuclass.data.model

enum class Nivel(val orden:Int) {
    PRIMERO_BASICO(1){ override fun convertirString() = "Primero básico"},
    SEGUNDO_BASICO(2){ override fun convertirString() = "Segundo básico"},
    TERCERO_BASICO(3){ override fun convertirString() = "Tercero básico"},
    CUARTO_BASICO(4){ override fun convertirString() = "Cuarto básico"},
    QUINTO_BASICO(5){ override fun convertirString() = "Quinto básico"},
    SEXTO_BASICO(6){ override fun convertirString() = "Sexto básico"},
    SEPTIMO_BASICO(7){ override fun convertirString() = "Séptimo básico"},
    OCTAVO_BASICO(8){ override fun convertirString() = "Octavo básico"},
    PRIMERO_MEDIO(9){ override fun convertirString() = "Primero medio"},
    SEGUNDO_MEDIO(10){ override fun convertirString() = "Segundo medio"},
    TERCERO_MEDIO(11){ override fun convertirString() = "Tercero medio"},
    CUARTO_MEDIO(12){ override fun convertirString() = "Cuarto medio"};

    abstract fun convertirString(): String

}