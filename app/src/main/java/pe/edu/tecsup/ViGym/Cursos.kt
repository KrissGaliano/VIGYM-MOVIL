package pe.edu.tecsup.ViGym

import pe.edu.tecsup.ViGym.clases.Profesor
import java.io.Serializable


class Cursos (
    var id: String,
    var nombre: String,
    var descripcion: String,
    var sesiones: Int,
    var capacidad: Int,
    var precio: Int,
    var calorias_perdidas: Int,
    var selected : Boolean = false,
    var horarioSelected : Int = 1, // como los horarios seran fijos 1= 8 a 10, 2 = 10 a 12.. etc
    var author : String,
    var quote : String,

    var selectedProfesor :Profesor?= null,
    var listProfesores : ArrayList<Profesor>
): Serializable