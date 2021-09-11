package com.example.acuclass.data.bd.config

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.acuclass.data.bd.dao.AlumnoDAO
import com.example.acuclass.data.bd.dao.UsuarioDAO
import com.example.acuclass.data.bd.entities.AlumnoEntity
import com.example.acuclass.data.bd.entities.UsuarioEntity

@Database(
    //entities = [UsuarioEntity::class],
    entities = [UsuarioEntity::class, AlumnoEntity::class],
    version = 2,
    exportSchema = false
)

abstract class BDAcuClass : RoomDatabase() {
    abstract fun usuarioDAO(): UsuarioDAO
    abstract fun alumnoDAO(): AlumnoDAO
}