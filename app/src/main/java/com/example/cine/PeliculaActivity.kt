package com.example.cine

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cine.databinding.CineInfoViewBinding
import com.example.cine.viewmodel.PeliculaViewModel


class PeliculaActivity: BaseActivity() {


    private lateinit var binding: CineInfoViewBinding
    private lateinit var peliculaViewModel: PeliculaViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = CineInfoViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupToolbar(binding.toolbar, getString(R.string.peliculas))
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
            }
        }
    }
}