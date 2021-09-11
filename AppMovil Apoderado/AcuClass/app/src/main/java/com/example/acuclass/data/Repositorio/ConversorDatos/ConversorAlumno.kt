package com.example.acuclass.data.Repositorio.ConversorDatos

import com.example.acuclass.data.bd.entities.AlumnoEntity
import com.example.acuclass.data.model.Alumno

class ConversorAlumno
{
    companion object{
        fun convertirAlumnosEntity(alumnos: ArrayList<Alumno>, refApoderado: String): List<AlumnoEntity>
        {
            val alumnosEntity = mutableListOf<AlumnoEntity>()
            alumnos.map {
                alumnosEntity.add(AlumnoEntity(it.nombre, it.run, it.edad, refApoderado))
            }
            return alumnosEntity
        }

        fun convertirAlumnos(alumnosEntity: List<AlumnoEntity>): List<Alumno>
        {
            val alumnos = mutableListOf<Alumno>()
            alumnosEntity.map {
                alumnos.add(Alumno(it.nombre, it.run, it.edad))
            }
            return alumnos
        }
    }
}