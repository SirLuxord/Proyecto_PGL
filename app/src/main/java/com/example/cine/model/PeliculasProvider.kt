package com.example.cine.model

import com.example.cine.R
import java.util.Calendar


class PeliculasProvider {
    companion object {
        val listFilms = listOf<Pelicula>(
            Pelicula(
                "Avatar",
                "Aventura y acción",
                "Aquí esta la sinopsis",
                R.drawable.avatar_vertical,
                R.drawable.avatar_horizontal,
                fechaList = listOf(
                    Calendar.getInstance().apply { set(2024, Calendar.DECEMBER, 10) }.time,
                    Calendar.getInstance().apply { set(2024, Calendar.DECEMBER, 12) }.time,
                    Calendar.getInstance().apply { set(2024, Calendar.DECEMBER, 15) }.time
                ),
                horaList = listOf(
                    Calendar.getInstance().apply { set(0, 0, 0, 14, 0) },
                    Calendar.getInstance().apply { set(0, 0, 0, 16, 30)},
                    Calendar.getInstance().apply { set(0, 0, 0, 19, 0)}
                )
            ),
            Pelicula(
                "Batman",
                "Superhéroes y acción",
                "Aquí esta la sinopsis",
                R.drawable.batman_vertical,
                R.drawable.batman_horizontal,
                fechaList = listOf(
                    Calendar.getInstance().apply { set(2024, Calendar.DECEMBER, 11) }.time,
                    Calendar.getInstance().apply { set(2024, Calendar.DECEMBER, 13) }.time,
                    Calendar.getInstance().apply { set(2024, Calendar.DECEMBER, 14) }.time
                ),
                horaList = listOf(
                    Calendar.getInstance().apply { set(0, 0, 0, 15, 30) },
                    Calendar.getInstance().apply { set(0, 0, 0, 18, 0) },
                    Calendar.getInstance().apply { set(0, 0, 0, 20, 30) }
                )
            ),
            Pelicula(
                "My Little Pony",
                "Infantil y aventura",
                "Aquí esta la sinopsis",
                R.drawable.my_little_pony_vertical,
                R.drawable.my_little_pony_horizontal,
                fechaList = listOf(
                    Calendar.getInstance().apply { set(2024, Calendar.DECEMBER, 12) }.time,
                    Calendar.getInstance().apply { set(2024, Calendar.DECEMBER, 15) }.time,
                    Calendar.getInstance().apply { set(2024, Calendar.DECEMBER, 17) }.time
                ),
                horaList = listOf(
                    Calendar.getInstance().apply { set(0, 0, 0, 10, 0) },
                    Calendar.getInstance().apply { set(0, 0, 0, 12, 30) },
                    Calendar.getInstance().apply { set(0, 0, 0, 15, 0) },
                    Calendar.getInstance().apply { set(0, 0, 0, 18, 30) }
                )
            )
        )
    }
}
