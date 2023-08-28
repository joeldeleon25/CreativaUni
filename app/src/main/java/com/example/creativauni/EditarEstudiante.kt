package com.example.creativauni

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.MenuItem
import android.widget.EditText
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.creativauni.DataClasses.Estudiante

class EditarEstudianteActivity : AppCompatActivity() {

    private lateinit var CodigoEstudiante: TextView
    private lateinit var editTextPrimerNombreEstudiante : TextView
    private lateinit var editTextCorreoEstudiante: EditText
    private lateinit var buttonGuardarCambios : Button
    private lateinit var editTextPrimerApellidoEstudiante : EditText
    private lateinit var editTextsegundoApellidoEstudiante : EditText
    private lateinit var editTextsegundoNombreEstudiante : EditText
    private var estudiantePosition: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar_estudiante)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val estudiante = intent.getSerializableExtra("estudiante") as? Estudiante
        estudiantePosition = intent.getIntExtra("position", -1)

        if (estudiante != null) {
            CodigoEstudiante = findViewById(R.id.CodigoEstudiante)
            editTextCorreoEstudiante = findViewById(R.id.CorreoEstudiante)
            editTextPrimerNombreEstudiante =  findViewById(R.id.PrimerNombreEstudiante)
            editTextPrimerApellidoEstudiante = findViewById(R.id.PrimerApellidoEstudiante)
            editTextsegundoApellidoEstudiante = findViewById(R.id.segundoApellidoEstudiante)
            editTextsegundoNombreEstudiante = findViewById(R.id.segundoNombreEstudiante)

            CodigoEstudiante.setText(estudiante.codigoEstudiante)
            editTextCorreoEstudiante.setText(estudiante.correoEstudiante)
            editTextPrimerApellidoEstudiante.setText(estudiante.primerApellidoEstudiante)
            editTextPrimerNombreEstudiante.setText(estudiante.primerNombreEstudiante)
            editTextsegundoApellidoEstudiante.setText(estudiante.segundoApellidoEstudiante)
            editTextsegundoNombreEstudiante.setText((estudiante.segundoNombreEstudiante))

        }

        //val buttonGuardarCambios = findViewById<Button>(R.id.buttonGuardarCambios)
        buttonGuardarCambios = findViewById(R.id.buttonGuardarCambios)
        buttonGuardarCambios.setOnClickListener {
            if (estudiante != null) {
                estudiante.correoEstudiante = editTextCorreoEstudiante.text.toString()

                val resultIntent = Intent()
                resultIntent.putExtra("estudiante_actualizado", estudiante)
                resultIntent.putExtra("position", estudiantePosition)
                setResult(Activity.RESULT_OK, resultIntent)

                Toast.makeText(this, "Cambios guardados", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
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
