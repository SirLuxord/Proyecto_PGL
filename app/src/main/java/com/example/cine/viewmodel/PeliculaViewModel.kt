package com.example.cine.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.cine.model.Pelicula

class PeliculaViewModel(application: Application) : AndroidViewModel(application) {
    private val _peliculaSeleccionada = MutableLiveData<Pelicula>()
    val peliculaSeleccionada: LiveData<Pelicula> get() = _peliculaSeleccionada

    fun setPelicula(pelicula: Pelicula) {
        _peliculaSeleccionada.value = pelicula
    }
}