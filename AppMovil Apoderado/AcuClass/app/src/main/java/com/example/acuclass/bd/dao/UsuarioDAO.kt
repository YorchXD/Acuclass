package com.example.acuclass.bd.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.acuclass.bd.entities.UsuarioEntity


@Dao
interface UsuarioDAO {

    @Query("SELECT * FROM usuario_entity")
    suspend fun getAll():List<UsuarioEntity>

    /*@Query("SELECT * FROM UsuarioEntity WHERE UsuarioEntity.email = :email AND UsuarioEntity.clave = :clave")
    suspend fun getUsuario(email: String, clave: String):UsuarioEntity*/

    @Insert
    suspend fun insertar(usuarios:List<UsuarioEntity>)
}