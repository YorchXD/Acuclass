package com.example.acuclass.view.fragments

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.acuclass.R
import com.example.acuclass.adaptadores.AlumnosAdapter
import com.example.acuclass.adaptadores.CursosAdapter
import com.example.acuclass.interfaces.IcomunicaFragmentNotas
import com.example.acuclass.model.Alumno
import com.example.acuclass.model.Curso

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CursosNotasFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CursosNotasFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var recyclerCursos: RecyclerView
    lateinit var actividad: Activity
    lateinit var vista:View
    lateinit var btnMenuPrincipal: Button
    lateinit var btnAlumnos: Button
    lateinit var interfaceComunicaFragmentNotas: IcomunicaFragmentNotas

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        vista = inflater.inflate(R.layout.fragment_cursos_notas, container, false)
        recyclerCursos = vista.findViewById(R.id.recyclerCursosNotas)
        btnAlumnos = vista.findViewById(R.id.btnVolerAlumnos)
        btnMenuPrincipal = vista.findViewById(R.id.btnVolverMenu)
        inicializar()
        return vista
    }

    private fun inicializar()
    {
        inicializarRecyclerView()
        inicializarBtnMenuPrincipal()
        inicializarBtnAlumnos()
    }

    private fun inicializarBtnMenuPrincipal()
    {
        btnMenuPrincipal.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                interfaceComunicaFragmentNotas.vistaMenuPrincipal()
            }
        })
    }

    private fun inicializarBtnAlumnos()
    {
        btnAlumnos.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                interfaceComunicaFragmentNotas.vistaAlumnos()
            }
        })
    }

    private fun inicializarRecyclerView()
    {
        val cursos: ArrayList<Curso>? = interfaceComunicaFragmentNotas.getCursos()
        val adapter = CursosAdapter(cursos!!)

        adapter.setOnClickListener(object: View.OnClickListener {
            override fun onClick(v: View?) {
                interfaceComunicaFragmentNotas.vistaAsignaturas()
            }
        })
        recyclerCursos.layoutManager = LinearLayoutManager(getContext())
        recyclerCursos.adapter = adapter
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        actividad = context as Activity
        interfaceComunicaFragmentNotas = actividad as IcomunicaFragmentNotas
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CursosNotasFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CursosNotasFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}