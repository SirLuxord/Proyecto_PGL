package com.example.cine

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import com.example.cine.viewmodel.PeliculaViewModel
import com.example.cine.viewmodel.ReservaViewMovel

class CineApplication : Application() {



    // Usamos un ViewModelProvider adecuado
    private var _peliculaViewModel: PeliculaViewModel? = null
    private var _reservaViewModel: ReservaViewMovel? = null

    override fun onCreate() {
        super.onCreate()
        _peliculaViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(this)
            .create(PeliculaViewModel::class.java)

        _reservaViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(this)
            .create(ReservaViewMovel::class.java)
    }

    // Getter para acceder al ViewModel globalmente
    val peliculaViewModel: PeliculaViewModel
        get() = _peliculaViewModel!!

    val reservaViewModel: ReservaViewMovel
        get() = _reservaViewModel!!
}