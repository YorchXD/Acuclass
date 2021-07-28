package com.example.acuclass.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isNotEmpty
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.acuclass.R
import com.example.acuclass.viewmodel.UsuarioViewModel
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity(),LifecycleOwner {

    lateinit var correo:TextInputLayout
    lateinit var clave:TextInputLayout
    lateinit var btnIniciar:MaterialButton
    lateinit var viewModel:UsuarioViewModel
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        correo = findViewById(R.id.usuarioTextField)
        clave = findViewById(R.id.claveTextField)
        btnIniciar= findViewById(R.id.btnIniciarSesion)


        btnIniciar.setOnClickListener{

            if(!correo.editText?.text.toString().isEmpty() && !clave.editText?.text.toString().isEmpty())
            {
                this.viewModel = ViewModelProvider(this).get(UsuarioViewModel::class.java)
                viewModel.buscarUsuario(correo.editText?.text.toString(), clave.editText?.text.toString())

                if(viewModel.obtenerUsuario())
                {
                    Toast.makeText(this,"Usuario encontrado", Toast.LENGTH_LONG).show()
                }
                else
                {
                    Toast.makeText(this,"Puede que el email o la clave sean incorrectas o el usuario no se encuentre registrado.", Toast.LENGTH_LONG).show()
                }
            }
            else
            {
                Toast.makeText(this,"Los campos de correo y clave no deben estar vacios", Toast.LENGTH_LONG).show()
            }
        }
    }

}