package br.senai.sp.jandira.lionschoolapplication.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {

    private val URL_BASE = "https://api-lion-school-gustavo.cyclic.app/v1/lion-school/"

//    guarda a conexão com o servidor, devolve a conexão
    private val retrofitFactory = Retrofit.Builder()
        .baseUrl(URL_BASE)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getCursosService(): CursoService{
        return retrofitFactory.create(CursoService::class.java)
    }
}