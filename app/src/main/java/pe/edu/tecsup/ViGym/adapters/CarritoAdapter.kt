package pe.edu.tecsup.ViGym.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pe.edu.tecsup.ViGym.Cursos
import pe.edu.tecsup.ViGym.R

class CarritoAdapter : RecyclerView.Adapter<CarritoAdapter.MyViewHolder>(){
    private lateinit var curso : TextView
    private lateinit var profesor : TextView
    private lateinit var horario : TextView
    private lateinit var precio : TextView

    var list = ArrayList<Cursos>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    inner class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_carrito,
                parent,false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        curso = holder.itemView.findViewById(R.id.textCursoCarrito)
        profesor  = holder.itemView.findViewById(R.id.textProfesorCarrito)
        horario = holder.itemView.findViewById(R.id.textHorarioCarrito)
        precio = holder.itemView.findViewById(R.id.textPrecioCarrito)

        curso.text  = list[position].nombre
        profesor.text  = list[position].selectedProfesor!!.nombre
        precio.text = list[position].precio.toString()


        when(list[position].horarioSelected) {
            1->{
                horario.text = "8:00 a 10:00 am"
            }
            2->{
                horario.text = "10:00 a 12:00 am"

            }
            3->{
                horario.text = "12:00 a 1:00 pm"

            }
        }
    }


    override fun getItemCount() = list.size

}