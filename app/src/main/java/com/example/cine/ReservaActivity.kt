package com.example.cine

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cine.databinding.ReservasFormularioBinding
import com.example.cine.model.Pelicula
import com.example.cine.model.PeliculasProvider
import com.example.cine.model.Reservas
import com.example.cine.viewmodel.ReservaViewMovel
import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.MaterialDatePicker
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class ReservaActivity : BaseActivity() {

    private lateinit var binding: ReservasFormularioBinding
    private lateinit var reservaViewModel: ReservaViewMovel
    private lateinit var peliculaSeleccionada: Pelicula

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ReservasFormularioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Toolbar y NavigationDrawer
        setupToolbar(binding.toolbar, getString(R.string.reservas))

        setupNavigationDrawer(
            findViewById(R.id.crearReservaActivity),
            findViewById(R.id.navigation_view)
        )

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.crearReservaActivity)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        reservaViewModel = (application as CineApplication).reservaViewModel

        // Cambio de idioma al español para los componentes

        Locale.setDefault(Locale("es", "ES"))

        // Spinner Películas

        peliculaSeleccionada = PeliculasProvider.listFilms[0]

        val peliculasTitulos = PeliculasProvider.listFilms.map { it.titulo }

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, peliculasTitulos)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        binding.spinnerPeliculas.adapter = adapter

        binding.spinnerPeliculas.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                peliculaSeleccionada = PeliculasProvider.listFilms[position]
                binding.dateEditText.setText("")
                binding.timeEditText.setText("")
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        // DatePicker Fecha de la película

        binding.dateEditText.setOnClickListener {

            // Normaliza las fechas disponibles a medianoche (inicio del día)
            // Antes era esto: val fechasDisponiblesTimestamps = peliculaSeleccionada.fechaList.map { it.time }
            val fechasDisponiblesTimestamps = peliculaSeleccionada.fechaList.map { fecha ->
                Calendar.getInstance().apply {
                    time = fecha
                    set(Calendar.HOUR_OF_DAY, 0)
                    set(Calendar.MINUTE, 0)
                    set(Calendar.SECOND, 0)
                    set(Calendar.MILLISECOND, 0)
                }.timeInMillis
            }

            // Crea un validador personalizado para permitir solo fechas válidas
            val validator = object : CalendarConstraints.DateValidator {
                override fun isValid(date: Long): Boolean {
                    val normalizedDate = Calendar.getInstance().apply {
                        timeInMillis = date
                        set(Calendar.HOUR_OF_DAY, 0)
                        set(Calendar.MINUTE, 0)
                        set(Calendar.SECOND, 0)
                        set(Calendar.MILLISECOND, 0)
                    }.timeInMillis

                    return fechasDisponiblesTimestamps.contains(normalizedDate)
                }

                override fun describeContents(): Int = 0 // Tipo de objeto, 0 = Sin características especiales, campo obligatorio
                override fun writeToParcel(dest: android.os.Parcel, flags: Int) {} // Serialización de datos, campo obligatorio
            }

            // Configura las restricciones del calendario
            val limitarDias = CalendarConstraints.Builder()
                .setValidator(validator)

            // Crea el selector de fechas
            val datePicker = MaterialDatePicker.Builder.datePicker()
                .setTitleText("Selecciona una fecha")
                .setCalendarConstraints(limitarDias.build()) //Limita los días disponibles
                .build()

            // Muestra el selector de fechas
            datePicker.show(supportFragmentManager, "MATERIAL_DATE_PICKER")

            // Maneja la selección de la fecha
            datePicker.addOnPositiveButtonClickListener { _ ->
                binding.dateEditText.setText(datePicker.headerText)
            }
        }

        // Hora de emisión de la película

        binding.timeEditText.setOnClickListener {
            val horasDisponibles = peliculaSeleccionada.horaList

            // Convierte las horas a un formato legible (HH:mm).
            val timeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
            val horasString = horasDisponibles.map { timeFormat.format(it.time) }

            // Usa un diálogo para mostrar las horas como una lista.
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Selecciona una hora")
            builder.setItems(horasString.toTypedArray()) { _, which ->
                binding.timeEditText.setText(horasString[which]) // Muestra la hora seleccionada.
            }
            builder.show()
        }


        // Fecha de nacimiento

        binding.birthDateEditText.setOnClickListener {

            // Crea el selector de fechas
            val datePicker = MaterialDatePicker.Builder.datePicker()
                .setTitleText("Selecciona una fecha")
                .build()

            // Muestra el selector de fechas
            datePicker.show(supportFragmentManager, "MATERIAL_DATE_PICKER")

            // Maneja la selección de la fecha
            datePicker.addOnPositiveButtonClickListener { selection ->

                val selectedDate = Date(selection)

                val dateFormat = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())

                binding.birthDateEditText.setText(dateFormat.format(selectedDate))
            }
        }

        binding.crearReserva.setOnClickListener {

            // Validar que todos los campos estén llenos

            val nombre = binding.editTextText.text.toString().trim()
            val apellido = binding.apellidoTextText.text.toString().trim()
            val fechaNacimiento = binding.birthDateEditText.text.toString().trim()
            val email = binding.emailEditText.text.toString().trim()
            val fechaReserva = binding.dateEditText.text.toString().trim()
            val horaReserva = binding.timeEditText.text.toString().trim()
            val tituloPelicula = peliculaSeleccionada.titulo

            if (nombre.isEmpty() || apellido.isEmpty() || fechaNacimiento.isEmpty() ||
                email.isEmpty() || fechaReserva.isEmpty() || horaReserva.isEmpty() || tituloPelicula.isEmpty()
            ) {
                Toast.makeText(this, "Por favor, completa todos los campos.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            Toast.makeText(this, "Reserva creada con éxito.", Toast.LENGTH_SHORT).show()

            // Crear objeto de reserva

            val reserva = Reservas(
                imagenPelicula = peliculaSeleccionada.verticalImagen,
                fecha = fechaReserva,
                hora = horaReserva,
                nombrePelicula = tituloPelicula,
                nombre = nombre,
                apellido = apellido,
                fechaNacimiento = fechaNacimiento,
                email = email
            )

            reservaViewModel.setReserva(reserva)
        }
    }
}