package com.example.acuclass.ui.viewmodel

import androidx.lifecycle.*
import com.example.acuclass.data.Repositorio.UsuarioRepository
import com.example.acuclass.data.model.ProveedorUsuarios
import com.example.acuclass.data.model.Usuario
import com.example.acuclass.domain.GetAlumnosUseCase
import com.example.acuclass.domain.GetUsuarioUseCase
import kotlinx.coroutines.launch


class UsuarioViewModel: ViewModel()
{
    val usuario=MutableLiveData<Usuario>()
    private val repository = UsuarioRepository()
    val isloading = MutableLiveData<Boolean>()
   //private lateinit var proveedorUsuarios: ProveedorUsuarios

    fun buscarUsuario(email:String, clave:String)
    {
        viewModelScope.launch {
            isloading.postValue(true)
            usuario.value = repository.getUsuario(email, clave)
            isloading.postValue(false)
        }
    }

    /*fun setProveedorUsuario(proveedorUsuario: ProveedorUsuarios)
    {
        this.proveedorUsuarios = proveedorUsuario
    }*/
}