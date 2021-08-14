package com.example.acuclass.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import com.example.acuclass.R
import com.example.acuclass.databinding.ActivityLoginBinding
import com.example.acuclass.model.Usuario
import com.example.acuclass.viewmodel.UsuarioViewModel
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity(),LifecycleOwner {
    private lateinit var binding: ActivityLoginBinding
    lateinit var viewModel:UsuarioViewModel
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnIniciarSesion.setOnClickListener{
            if(binding.correo.text.toString().isNotEmpty() && binding.clave.text.toString().isNotEmpty())
            {
                this.viewModel = ViewModelProvider(this).get(UsuarioViewModel::class.java)
                val usuario: Usuario? = viewModel.buscarUsuario(binding.correo.text.toString(), binding.clave.text.toString())
                if(usuario!=null)
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
