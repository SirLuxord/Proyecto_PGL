package com.example.cine

import android.content.Intent
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

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
}