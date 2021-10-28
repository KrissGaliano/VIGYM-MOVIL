package pe.edu.tecsup.ViGym.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import pe.edu.tecsup.ViGym.Cursos
import pe.edu.tecsup.ViGym.R
import pe.edu.tecsup.ViGym.clases.Profesor

class ListadoAdapter : RecyclerView.Adapter<ListadoAdapter.MyViewHolder>() {

    var listener : SelectCurso ?= null
    // declaramos los elementos de la vista
    private var nombre : TextView?= null
    private var descripcion : TextView?= null
    private var sesion : TextView?= null
    private var capacidad : TextView?= null
    private var precio : TextView?= null
    private lateinit var container : CardView
    var list = ArrayList<Cursos>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    inner class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)

    // se crea el prototipo
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_listado,
                parent,false
            )
        )
    }

    // se manipula el prototipo
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        nombre = holder.itemView.findViewById(R.id.textNombre)
        descripcion  = holder.itemView.findViewById(R.id.textDescripcion)
        sesion = holder.itemView.findViewById(R.id.textSesiones)
        capacidad = holder.itemView.findViewById(R.id.textCapacidad)
        precio = holder.itemView.findViewById(R.id.textPrecio)
        container = holder.itemView.findViewById(R.id.containerCurso)
        nombre!!.text = list[position].nombre
        descripcion!!.text  = list[position].descripcion
        sesion!!.text = list[position].sesiones.toString()
        capacidad!!.text = list[position].capacidad.toString()
        precio!!.text = list[position].precio.toString()

        container.setOnClickListener {
            listener?.onClick(list[position])
        }
    }

    override fun getItemCount() = list.size

}

interface SelectCurso{
    fun onClick(curso :Cursos)
}