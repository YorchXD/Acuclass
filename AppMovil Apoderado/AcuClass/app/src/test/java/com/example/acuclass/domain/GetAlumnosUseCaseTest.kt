package com.example.acuclass.domain

import com.example.acuclass.data.Repositorio.AlumnoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.DisposableHandle
import kotlinx.coroutines.withContext
import org.junit.Test

import org.junit.Assert.*

class GetAlumnosUseCaseTest {

    @Test
    suspend fun funcion() {
        withContext(Dispatchers.IO){
            val respository = AlumnoRepository()
            print( respository.getAlumnos("yorch5.77@gmail.com").toString())
        }



    }
}