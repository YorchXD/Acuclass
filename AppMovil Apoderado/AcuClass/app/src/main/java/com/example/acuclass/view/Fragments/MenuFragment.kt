package com.example.acuclass.view.Fragments

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.cardview.widget.CardView
import com.example.acuclass.R
import com.example.acuclass.interfaces.IcomunicaFragments

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

    lateinit var interfaceComunicaFragments: IcomunicaFragments
    lateinit var cardNotas: CardView
    lateinit var cardAsistencia: CardView
    lateinit var cardEvaluaciones: CardView
    lateinit var cardConfiguracion: CardView
    lateinit var cardSalir: CardView
    lateinit var vista: View
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
        vista = inflater.inflate(R.layout.fragment_menu, container, false)
        cardNotas = vista.findViewById(R.id.card_notas)
        cardAsistencia = vista.findViewById(R.id.card_asistencia)
        cardEvaluaciones = vista.findViewById(R.id.card_evaluaciones)
        cardConfiguracion = vista.findViewById(R.id.card_configuracion)
        cardSalir = vista.findViewById(R.id.card_salir)
        eventosMenu()
        return vista
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if(context is Activity)
        {
            actividad = context as Activity
            interfaceComunicaFragments = actividad as IcomunicaFragments
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
        cardNotas.setOnClickListener(object: View.OnClickListener {
            override fun onClick(view: View?)
            {
                //dialogo("Notas", "ver notas desde el fragment")
                //Toast.makeText(requireActivity(),"Ver notas desde el fragment", Toast.LENGTH_SHORT).show()
                interfaceComunicaFragments.verAlumnosNotas()
            }
        })

        cardAsistencia.setOnClickListener(object: View.OnClickListener {
            override fun onClick(view: View?)
            {
                interfaceComunicaFragments.verAlumnosAsistencia()
            }
        })

        cardEvaluaciones.setOnClickListener(object: View.OnClickListener {
            override fun onClick(view: View?)
            {
                interfaceComunicaFragments.verAlumnosEvaluaciones()
            }
        })

        cardConfiguracion.setOnClickListener(object: View.OnClickListener {
            override fun onClick(view: View?)
            {
                interfaceComunicaFragments.configuracion()
            }
        })

        cardSalir.setOnClickListener(object: View.OnClickListener {
            override fun onClick(view: View?)
            {
                interfaceComunicaFragments.salir()
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