package com.example.acuclass.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.acuclass.R
import com.example.acuclass.databinding.ActivityMainBinding
import com.example.acuclass.view.interfaces.IcomunicaFragmentsMenu
import com.example.acuclass.view.fragments.MenuFragment

class MainActivity : AppCompatActivity(),IcomunicaFragmentsMenu
{
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(MenuFragment())
    }

    private fun replaceFragment(fragment: Fragment)
    {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.contenedorFragments, fragment)
        fragmentTransaction.commit()
    }

    override fun verAlumnosNotas()
    {
        val intent = Intent(this, ContenedorNotasActivity::class.java)
        startActivity(intent);
    }

    override fun verAlumnosAsistencia()
    {
        //dialogo("Asistencia", "Ver asistencia desde el activity")
        Toast.makeText(this, "Ver asistencia desde el activity", Toast.LENGTH_LONG).show()
    }

    override fun verAlumnosEvaluaciones()
    {
        //dialogo("Evaluaciones", "Ver evaluaciones desde el activity")
        Toast.makeText(this, "Ver evaluaciones desde el activity", Toast.LENGTH_LONG).show()
    }

    override fun configuracion()
    {
        //dialogo("Configuracion", "Ir a configuracion desde el activity")
        Toast.makeText(this, "Ir a configuracion desde el activity", Toast.LENGTH_LONG).show()
    }

    override fun salir()
    {
        finish()
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