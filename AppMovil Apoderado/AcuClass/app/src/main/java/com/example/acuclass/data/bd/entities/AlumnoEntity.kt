package com.example.acuclass.data.bd.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity (tableName = "alumno_entity", foreignKeys = arrayOf(
            ForeignKey(
                entity = UsuarioEntity::class,
                parentColumns = ["run"],
                childColumns = ["refApoderado"]
            )
        ))
data class AlumnoEntity (
    @ColumnInfo(name = "nombre")var nombre: String,
    @PrimaryKey  @ColumnInfo(name = "run") val run: String,
    @ColumnInfo(name = "edad") var edad: Int,
    @ColumnInfo(name = "refApoderado") var refApoderado:String
)