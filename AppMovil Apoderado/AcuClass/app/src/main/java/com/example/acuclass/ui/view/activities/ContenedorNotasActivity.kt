package com.example.acuclass.ui.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.acuclass.R
import com.example.acuclass.ui.view.interfaces.IcomunicaFragmentNotas
import com.example.acuclass.data.model.Alumno
import com.example.acuclass.data.model.Curso
import com.example.acuclass.ui.view.fragments.AlumnosNotasFragment
import com.example.acuclass.ui.view.fragments.AsignaturasNotasFragment
import com.example.acuclass.ui.view.fragments.CursosNotasFragment
import com.example.acuclass.ui.viewmodel.UsuarioViewModel

class ContenedorNotasActivity : AppCompatActivity(), IcomunicaFragmentNotas
{
    private lateinit var viewModel:UsuarioViewModel
    private lateinit var runAlumno: String

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        this.viewModel = ViewModelProvider(this).get(UsuarioViewModel::class.java)
        setContentView(R.layout.activity_contenedor_notas)
        vistaAlumnos()
    }

    private fun replaceFragment(fragment: Fragment)
    {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.contenedorNotasFragments, fragment)
        fragmentTransaction.commit()
    }

    override fun setRunAlumno(runAlumno: String) {
        this.runAlumno = runAlumno
    }

    override fun getRunAlumno(): String {
        return this.runAlumno
    }

    override fun vistaAlumnos()
    {
        replaceFragment(AlumnosNotasFragment())
    }

    override fun vistaCursos()
    {
        replaceFragment(CursosNotasFragment())
    }

    override fun vistaAsignaturas()
    {
        replaceFragment(AsignaturasNotasFragment())
    }

    override fun vistaMenuPrincipal()
    {
        finish()
    }
}