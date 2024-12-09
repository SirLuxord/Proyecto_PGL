package com.example.cine

import android.content.Intent
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

abstract class BaseActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView

    // Toolbar

    protected fun setupToolbar(toolbar: androidx.appcompat.widget.Toolbar, title: String) {
        setSupportActionBar(toolbar)
        supportActionBar?.title = title
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.list_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.peliculasListItem -> {
                startActivity(Intent(this, MainActivity::class.java))
                true
            }
            R.id.crearReservaItem -> {
                startActivity(Intent(this, ReservaActivity::class.java))
                true
            }
            R.id.reservaListItem -> {
                startActivity(Intent(this, ListaReservasActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    // NavigationDrawe

    protected fun setupNavigationDrawer(drawerLayout: DrawerLayout, navigationView: NavigationView) {
        this.drawerLayout = drawerLayout
        this.navigationView = navigationView

        navigationView.setNavigationItemSelectedListener(this)
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_theme -> {
                // Cambiar tema
                cambiarTema()
            }
            R.id.nav_aboutUs -> {
                // Mostrar información sobre CineApp
                mostrarAcercaDe()
            }
            R.id.nav_exit -> {
                // Cerrar aplicación
                salirAplicacion()
            }
        }
        drawerLayout.closeDrawers()
        return true
    }

    private fun cambiarTema() {

        val currentMode = AppCompatDelegate.getDefaultNightMode()
        if (currentMode == AppCompatDelegate.MODE_NIGHT_YES) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)  // Cambiar a modo claro
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)  // Cambiar a modo oscuro
        }

    }

    private fun mostrarAcercaDe() {
        val message = """
        CineApp es una aplicación diseñada para los amantes del cine. En la pantalla principal encontrarás la cartelera con todas las películas disponibles. Al seleccionar una película, podrás ver información más detallada sobre ella.
        
        En la barra de herramientas (Toolbar), puedes navegar entre las diferentes funcionalidades de la aplicación:
        
        - **Crear reservas:** Puedes crear tu propia reserva para una película. Estas reservas se guardarán en la sección "Lista de Reservas" hasta que decidas eliminarlas.
        
        - **Lista de Reservas:** Aquí encontrarás todas tus reservas almacenadas y podrás eliminarlas cuando lo desees.
        
        - **Tema:** Cambia entre el modo claro y oscuro según tu preferencia.
        
        ¡Disfruta explorando y organizando tus experiencias cinematográficas con CineApp!
    """.trimIndent()

        AlertDialog.Builder(this)
            .setTitle("Acerca de CineApp")
            .setMessage(message)
            .setPositiveButton("Cerrar") { dialog, _ -> dialog.dismiss() }
            .create()
            .show()
    }

    private fun salirAplicacion() {
        finishAffinity()
        System.exit(0)
    }

}