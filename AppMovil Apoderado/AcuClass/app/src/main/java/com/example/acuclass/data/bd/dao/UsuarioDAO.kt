package com.example.acuclass.data.bd.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.acuclass.data.bd.entities.UsuarioEntity



@Dao
interface UsuarioDAO {
    @Query("SELECT * FROM usuario_entity WHERE usuario_entity.email = :email AND usuario_entity.clave = :clave")
    suspend fun getUsuario(email: String, clave: String):UsuarioEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarListadoUsuario(usuarios:List<UsuarioEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarUsuario(usuario: UsuarioEntity)
}