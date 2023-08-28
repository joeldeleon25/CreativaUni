package com.example.creativauni

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cardView1 = findViewById<CardView>(R.id.cardview1)
        cardView1.setOnClickListener {
            // Código para iniciar la nueva actividad
            val intent = Intent(this, EstudianteActivity::class.java)
            startActivity(intent)


        }

    }


}

