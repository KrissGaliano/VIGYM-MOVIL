package pe.edu.tecsup.ViGym

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text
import pe.edu.tecsup.ViGym.adapters.ProfesoresAdapter
import pe.edu.tecsup.ViGym.adapters.SelectHorario
import pe.edu.tecsup.ViGym.clases.Profesor

class CursoDetailActivity : AppCompatActivity() {

    private lateinit var rvProfesores : RecyclerView
    private lateinit var nombreCurso : TextView
    private  lateinit var descripcionCurso : TextView
    private lateinit var btnListaDeseos : Button
    private lateinit var btnCarrito : Button

    private var adapterProfesores = ProfesoresAdapter()

    private lateinit var curso : Cursos
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        curso = intent.getSerializableExtra("curso") as Cursos
        setContentView(R.layout.activity_curso_detail)
        setView()
        setAdapter()
        setListener()
    }

    private fun setListener() {
        adapterProfesores.listener = object : SelectHorario {
            override fun onClick(profesor: Profesor, horario: Int) {
                curso.listProfesores.forEach { item ->
                    if( item.id == profesor.id) {
                        item.selected = true
                        curso.selectedProfesor =  profesor
                    } else {
                        item.selected = false
                    }
                }

                curso.horarioSelected = horario

                adapterProfesores.list = curso.listProfesores


            }
        }

        btnCarrito.setOnClickListener {
            if( curso.selectedProfesor != null) {
                // anadir al carrito
                var select = false
                carrito.forEach { item->
                    if(curso.id == item.id && curso.horarioSelected == item.horarioSelected ) {
                        select = true
                    }
                }
                if(!select) {
                    carrito.add(curso)
                    Toast.makeText(this,"Se agrego correctamente al carrito.",Toast.LENGTH_LONG).show()

                } else {
                    Toast.makeText(this,"El curso seleccionado ya esta en el carrito.",Toast.LENGTH_LONG).show()

                }
                this.finish()
            } else{
                Toast.makeText(this,"Seleccione una opcion.",Toast.LENGTH_LONG).show()
            }
        }

        btnListaDeseos.setOnClickListener {
            if( curso.selectedProfesor != null) {
                // anadir al carrito
                var select = false
                listDeseos.forEach { item->
                    if(curso.id == item.id && curso.horarioSelected == item.horarioSelected ) {
                        select = true
                    }
                }
                if(!select) {
                    listDeseos.add(curso)
                    Toast.makeText(this,"Se agrego correctamente a la Lista de Deseos.",Toast.LENGTH_LONG).show()

                } else {
                    Toast.makeText(this,"El curso seleccionado ya esta en la Lista de deseos.",Toast.LENGTH_LONG).show()

                }
                this.finish()
            } else{
                Toast.makeText(this,"Seleccione una opcion.",Toast.LENGTH_LONG).show()
            }
        }
    }


    private fun setAdapter() {
        adapterProfesores.list = curso.listProfesores
        rvProfesores.adapter = adapterProfesores
    }

    private fun setView() {
        rvProfesores = findViewById(R.id.rvProfesores)
        nombreCurso = findViewById(R.id.textCursoNombre)
        descripcionCurso = findViewById(R.id.textDescripcionCurso)
        btnCarrito = findViewById(R.id.btnCarrito)
        btnListaDeseos = findViewById(R.id.btnListaDeseos)


        nombreCurso.text = curso.nombre
        descripcionCurso.text = curso.descripcion

    }
}