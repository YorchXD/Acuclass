package com.example.acuclass.ui.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.acuclass.databinding.ActivityLoginBinding
import com.example.acuclass.data.model.Usuario
import com.example.acuclass.ui.viewmodel.UsuarioViewModel

class LoginActivity : AppCompatActivity(),LifecycleOwner {
    private lateinit var binding: ActivityLoginBinding
    lateinit var viewModel:UsuarioViewModel
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        this.viewModel = ViewModelProvider(this).get(UsuarioViewModel::class.java)

        viewModel.onCreate()

        viewModel.isloading.observe(this, Observer {
            binding.progress.isVisible = it
        })

        binding.btnIniciarSesion.setOnClickListener{
            if(binding.correo.text.toString().isNotEmpty() && binding.clave.text.toString().isNotEmpty())
            {
                viewModel.buscarUsuario(binding.correo.text.toString(), binding.clave.text.toString())
                val usuario: Usuario? = viewModel.usuario
                if(usuario!=null)
                {
                    //Toast.makeText(this,"Usuario encontrado", Toast.LENGTH_LONG).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
                else
                {
                    //dialogo("Datos incorrectos", "Puede que el email o la clave sean incorrectas o el usuario no se encuentre registrado.")
                    Toast.makeText(this,"Puede que el email o la clave sean incorrectas o el usuario no se encuentre registrado.", Toast.LENGTH_LONG).show()
                }
            }
            else
            {
                //dialogo("Campos vacios", "Los campos de correo y clave no deben estar vacios")
                Toast.makeText(this,"Los campos de correo y clave no deben estar vacios", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun dialogo(titulo:String, mensaje:String)
    {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(titulo)
        builder.setMessage(mensaje)
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}
