package com.example.acuclass.data.network

import com.example.acuclass.data.network.core.RetrofitHelper
import com.example.acuclass.data.model.Usuario
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jetbrains.annotations.NotNull
import retrofit2.Response

class UsuarioService
{
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getUsuarios(correo:String): Response<Usuario>{
        return withContext(Dispatchers.IO){
            retrofit.create(APIService::class.java).getUsuario(correo)
        }
    }
}