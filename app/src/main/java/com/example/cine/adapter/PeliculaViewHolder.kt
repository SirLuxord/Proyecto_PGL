package com.example.cine.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.cine.model.Pelicula
import com.example.cine.databinding.CardViewCineBinding

class PeliculaViewHolder(view:View): RecyclerView.ViewHolder(view) {

    val binding = CardViewCineBinding.bind(view)

//    val pelicula = view.findViewById<TextView>(R.id.tituloPeliculaTextView)
//    val genero = view.findViewById<TextView>(R.id.generoPeliculaTextView)
//    val imagenPelicula = view.findViewById<ImageView>(R.id.peliculaImageView)

    fun render(peliculaItem: Pelicula, onClickListener: (Pelicula) -> Unit){
        binding.tituloPeliculaTextView.text = peliculaItem.titulo
        binding.generoPeliculaTextView.text = peliculaItem.genero
        binding.peliculaImageView.setImageResource(peliculaItem.verticalImagen)
        itemView.setOnClickListener {onClickListener(peliculaItem)}
    }
}