package com.example.acuclass.data.network

import com.example.acuclass.data.model.Usuario
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface APIService
{
    @GET("buscausuario.php?")
    suspend fun getUsuario(@Query("correo") correo:String): Response<Usuario>
}