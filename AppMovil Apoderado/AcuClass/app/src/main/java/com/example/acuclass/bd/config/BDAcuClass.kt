package com.example.acuclass.bd.config

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.acuclass.bd.dao.AlumnoDAO
import com.example.acuclass.bd.dao.UsuarioDAO
import com.example.acuclass.bd.entities.AlumnoEntity
import com.example.acuclass.bd.entities.UsuarioEntity

@Database(
    entities = [UsuarioEntity::class],
    //entities = [UsuarioEntity::class, AlumnoEntity::class],
    version = 2
)

abstract class BDAcuClass : RoomDatabase() {
    abstract fun usuarioDAO(): UsuarioDAO
    //abstract fun alumnoDAO(): AlumnoDAO
}