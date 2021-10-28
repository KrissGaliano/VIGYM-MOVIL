package pe.edu.tecsup.ViGym

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import pe.edu.tecsup.ViGym.adapters.CarritoAdapter

class CarritoActivity : AppCompatActivity() {

    private var carritoAdapter= CarritoAdapter()
    private lateinit var rvCarrito : RecyclerView
    private lateinit var totalCarrito : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)
        setView()
        setAdapter()
    }

    private fun setView() {
        rvCarrito = findViewById(R.id.rvCarrito)
        totalCarrito = findViewById(R.id.textTotalCarrito)

        var total = 0
        carrito.forEach {
            total+= it.precio
        }

        totalCarrito.text = total.toString()
    }

    private fun setAdapter() {
        carritoAdapter.list = carrito
        rvCarrito.adapter  = carritoAdapter
    }
}