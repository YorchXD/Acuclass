package com.example.acuclass.adaptadores

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.acuclass.R
import com.example.acuclass.model.Curso

class CursosAdapter(private val listaCursos:ArrayList<Curso>): RecyclerView.Adapter<CursosAdapter.ViewHolder>(), View.OnClickListener {
    private lateinit var listener: View.OnClickListener

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var itemImage: ImageView
        var itemNombreCurso: TextView
        var itemNombreProfesor: TextView
        var itemAnio: TextView

        init{
            itemImage = itemView.findViewById(R.id.item_image)
            itemNombreCurso = itemView.findViewById(R.id.item_nombreCurso)
            itemNombreProfesor = itemView.findViewById(R.id.item_nombreProfesorEncargado)
            itemAnio = itemView.findViewById(R.id.item_anio)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vista = LayoutInflater.from(parent.context).inflate(R.layout.card_layout_curso, parent, false)
        vista.setOnClickListener(this)
        return ViewHolder(vista)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemNombreCurso.text = listaCursos.get(position).tipoCurso.convertirString() + " " + listaCursos.get(position).letra
        holder.itemNombreProfesor.text = listaCursos.get(position).profesorEncargado.nombre
        holder.itemAnio.text = listaCursos.get(position).anio.toString()
        //holder.itemImage.setImageResource(R.drawable.ic_student)
    }

    override fun getItemCount(): Int {
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