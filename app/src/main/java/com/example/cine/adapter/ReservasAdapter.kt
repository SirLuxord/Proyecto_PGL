package com.example.cine.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cine.R
import com.example.cine.model.Reservas


class ReservasAdapter(
    private val reservasList: MutableList<Reservas>,
    private val onReservaRemoved: (Reservas) -> Unit
) : RecyclerView.Adapter<ReservasViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReservasViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ReservasViewHolder(layoutInflater.inflate(R.layout.reservas_cardview, parent, false))
    }

    override fun onBindViewHolder(holder: ReservasViewHolder, position: Int) {
        val reserva = reservasList[position]
        holder.bind(reserva) { reservaToRemove ->
            reservasList.removeAt(position)
            notifyItemRemoved(position)

            // Notificar al ViewModel que se eliminó la reserva
            onReservaRemoved(reservaToRemove)
        }
    }

    fun submitList(newList: MutableList<Reservas>) {
        reservasList.clear()
        reservasList.addAll(newList)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = reservasList.size
}