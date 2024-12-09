package com.example.cine.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cine.model.Pelicula
import com.example.cine.R

class PeliculaAdapter(
    private val listFilm: List<Pelicula>,
    private val onClickListener: (Pelicula) -> Unit
) : RecyclerView.Adapter<PeliculaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeliculaViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PeliculaViewHolder(layoutInflater.inflate(R.layout.card_view_cine, parent, false))
    }

    override fun onBindViewHolder(holder: PeliculaViewHolder, position: Int) {
        val item = listFilm[position]
        holder.render(item, onClickListener)
    }

    override fun getItemCount(): Int {
        return listFilm.size
    }
}

