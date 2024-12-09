package com.example.cine.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cine.R
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class HorariosAdapter(private var fechas: List<Date>, private var horas: List<Calendar>) :
    RecyclerView.Adapter<HorariosAdapter.HorarioViewHolder>() {

    class HorarioViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val diaTextView: TextView = view.findViewById(R.id.diaTextView)
        val horasTextView: TextView = view.findViewById(R.id.horasTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorarioViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.horario_pelicula, parent, false)
        return HorarioViewHolder(view)
    }

    override fun onBindViewHolder(holder: HorarioViewHolder, position: Int) {
        val fecha = fechas[position]
        val formatoFecha = SimpleDateFormat("EEEE, d 'de' MMMM 'de' yyyy", Locale.getDefault())
        val fechaFormateada = formatoFecha.format(fecha)
        val fechaConMayuscula = fechaFormateada.replaceFirstChar { it.uppercase() }
        holder.diaTextView.text = fechaConMayuscula.format(fecha)

        val horasDelDia = horas.map { hora ->
            val formatoHora = SimpleDateFormat("HH:mm", Locale.getDefault())
            formatoHora.format(hora.time)
        }.joinToString(", ")
        holder.horasTextView.text = horasDelDia
    }

    override fun getItemCount(): Int = fechas.size

    fun updateData(newFechas: List<Date>, newHoras: List<Calendar>) {
        this.fechas = newFechas
        this.horas = newHoras
        notifyDataSetChanged()
    }
}