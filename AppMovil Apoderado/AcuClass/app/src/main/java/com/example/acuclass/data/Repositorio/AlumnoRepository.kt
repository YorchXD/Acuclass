package com.example.acuclass.data.Repositorio

import android.util.Log
import androidx.lifecycle.asLiveData
import com.example.acuclass.data.Repositorio.ConversorDatos.ConversorAlumno
import com.example.acuclass.data.bd.config.AcuClassApp.Companion.db
import com.example.acuclass.data.bd.config.AcuClassApp.Companion.prefs
import com.example.acuclass.data.bd.entities.AlumnoEntity
import com.example.acuclass.data.model.Alumno
import com.example.acuclass.data.network.UsuarioService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import org.jetbrains.annotations.NotNull

class AlumnoRepository
{
    private val usuarioService = UsuarioService()

    fun getAlumnos(@NotNull email: String): Flow<List<Alumno>> = flow {
        while(true)
        {
            val usuarioResponse = kotlin.runCatching { usuarioService.getUsuarios(email) }
            usuarioResponse.onSuccess {
                if(it.body()!=null)
                {
                    db.alumnoDAO().insertarAlumnos(ConversorAlumno.
                    convertirAlumnosEntity(it.body()!!.alumnos, prefs.runApoderado!!))
                }
            }

            usuarioResponse.onFailure {
                Log.d("ErrorLecturaAlumnos", it.toString())
            }

            val alumnosEntity: List<AlumnoEntity> = db.alumnoDAO().
            getAlumnos(prefs.runApoderado!!)

            if(alumnosEntity!=null)
            {
                emit(ConversorAlumno.convertirAlumnos(alumnosEntity))
            }

            kotlinx.coroutines.delay(5000)
        }
    }.flowOn(Dispatchers.IO)
}