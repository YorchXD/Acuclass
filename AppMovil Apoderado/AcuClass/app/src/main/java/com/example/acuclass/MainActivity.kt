package com.example.acuclass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.acuclass.databinding.ActivityMainBinding
import com.example.acuclass.interfaces.IcomunicaFragments
import com.example.acuclass.view.Fragments.MenuFragment

class MainActivity : AppCompatActivity(),IcomunicaFragments {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
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
        dialogo("Notas", "Ver notas desde el activity")
    }

    override fun verAlumnosAsistencia()
    {
        dialogo("Asistencia", "Ver asistencia desde el activity")
    }

    override fun verAlumnosEvaluaciones()
    {
        dialogo("Evaluaciones", "Ver evaluaciones desde el activity")
    }

    override fun configuracion()
    {
        dialogo("Configuracion", "Ir a configuracion desde el activity")
    }

    override fun salir()
    {
        dialogo("Salir", "Salir desde el activity")
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