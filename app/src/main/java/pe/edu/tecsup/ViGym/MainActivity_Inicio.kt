package pe.edu.tecsup.ViGym

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import pe.edu.tecsup.ViGym.fragments.FavoritosFragment
import pe.edu.tecsup.ViGym.fragments.HomeFragment
import pe.edu.tecsup.ViGym.fragments.ListaDeseosFragment
import pe.edu.tecsup.ViGym.fragments.PerfilFragment

class MainActivity_Inicio : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_inicio)
        val btnShopping = findViewById<Button>(R.id.shoppin)
        val lista = findViewById<FloatingActionButton>(R.id.fab)


        val btnNav = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        setFragment(HomeFragment())
        btnNav.setOnNavigationItemSelectedListener { item ->  // using lamda
            onNavigationItemSelected(item) //call here
            true
        }

        btnShopping.setOnClickListener {
            val shopping = Intent(this, CarritoActivity::class.java)
            startActivity(shopping)
        }

        lista.setOnClickListener {
            val listado = Intent(this, ListaCursosActivity::class.java)
            startActivity(listado)

        }


    }


    fun onNavigationItemSelected(item: MenuItem) {
        when (item.itemId) {
            R.id.miHome -> {
                setFragment(HomeFragment())
            }

            R.id.miReceip -> {
                setFragment(FavoritosFragment())
            }

            R.id.miStar -> {
                setFragment(ListaDeseosFragment())

            }

            R.id.miProfile -> {
                setFragment(PerfilFragment())
            }
        }
    }


    private fun setFragment(fragment: Fragment) {
        this.supportFragmentManager.beginTransaction().replace(
            R.id.fragmentContainer,
            fragment
        ).addToBackStack(null).commit()
    }


}
