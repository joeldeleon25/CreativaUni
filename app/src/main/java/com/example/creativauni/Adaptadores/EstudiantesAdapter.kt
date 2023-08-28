package com.example.creativauni.Adaptadores

import android.app.AlertDialog
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.creativauni.DataClasses.Estudiante
import com.example.creativauni.EditarEstudianteActivity
import com.example.creativauni.R

class EstudianteAdapter(private val estudiantes: MutableList<Estudiante>) :
    RecyclerView.Adapter<EstudianteAdapter.EstudianteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EstudianteViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_estudiante, parent, false)
        return EstudianteViewHolder(view)
    }


    override fun onBindViewHolder(holder: EstudianteViewHolder, position: Int) {
        val estudiante = estudiantes[position]
        holder.bind(estudiante)
    }

    override fun getItemCount(): Int {
        return estudiantes.size
    }

    inner class EstudianteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val CodigoEstudiante: TextView = itemView.findViewById(R.id.CodigoEstudiante)
        private val CorreoEstudiante: TextView = itemView.findViewById(R.id.CorreoEstudiante)
        private val PrimerApellidoEstudiante: TextView = itemView.findViewById(R.id.PrimerApellidoEstudiante)
        private val PrimerNombreEstudiante: TextView = itemView.findViewById(R.id.PrimerNombreEstudiante)
        private val segundoApellidoEstudiante: TextView = itemView.findViewById(R.id.segundoApellidoEstudiante)
        private val segundoNombreEstudiante: TextView = itemView.findViewById(R.id.segundoNombreEstudiante)

        init {
            itemView.setOnLongClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val alertDialog = AlertDialog.Builder(itemView.context)
                    alertDialog.setTitle("Eliminar Estudiante")
                    alertDialog.setMessage("¿Estás seguro que deseas eliminar este estudiante?")
                    alertDialog.setPositiveButton("Sí") { _, _ ->
                        // Eliminar el elemento de la lista y notificar al adaptador
                        estudiantes.removeAt(position)
                        notifyItemRemoved(position)
                    }
                    alertDialog.setNegativeButton("No") { _, _ ->
                    }
                    alertDialog.show()
                }
                true
            }

            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val context = itemView.context
                    val intent = Intent(context, EditarEstudianteActivity::class.java)
                    intent.putExtra("estudiante", estudiantes[position])
                    context.startActivity(intent)
                }
            }
        }

        fun bind(estudiante: Estudiante) {
            CodigoEstudiante.text = estudiante.codigoEstudiante
            CorreoEstudiante.text = "correo: ${estudiante.correoEstudiante}"
            PrimerApellidoEstudiante.text = "Primer Apellido: ${estudiante.primerApellidoEstudiante}"
            PrimerNombreEstudiante.text = "Primer Nombre: ${estudiante.primerNombreEstudiante}"
            segundoApellidoEstudiante.text = "Segundo Apellido: ${estudiante.segundoApellidoEstudiante}"
            segundoNombreEstudiante.text = "Segundo Nombre: ${estudiante.segundoNombreEstudiante}"
        }
    }

}
