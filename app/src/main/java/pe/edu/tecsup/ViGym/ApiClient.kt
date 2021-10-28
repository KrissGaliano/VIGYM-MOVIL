package pe.edu.tecsup.ViGym

import io.reactivex.Observable
import retrofit2.http.GET

interface ApiClient {
    @GET("/.json")
    fun getList() : Observable<Lista_Cursos>

    @GET("lista")
    fun getListCursos() : Observable<ArrayList<Cursos>>

}