package com.example.cine

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cine.adapter.HorariosAdapter
import com.example.cine.databinding.CineInfoViewBinding
import com.example.cine.viewmodel.PeliculaViewModel
import java.util.Locale


class PeliculaActivity: BaseActivity() {


    private lateinit var binding: CineInfoViewBinding
    private lateinit var peliculaViewModel: PeliculaViewModel
    private lateinit var horariosAdapter: HorariosAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = CineInfoViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Poner el lenguaje del sistema en español

        Locale.setDefault(Locale("es", "ES"))

        horariosAdapter = HorariosAdapter(emptyList(), emptyList())
        binding.horariosRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.horariosRecyclerView.adapter = horariosAdapter

        // Toolbar y NavigationDrawer
        setupToolbar(binding.toolbar, getString(R.string.peliculas))

        setupNavigationDrawer(
            findViewById(R.id.cineActivity),
            findViewById(R.id.navigation_view)
        )

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.cineActivity)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        peliculaViewModel = (application as CineApplication).peliculaViewModel

        peliculaViewModel.peliculaSeleccionada.observe(this) { pelicula ->
            pelicula?.let {
                binding.horizontalPeliculaImageView.setImageResource(pelicula.horizontalImage)
                binding.TituloPeliculaTextView2.text = pelicula.titulo
                binding.SinopsisTextView.text = pelicula.sinopsis
                horariosAdapter.updateData(it.fechaList, it.horaList)
            }
        }
    }
}