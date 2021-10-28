package pe.edu.tecsup.ViGym.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import pe.edu.tecsup.ViGym.Cursos
import pe.edu.tecsup.ViGym.R
import pe.edu.tecsup.ViGym.adapters.ListaDeseosAdapter
import pe.edu.tecsup.ViGym.adapters.SelectCurso
import pe.edu.tecsup.ViGym.adapters.SelectHorario
import pe.edu.tecsup.ViGym.carrito
import pe.edu.tecsup.ViGym.clases.Profesor
import pe.edu.tecsup.ViGym.listDeseos


class ListaDeseosFragment : Fragment() {

    private var listDeseosAdapter = ListaDeseosAdapter()
    private lateinit var rvDeseos : RecyclerView
    private lateinit var refreshList : SwipeRefreshLayout
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_lista_deseos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setview()
        setAdapter()
        setListeners()
    }

    private fun setListeners() {
        refreshList.setOnRefreshListener {
            listDeseosAdapter.list = listDeseos
            refreshList.isRefreshing = false

        }

        listDeseosAdapter.listener = object : SelectCurso {
            override fun onClick(curso: Cursos) {
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
                        Toast.makeText(requireContext(),"Se agrego correctamente al carrito.", Toast.LENGTH_LONG).show()

                    } else {
                        Toast.makeText(requireContext(),"El curso seleccionado ya esta en el carrito.", Toast.LENGTH_LONG).show()

                    }

                    for( i in 0 until listDeseos.size) {
                        if(curso.id == listDeseos[i].id) {
                            listDeseos.removeAt(i)
                            listDeseosAdapter.list = listDeseos
                            break
                        }
                    }
                }
            }
        }
    }

    private fun setAdapter() {
        listDeseosAdapter.list = listDeseos
        rvDeseos.adapter = listDeseosAdapter
    }

    private fun setview() {
        rvDeseos = requireActivity().findViewById(R.id.rvListDeseos)
        refreshList = requireActivity().findViewById(R.id.refreshDeseos)
    }

    override fun onResume() {
        super.onResume()
        Log.d("aca","apareci")

    }
}