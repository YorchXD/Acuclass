package com.example.acuclass.ui.view.adaptadores

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.acuclass.R
import com.example.acuclass.databinding.CardLayoutCursoBinding
import com.example.acuclass.data.model.Curso

class CursosAdapter(private val listaCursos:ArrayList<Curso>): RecyclerView.Adapter<CursosAdapter.ViewHolder>(), View.OnClickListener
{
    private lateinit var listener: View.OnClickListener

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        val binding = CardLayoutCursoBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
    {
        val vista = LayoutInflater.from(parent.context).inflate(R.layout.card_layout_curso, parent, false)
        vista.setOnClickListener(this)
        return ViewHolder(vista)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {
        holder.binding.itemNombreCurso.text = listaCursos.get(position).tipoCurso.convertirString() + " " + listaCursos.get(position).letra
        holder.binding.itemNombreProfesorEncargado.text = listaCursos.get(position).profesorEncargado.nombre
        holder.binding.itemAnio.text = listaCursos.get(position).anio.toString()
    }

    override fun getItemCount(): Int
    {
        return listaCursos.size
    }

    fun setOnClickListener(listener: View.OnClickListener)
    {
        this.listener = listener
    }

    override fun onClick(view: View)
    {
        if(listener!=null)
        {
            listener.onClick(view)
        }
    }
}