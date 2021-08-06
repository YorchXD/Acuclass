package com.example.acuclass.view.fragments

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.acuclass.R
import com.example.acuclass.adaptadores.AlumnosAdapter
import com.example.acuclass.interfaces.IcomunicaFragmentNotas
import com.example.acuclass.model.Alumno

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AlumnosNotasFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
open class AlumnosNotasFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var recyclerAlumnos:RecyclerView
    lateinit var actividad: Activity
    lateinit var vista:View
    lateinit var btnMenuPrincipal: Button
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
        vista = inflater.inflate(R.layout.fragment_alumnos_notas, container, false)
        recyclerAlumnos = vista.findViewById(R.id.recyclerAlumnosNota)
        btnMenuPrincipal = vista.findViewById(R.id.btnAtras)
        inicializar()
        return vista
    }

    private fun inicializar()
    {
        inicializarRecyclerView()
        inicializarBtnMenuPrincipal()
    }

    private fun inicializarRecyclerView()
    {
        val alumnos: ArrayList<Alumno>? = interfaceComunicaFragmentNotas.getAlumnos()
        val adapter = AlumnosAdapter(alumnos!!)

        adapter.setOnClickListener(object: View.OnClickListener {
            override fun onClick(v: View?) {
                /*Toast.makeText(requireContext(),
                    "Seleccionó: " + alumnos.get(recyclerAlumnos.getChildAdapterPosition(v!!)).nombre,
                    Toast.LENGTH_SHORT).show()*/
                var runAlumno:String = alumnos.get(recyclerAlumnos.getChildAdapterPosition(v!!)).run
                interfaceComunicaFragmentNotas.setRunAlumno(runAlumno)
                interfaceComunicaFragmentNotas.vistaCursos()
            }
        })
        recyclerAlumnos.layoutManager = LinearLayoutManager(getContext())
        recyclerAlumnos.adapter = adapter
    }

    private fun inicializarBtnMenuPrincipal()
    {
        btnMenuPrincipal.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                interfaceComunicaFragmentNotas.vistaMenuPrincipal()
            }
        })
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
         * @return A new instance of fragment AlumnosNotasFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AlumnosNotasFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}