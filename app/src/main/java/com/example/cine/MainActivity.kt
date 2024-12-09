package com.example.cine

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cine.adapter.PeliculaAdapter
import com.example.cine.model.Pelicula
import com.example.cine.model.PeliculasProvider
import com.example.cine.databinding.ActivityMainBinding
import com.example.cine.viewmodel.PeliculaViewModel

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var peliculaViewModel: PeliculaViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Toolbar y NavigationDrawer
        setupToolbar(binding.toolbar, getString(R.string.peliculas))

        setupNavigationDrawer(
            findViewById(R.id.main),
            findViewById(R.id.navigation_view)
        )

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initRecyclerView()
        peliculaViewModel = (application as CineApplication).peliculaViewModel
    }


    private fun initRecyclerView(){
        binding.listaReciclerView.layoutManager = LinearLayoutManager(this)
        binding.listaReciclerView.adapter = PeliculaAdapter(PeliculasProvider.listFilms) { pelicula ->
            onItemSelected(
                pelicula
            )
        }
    }

    private fun onItemSelected(pelicula: Pelicula){
        peliculaViewModel.setPelicula(pelicula)
        val intent = Intent(this, PeliculaActivity::class.java)
        startActivity(intent)
    }
}