package com.example.acuclass.view.adaptadores

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.acuclass.R
import com.example.acuclass.databinding.CardLayoutAlumnosBinding
import com.example.acuclass.model.Alumno

class AlumnosAdapter(private val listaAlumnos:ArrayList<Alumno>): RecyclerView.Adapter<AlumnosAdapter.ViewHolder>(), View.OnClickListener
{
    private lateinit var listener: View.OnClickListener

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        val binding = CardLayoutAlumnosBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
    {
        val vista = LayoutInflater.from(parent.context).inflate(R.layout.card_layout_alumnos, parent, false)
        vista.setOnClickListener(this)
        return ViewHolder(vista)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {
        holder.binding.itemTitle.text = listaAlumnos.get(position).nombre
        holder.binding.itemDetail.text = listaAlumnos.get(position).run
    }

    override fun getItemCount(): Int
    {
        return listaAlumnos.size
    }

    fun setOnClickListener(listener: View.OnClickListener)
    {
        this.listener = listener
    }

    override fun onClick(view:View)
    {
        if(listener!=null)
        {
            listener.onClick(view)
        }
    }
}