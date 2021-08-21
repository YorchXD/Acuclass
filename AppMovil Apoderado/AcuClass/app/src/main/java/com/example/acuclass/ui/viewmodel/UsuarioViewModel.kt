package com.example.acuclass.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.acuclass.bd.config.AcuClassApp.Companion.db
import com.example.acuclass.bd.entities.UsuarioEntity
import com.example.acuclass.data.model.Alumno
import com.example.acuclass.data.model.Curso
import com.example.acuclass.data.model.ProveedorUsuarios
import com.example.acuclass.data.model.Usuario
import com.example.acuclass.domain.BuscarUsuarioUseCase
import com.example.acuclass.domain.GetUsuariosUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class UsuarioViewModel: ViewModel()
{
    //val usuario=MutableLiveData<Usuario>()
    var usuario:Usuario?=null
    var getUsuarioUseCase = GetUsuariosUseCase()
    var getBuscarUsuarioUseCase = BuscarUsuarioUseCase()
    val isloading = MutableLiveData<Boolean>()
    private lateinit var proveedorUsuarios: ProveedorUsuarios

    val usuariosList = MutableLiveData<List<UsuarioEntity>>()

    fun onCreate()
    {
        viewModelScope.launch {
            //isloading.postValue(true)
            val result:ArrayList<Usuario>? = getUsuarioUseCase()
            //isloading.postValue(false)

            usuariosList.value = withContext(Dispatchers.IO){
                /*db.usuarioDAO().insertar(listOf<UsuarioEntity>(
                    UsuarioEntity("Yorch Sepúlveda", "17824523-6", "yorch5.77@gmail.com", "Habilitado", "12345"),
                    UsuarioEntity("Juan Perez", "2222222-2", "jperez@gmail.com", "Habilitado", "12345")
                ))*/

                db.usuarioDAO().getAll()
            }
            Log.d("mensaje", "hola")
            for(usuarioAux in usuariosList.value!!)
            {
                Log.d("mensaje", "run: ${usuarioAux.run}, nombre: ${usuarioAux.nombre}")
                //println("run: " + usuarioAux.run + "nombre: " + usuarioAux.nombre)
            }

        }
    }

    fun buscarUsuario(email:String, clave:String)
    {
        //isloading.postValue(true)
        val usuarioAux: Usuario? = getBuscarUsuarioUseCase.invoke(email, clave)
        if(usuarioAux!=null)
        {
            usuario=usuarioAux
            //usuario.postValue(usuarioAux)
            println(usuario)
        }
        //this.usuario = proveedorUsuarios.buscarUsuario(email, clave)
        //isloading.postValue(false)
    }

    /*fun obtenerAlumnos(): ArrayList<Alumno>? {
        this.usuario = getBuscarUsuarioUseCase.invoke("yorch5.77@gmail.com", "12345")
        return this.usuario?.alumnos
        //return usuario?.alumnos
    }

    fun obtenerCursos(run: String?): ArrayList<Curso>? {
        this.usuario = getBuscarUsuarioUseCase.invoke("yorch5.77@gmail.com", "12345")
        return this.usuario?.alumnos?.find { alumno-> alumno.run.equals(run) }?.cursos
        //return usuario?.alumnos?.find { alumno-> alumno.run.equals(run)}?.cursos
    }*/

    fun setProveedorUsuario(proveedorUsuario: ProveedorUsuarios)
    {
        this.proveedorUsuarios = proveedorUsuario
    }
}