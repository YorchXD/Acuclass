package com.example.acuclass.ui.view.fragments

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import com.example.acuclass.databinding.FragmentMenuBinding
import com.example.acuclass.ui.view.interfaces.IcomunicaFragmentsMenu

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MenuFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MenuFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var _binding: FragmentMenuBinding?=null
    private val binding get() = _binding!!

    lateinit var interfaceComunicaFragmentsMenu: IcomunicaFragmentsMenu
    lateinit var actividad: Activity


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
        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        eventosMenu()
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if(context is Activity)
        {
            actividad = context
            interfaceComunicaFragmentsMenu = actividad as IcomunicaFragmentsMenu
        }
    }

    private fun dialogo(titulo:String, mensaje:String)
    {
        val builder = AlertDialog.Builder(requireActivity())
        builder.setTitle(titulo)
        builder.setMessage(mensaje)
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun eventosMenu()
    {
        binding.cardNotas.setOnClickListener(object: View.OnClickListener {
            override fun onClick(view: View?)
            {
                interfaceComunicaFragmentsMenu.verAlumnosNotas()
            }
        })

        binding.cardAsistencia.setOnClickListener(object: View.OnClickListener {
            override fun onClick(view: View?)
            {
                interfaceComunicaFragmentsMenu.verAlumnosAsistencia()
            }
        })

        binding.cardEvaluaciones.setOnClickListener(object: View.OnClickListener {
            override fun onClick(view: View?)
            {
                interfaceComunicaFragmentsMenu.verAlumnosEvaluaciones()
            }
        })

        binding.cardConfiguracion.setOnClickListener(object: View.OnClickListener {
            override fun onClick(view: View?)
            {
                interfaceComunicaFragmentsMenu.configuracion()
            }
        })

        binding.cardSalir.setOnClickListener(object: View.OnClickListener {
            override fun onClick(view: View?)
            {
                interfaceComunicaFragmentsMenu.salir()
            }
        })
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MenuFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MenuFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}