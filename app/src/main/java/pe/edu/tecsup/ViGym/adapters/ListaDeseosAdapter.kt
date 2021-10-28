package pe.edu.tecsup.ViGym.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pe.edu.tecsup.ViGym.Cursos
import pe.edu.tecsup.ViGym.R

class ListaDeseosAdapter : RecyclerView.Adapter<ListaDeseosAdapter.MyViewHolder>(){
    var listener : SelectCurso ?= null


    private lateinit var curso : TextView
    private lateinit var profesor : TextView
    private lateinit var horario : TextView
    private lateinit var precio : TextView
    private lateinit var btnComprarDeseo : ImageView
    var list = ArrayList<Cursos>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    inner class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_lista_deseos,
                parent,false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        curso = holder.itemView.findViewById(R.id.textCursoDeseo)
        profesor  = holder.itemView.findViewById(R.id.textProfesorDeseo)
        horario = holder.itemView.findViewById(R.id.textHorarioDeseo)
        precio = holder.itemView.findViewById(R.id.textPrecioDeseo)
        curso.text  = list[position].nombre
        profesor.text  = list[position].selectedProfesor!!.nombre
        precio.text = list[position].precio.toString()
        btnComprarDeseo =holder.itemView.findViewById(R.id.btnComprarDeseos)


        btnComprarDeseo.setOnClickListener {
            listener?.onClick(list[position])
        }
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


