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
import com.example.acuclass.databinding.FragmentAlumnosNotasBinding
import com.example.acuclass.ui.view.adaptadores.AlumnosAdapter
import com.example.acuclass.ui.view.interfaces.IcomunicaFragmentNotas
import com.example.acuclass.ui.viewmodel.AlumnosNotasViewModel

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
    private var _binding: FragmentAlumnosNotasBinding?=null
    private val binding get() = _binding!!

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    //lateinit var recyclerAlumnos:RecyclerView
    lateinit var actividad: Activity
    lateinit var vista:View
    lateinit var interfaceComunicaFragmentNotas: IcomunicaFragmentNotas
    private lateinit var alumnosNotasViewModel: AlumnosNotasViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        // Inflate the layout for this fragment
        _binding = FragmentAlumnosNotasBinding.inflate(inflater,container, false)
        this.alumnosNotasViewModel = ViewModelProvider(this).get(AlumnosNotasViewModel::class.java)
        inicializar()
        return binding.root
    }

    private fun inicializar()
    {
        inicializarRecyclerView()
        inicializarBtnMenuPrincipal()
    }

    private fun inicializarRecyclerView()
    {
        this.alumnosNotasViewModel.alumnos.observe(viewLifecycleOwner, Observer {
            val adapter = AlumnosAdapter(it)

            adapter.setOnClickListener(object: View.OnClickListener {
                override fun onClick(v: View?) {
                    var runAlumno:String = it.get(binding.recyclerAlumnosNota.getChildAdapterPosition(v!!)).run
                    interfaceComunicaFragmentNotas.setRunAlumno(runAlumno)
                    interfaceComunicaFragmentNotas.vistaCursos()
                }
            })
            binding.recyclerAlumnosNota.layoutManager = LinearLayoutManager(context)
            binding.recyclerAlumnosNota.adapter = adapter
        })
    }

    private fun inicializarBtnMenuPrincipal()
    {
        binding.btnAtras.setOnClickListener(object: View.OnClickListener{
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