package com.example.cine.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cine.Pelicula
import com.example.cine.R

class PeliculaAdapter(private val listFilm:List<Pelicula>) : RecyclerView.Adapter<PeliculaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeliculaViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PeliculaViewHolder(layoutInflater.inflate(R.layout.card_view_cine, parent, false))
    }

    override fun onBindViewHolder(holder: PeliculaViewHolder, position: Int) {
        val item = listFilm[position]
        holder.render(item)
    }

    override fun getItemCount(): Int {
        return listFilm.size
    }


}