package com.example.cine

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cine.adapter.PeliculaAdapter
import com.example.cine.adapter.ReservasAdapter
import com.example.cine.databinding.ActivityMainBinding
import com.example.cine.model.Pelicula
import com.example.cine.model.PeliculasProvider
import com.example.cine.viewmodel.ReservaViewMovel

class ListaReservasActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var reservaViewModel: ReservaViewMovel

    // Declarar reservasAdapter como propiedad
    private lateinit var reservasAdapter: ReservasAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupToolbar(binding.toolbar, getString(R.string.reservas))
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        reservaViewModel = (application as CineApplication).reservaViewModel

        binding.toolbar.title = getString(R.string.reservas)
        initRecyclerView()
        observeReservas()
    }

    private fun initRecyclerView() {
        // Inicializar reservasAdapter con una lista vacía
        reservasAdapter = ReservasAdapter(mutableListOf())
        binding.listaReciclerView.layoutManager = LinearLayoutManager(this)
        binding.listaReciclerView.adapter = reservasAdapter
    }

    private fun observeReservas() {
        reservaViewModel.reservas.observe(this) { reservas ->
            reservasAdapter.submitList(reservas.toMutableList())
        }
    }
}