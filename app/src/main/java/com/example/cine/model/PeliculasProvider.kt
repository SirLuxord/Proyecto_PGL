package com.example.cine.model

import com.example.cine.R
import java.util.Calendar


class PeliculasProvider {
    companion object {
        val listFilms = listOf<Pelicula>(
            Pelicula(
                "Avatar",
                "Aventura y acción",
                "Entramos en el mundo Avatar de la mano de Jake Sully, un ex-Marine en silla de ruedas, " +
                        "que ha sido reclutado para viajar a Pandora, donde existe un mineral raro y muy preciado " +
                        "que puede solucionar la crisis energética existente en la Tierra.",
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
                "En su segundo año luchando contra el crimen, Batman explora la corrupción existente en la ciudad " +
                        "de Gotham y el vínculo de esta con su propia familia. Además, entrará en conflicto con un asesino " +
                        "en serie conocido como \"el Acertijo\".",
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
                "Después de que una fuerza oscura conquista Canterlot, las Mane 6 se embarcan en un viaje inolvidable " +
                        "más allá de Equestria para salvar su patria. Allí conocerán a nuevos amigos, como Capper, La Reina " +
                        "Novo y su hija Skystar, o la Capitana Gelaeno, y se enfrentarán a desafíos emocionantes.",
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
