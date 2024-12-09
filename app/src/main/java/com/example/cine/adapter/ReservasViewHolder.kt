package com.example.cine.adapter


import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.cine.databinding.ReservasCardviewBinding
import com.example.cine.model.Reservas

class ReservasViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val binding = ReservasCardviewBinding.bind(view)

    fun bind(reservaItem: Reservas, onCloseClick: (Reservas) -> Unit) {
        binding.peliculaImagen.setImageResource(reservaItem.imagenPelicula)
        binding.nombrePeliculaTextView.text = reservaItem.nombrePelicula
        binding.fechaReservaTextView.text = reservaItem.fecha
        binding.horaReservaTextView.text = reservaItem.hora

        binding.iconoCerrar.setOnClickListener {
            onCloseClick(reservaItem)
        }
    }
}