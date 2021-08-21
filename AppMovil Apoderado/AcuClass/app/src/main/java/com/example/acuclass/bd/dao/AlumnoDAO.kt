package com.example.acuclass.bd.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.acuclass.bd.entities.AlumnoEntity

@Dao
interface AlumnoDAO {
    @Query("SELECT AlumnoEntity.* FROM AlumnoEntity JOIN UsuarioEntity ON UsuarioEntity.run = AlumnoEntity.refApoderado AND UsuarioEntity.run =:refApoderado")
    suspend fun getAll(refApoderado: String):List<AlumnoEntity>

    @Insert
    suspend fun insertar(alumnos:ArrayList<AlumnoEntity>): List<String>
}