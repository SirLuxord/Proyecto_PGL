package com.example.cine.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cine.Pelicula
import com.example.cine.R

class PeliculaViewHolder(view:View): RecyclerView.ViewHolder(view) {

    val pelicula = view.findViewById<TextView>(R.id.tituloPeliculaTextView)
    val genero = view.findViewById<TextView>(R.id.generoPeliculaTextView)
    val imagenPelicula = view.findViewById<ImageView>(R.id.peliculaImageView)

    fun render(peliculaModel: Pelicula){
        pelicula.text = peliculaModel.titulo
        genero.text = peliculaModel.genero
    }
}