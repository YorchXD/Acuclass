package com.example.acuclass.ui.view.fragments

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.acuclass.databinding.FragmentCursosNotasBinding
import com.example.acuclass.ui.view.adaptadores.CursosAdapter
import com.example.acuclass.ui.view.interfaces.IcomunicaFragmentNotas
import com.example.acuclass.ui.viewmodel.CursosNotasViewModel

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

    private var _binding: FragmentCursosNotasBinding?=null
    private val binding get() =_binding!!
    lateinit var actividad: Activity
    lateinit var interfaceComunicaFragmentNotas: IcomunicaFragmentNotas
    private lateinit var cursosNotasViewModel: CursosNotasViewModel

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        // Inflate the layout for this fragment
        _binding = FragmentCursosNotasBinding.inflate(inflater, container, false)
        this.cursosNotasViewModel = ViewModelProvider(this).get(CursosNotasViewModel::class.java)
        inicializar()
        this.cursosNotasViewModel.obtenerAlumnos(interfaceComunicaFragmentNotas.getRunAlumno())
        return binding.root
    }

    private fun inicializar()
    {
        inicializarRecyclerView()
        inicializarBtnMenuPrincipal()
        inicializarBtnAlumnos()
    }

    private fun inicializarBtnMenuPrincipal()
    {
        binding.btnVolverMenu.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                interfaceComunicaFragmentNotas.vistaMenuPrincipal()
            }
        })
    }

    private fun inicializarBtnAlumnos()
    {
        binding.btnVolerAlumnos.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                interfaceComunicaFragmentNotas.vistaAlumnos()
            }
        })
    }

    private fun inicializarRecyclerView()
    {
        this.cursosNotasViewModel.cursos.observe(viewLifecycleOwner, Observer {
            //val cursos: ArrayList<Curso>? = interfaceComunicaFragmentNotas.getCursos()
            val adapter = CursosAdapter(it)

            adapter.setOnClickListener(object: View.OnClickListener {
                override fun onClick(v: View?) {
                    interfaceComunicaFragmentNotas.vistaAsignaturas()
                }
            })
            binding.recyclerCursosNotas.layoutManager = LinearLayoutManager(context)
            binding.recyclerCursosNotas.adapter = adapter
        })
    }

    override fun onAttach(context: Context)
    {
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