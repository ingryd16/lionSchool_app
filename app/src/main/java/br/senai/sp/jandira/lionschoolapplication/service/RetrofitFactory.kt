package br.senai.sp.jandira.lionschoolapplication.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {

    private val URLBASE = "https://lion-school-api-ingryd.cyclic.app/v1/lion-school/"

//    guarda a conexão com o servidor, devolve a conexão
    private val retrofitFactory = Retrofit
        .Builder()
        .baseUrl(URLBASE)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getCursoService(): CursoService {
        return retrofitFactory.create(CursoService::class.java)
    }
}