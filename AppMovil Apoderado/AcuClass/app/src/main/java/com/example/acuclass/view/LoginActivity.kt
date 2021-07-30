package com.example.acuclass.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import com.example.acuclass.MainActivity
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
                    //Toast.makeText(this,"Usuario encontrado", Toast.LENGTH_LONG).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent);
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