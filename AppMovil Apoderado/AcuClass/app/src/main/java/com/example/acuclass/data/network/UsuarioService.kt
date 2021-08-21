package com.example.acuclass.data.network

import com.example.acuclass.core.RetrofitHelper
import com.example.acuclass.data.model.Usuario
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class UsuarioService
{
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getUsuarios(): ArrayList<Usuario>
    {
        return withContext(Dispatchers.IO){
            val response: Response<ArrayList<Usuario>> = retrofit.create(APIService::class.java).getUsuarios()
            //println(response.body())
            response.body() ?: arrayListOf<Usuario>()
        }
    }
}