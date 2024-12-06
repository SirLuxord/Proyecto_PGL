package com.example.cine.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.cine.clase_datos.Pelicula
import com.example.cine.databinding.CardViewCineBinding

class PeliculaViewHolder(view:View): RecyclerView.ViewHolder(view) {

    val binding = CardViewCineBinding.bind(view)

//    val pelicula = view.findViewById<TextView>(R.id.tituloPeliculaTextView)
//    val genero = view.findViewById<TextView>(R.id.generoPeliculaTextView)
//    val imagenPelicula = view.findViewById<ImageView>(R.id.peliculaImageView)

    fun render(peliculaModel: Pelicula){
        binding.tituloPeliculaTextView.text = peliculaModel.titulo
        binding.generoPeliculaTextView.text = peliculaModel.genero
        binding.peliculaImageView.setImageResource(peliculaModel.verticalImagen)
        itemView.setOnClickListener {  }
    }
}