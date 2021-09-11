package com.example.acuclass.data.bd.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "usuario_entity")
data class UsuarioEntity (
    @ColumnInfo(name = "nombre")var nombre: String,
    @PrimaryKey @ColumnInfo(name = "run") val run:String,
    @ColumnInfo(name = "email") var email: String,
    //@ColumnInfo(name = "estado")var estado: String,
    @ColumnInfo(name = "clave")var clave: String
)