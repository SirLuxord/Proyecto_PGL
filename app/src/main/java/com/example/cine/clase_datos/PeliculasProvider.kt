package com.example.cine.clase_datos

import com.example.cine.R

class PeliculasProvider {
    companion object {
        val listFilms = listOf<Pelicula>(
            Pelicula(
                "Avatar",
                "Aventura y acción",
                "Aquí esta la sinopsis",
                R.drawable.avatar_vertical,
                R.drawable.avatar_horizontal,
            ),
            Pelicula(
                "Batman",
                "Superheroes y acción",
                "Aquí esta la sinopsis",
                R.drawable.batman_vertical,
                R.drawable.batman_horizontal,
            ),
            Pelicula(
                "My Little Pony",
                "Infantil y aventura",
                "Aquí esta la sinopsis",
                R.drawable.my_little_pony_vertical,
                R.drawable.my_little_pony_horizontal,
            )
        )
    }
}