package com.example.acuclass.adaptadores

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.acuclass.R
import com.example.acuclass.model.Alumno

class CustomAdapter(private val listaAlumnos:ArrayList<Alumno>): RecyclerView.Adapter<CustomAdapter.ViewHolder>()
{
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetails: TextView

        init{
            itemImage = itemView.findViewById(R.id.item_image)
            itemTitle = itemView.findViewById(R.id.item_title)
            itemDetails = itemView.findViewById(R.id.item_detail)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vista = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(vista)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemTitle.text = listaAlumnos.get(position).nombre
        holder.itemDetails.text = listaAlumnos.get(position).run
        holder.itemImage.setImageResource(R.drawable.ic_student)
    }

    override fun getItemCount(): Int {
        return listaAlumnos.size
    }


}