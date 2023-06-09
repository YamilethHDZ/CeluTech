package com.example.celutech

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import com.example.celutech.R.id

open class MainActivity : AppCompatActivity() {

    private lateinit var buttonAlert: Button
    private lateinit var builder: AlertDialog.Builder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
}