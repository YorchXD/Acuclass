package com.example.acuclass.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.acuclass.R
import com.example.acuclass.interfaces.IcomunicaFragmentNotas
import com.example.acuclass.model.Alumno
import com.example.acuclass.view.fragments.AlumnosNotasFragment
import com.example.acuclass.viewmodel.UsuarioViewModel

class ContenedorNotasActivity : AppCompatActivity(), IcomunicaFragmentNotas
{
    private lateinit var viewModel:UsuarioViewModel
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        this.viewModel = ViewModelProvider(this).get(UsuarioViewModel::class.java)
        setContentView(R.layout.activity_contenedor_notas)
        replaceFragment(AlumnosNotasFragment())
    }

    private fun replaceFragment(fragment: Fragment)
    {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.contenedorNotasFragments, fragment)
        fragmentTransaction.commit()
    }

    override fun getAlumnos(): ArrayList<Alumno>? {
        return viewModel.obtenerAlumnos()
    }
}