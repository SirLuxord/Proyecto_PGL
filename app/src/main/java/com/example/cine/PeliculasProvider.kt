package com.example.cine

class PeliculasProvider {
    companion object{
        val listFilms = listOf<Pelicula>(
            Pelicula(
                "Avatar",
                "Aventura y acción",
                "Aquí esta la sinopsis",
                "Futura imasgen"
            ),
            Pelicula(
                "Batman",
                "Superheroes y acción",
                "Aquí esta la sinopsis",
                "Futura imasgen"
            ),
            Pelicula(
                "My Little Pony",
                "Infantil y aventura",
                "Aquí esta la sinopsis",
                "Futura imasgen"
            )
        )
    }
}