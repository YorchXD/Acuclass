package com.example.acuclass.data.bd.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.acuclass.data.bd.entities.AlumnoEntity
import kotlinx.coroutines.flow.Flow
import org.jetbrains.annotations.NotNull

@Dao
interface AlumnoDAO {
    @Query("SELECT alumno_entity.* FROM alumno_entity WHERE alumno_entity.refApoderado =:refApoderado")
    suspend fun getAlumnos(@NotNull refApoderado: String): List<AlumnoEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarAlumnos(@NotNull alumnos:List<AlumnoEntity>)

}