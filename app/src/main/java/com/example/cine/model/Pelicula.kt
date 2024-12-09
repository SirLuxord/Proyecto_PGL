package com.example.cine.model

import java.util.Date

data class Pelicula(
    val titulo: String,
    val genero: String,
    val sinopsis: String,
    val verticalImagen: Int,
    val horizontalImage: Int,
    val fechaList: List<Date>,
    val horaList: List<java.util.Calendar>
)