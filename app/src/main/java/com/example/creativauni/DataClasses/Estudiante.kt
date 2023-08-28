package com.example.creativauni.DataClasses

import java.io.Serializable

data class Estudiante( var codigoEstudiante: String,
                       var correoEstudiante: String,
                       var idEstudiante: Int,
                       var primerApellidoEstudiante: String,
                       var primerNombreEstudiante: String,
                       var segundoApellidoEstudiante: String,
                       var segundoNombreEstudiante: String
) : Serializable
