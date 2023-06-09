package com.example.celutech

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog


import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import com.example.celutech.R.id

class ventana_confir : AppCompatActivity() {

    private lateinit var buttonAlert: Button
    private lateinit var builder: AlertDialog.Builder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ventana_confir)

        //Continuacion del boton
        buttonAlert = findViewById(R.id.buttonAlert)

        builder = AlertDialog.Builder(this)

        buttonAlert.setOnClickListener{
            builder.setTitle("Eliminar")
                .setMessage("Esta seguro de Eliminar")
                .setCancelable(true)
                .setPositiveButton("Yes"){dialogInterface,it ->
                    finish()
                }
                .setNegativeButton("No"){dialogInterface, it ->
                    dialogInterface.cancel()
                }
                .show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.menucel, menu)
        return true


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.sms -> {
                Toast.makeText(this, "Marca SAMSUNG seleccionada", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.pho -> {
                Toast.makeText(this, "Marca iPhone seleccionada", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.xia -> {
                Toast.makeText(this, "Marca Xiaomi seleccionada", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }


    }
}