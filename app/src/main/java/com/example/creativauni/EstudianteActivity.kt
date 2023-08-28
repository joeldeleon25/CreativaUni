package com.example.creativauni

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.creativauni.Adaptadores.EstudianteAdapter
import com.example.creativauni.DataClasses.Estudiante

class EstudianteActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: EstudianteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estudiante)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val estudiantes = mutableListOf(
            Estudiante(
                "MD190790",
                "joel@gmail.com",
                1,
                "Martinez ",
                "Roberto",
                "Deleon",
                "Joel "
            ),

            Estudiante(
                "CD181916",
                "chacon@gmail.com",
                2,
                "Chacon",
                "Daniel",
                "Deleon",
                "Wilfredo"
            ),
            Estudiante(
                "RP180242",
                "Guadalupe@gmail.com",
                3,
                "Ramirez",
                "Guadalupe",
                "Hernanez",
                "Del Carmen"
            ),
            Estudiante(
                "MB190601",
                "Monica@gmail.com",
                3,
                "Bachez",
                "Monica",
                "Martinez",
                "Paola"
            )
        )



        recyclerView = findViewById(R.id.recyclerView)

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        adapter = EstudianteAdapter(estudiantes)
        recyclerView.adapter = adapter
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
