package com.example.acuclass.bd.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity (foreignKeys = arrayOf(
            ForeignKey(
                entity = UsuarioEntity::class,
                parentColumns = ["run"],
                childColumns = ["refApoderado"]
            )
        ))
data class AlumnoEntity (
    var nombre: String,
    @PrimaryKey val run: String,
    var edad: Int,
    var refApoderado:String
)