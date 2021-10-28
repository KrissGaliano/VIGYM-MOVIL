package pe.edu.tecsup.ViGym.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.core.view.get
import androidx.recyclerview.widget.RecyclerView
import pe.edu.tecsup.ViGym.R
import pe.edu.tecsup.ViGym.clases.Profesor

class ProfesoresAdapter: RecyclerView.Adapter<ProfesoresAdapter.MyViewHolder>(){

    var listener : SelectHorario  ?= null
    private var lastCheckedRB : RadioButton ?= null
    private var lastCheckedRadioGroup : RadioGroup ?= null

    private lateinit var profesor : TextView
    private lateinit var groupHorarios : RadioGroup
    private lateinit var btnRadio1 : RadioButton
    private lateinit var btnRadio2 : RadioButton
    private lateinit var btnRadio3 : RadioButton

    var list = ArrayList<Profesor>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    inner class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_horario_profesor,
                parent,false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        profesor = holder.itemView.findViewById(R.id.txtProfesor)
        groupHorarios = holder.itemView.findViewById(R.id.groupHorarios)
        profesor.text = list[position].nombre

        /*btnRadio1 = holder.itemView.findViewById(R.id.radio1)
        btnRadio2 = holder.itemView.findViewById(R.id.radio2)
        btnRadio3 = holder.itemView.findViewById(R.id.radio3)*/


        groupHorarios.setOnCheckedChangeListener { group, checkedId ->

            if( lastCheckedRadioGroup != null && lastCheckedRadioGroup != group) {
                lastCheckedRadioGroup!!.clearCheck()
            }

            lastCheckedRadioGroup = group
            if( lastCheckedRadioGroup != null) {
                when(checkedId ) {
                    R.id.radio1->{
                        listener?.onClick(list[position],1)

                    }
                    R.id.radio2 -> {
                        listener?.onClick(list[position],2)

                    }
                    R.id.radio3 -> {
                        listener?.onClick(list[position],3)

                    }
                }
            }

        }


    }

    override fun getItemCount() = list.size

}

interface SelectHorario{
    fun onClick(profesor : Profesor, horario : Int)
}