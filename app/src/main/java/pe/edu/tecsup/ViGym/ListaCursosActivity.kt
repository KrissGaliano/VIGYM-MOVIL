package pe.edu.tecsup.ViGym

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import pe.edu.tecsup.ViGym.adapters.ListadoAdapter
import pe.edu.tecsup.ViGym.adapters.SelectCurso
import pe.edu.tecsup.ViGym.clases.Profesor


class ListaCursosActivity : AppCompatActivity() {

    private lateinit var rvListaFrases: RecyclerView

    private var adapterListaFrases = ListadoAdapter()

    var listFrases = ArrayList<Cursos>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_cursos)

        setView()
        setAdapter()
        getListaCursos()
        setListener()
    }

    private fun setListener() {
        adapterListaFrases.listener = object : SelectCurso {
            override fun onClick(curso: Cursos) {
                val intent = Intent(this@ListaCursosActivity, CursoDetailActivity::class.java)
                intent.putExtra("curso", curso)
                startActivity(intent)
            }
        }
    }

    private fun setView() {
        rvListaFrases = findViewById(R.id.rvListaFrases)
    }

    private fun setAdapter() {
        adapterListaFrases.list = listFrases
        rvListaFrases.adapter = adapterListaFrases
    }

    private fun getListaCursos() {

        var retrofit = RetrofitHelper.getRetrofit()

        var listdeCurso = retrofit.create(ApiClient::class.java).getList().subscribeOn(
            Schedulers.io()
        ).observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                adapterListaFrases.list = response
            }, { error ->

                adapterListaFrases.list = arrayListOf(
                    Cursos("0",
                        "Baile",
                        "Musica moderna",
                        10,
                        35,
                        40,
                        100,
                        false,
                        0,
                        "",
                        "",
                        null,
                    arrayListOf(
                        Profesor(1,"Juan", false),
                        Profesor(2,"Maria", false),
                        Profesor(3,"Jose", false),
                        )),
                    Cursos("1",
                        "Yoga",
                        "Relax",
                        10,
                        35,
                        40,
                        100,
                        false,
                        0,
                        "",
                        "",
                        null,
                        arrayListOf(
                            Profesor(1,"Martin", false),
                            Profesor(2,"Paco", false),
                            Profesor(3,"Julia", false),
                        )),
                )
                Toast.makeText(this, error.message.toString(), Toast.LENGTH_LONG).show()
            })
    }
}