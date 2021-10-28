package pe.edu.tecsup.ViGym

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

object RetrofitHelper {
    fun getRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://pigoshvigymivtecsup-env.eba-7mmzkvdh.us-east-2.elasticbeanstalk.com/vigym/api/curso/")
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }
}
