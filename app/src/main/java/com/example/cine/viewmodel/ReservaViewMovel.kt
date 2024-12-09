package com.example.cine.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.cine.model.Reservas

class ReservaViewMovel(application: Application) : AndroidViewModel(application) {
    private val _reservas = MutableLiveData<List<Reservas>>(emptyList())
    val reservas: LiveData<List<Reservas>> = _reservas

    fun setReserva(reserva: Reservas) {
        val currentList = _reservas.value ?: emptyList()
        _reservas.value = currentList + reserva
    }

    fun eliminarReserva(reserva: Reservas) {
        val currentList = _reservas.value ?: emptyList()
        _reservas.value = currentList.filter { it != reserva }
    }
}