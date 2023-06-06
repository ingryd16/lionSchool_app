package br.senai.sp.jandira.lionschoolapplication.service

import br.senai.sp.jandira.lionschoolapplication.model.Curso
import br.senai.sp.jandira.lionschoolapplication.model.ListaCursos
import retrofit2.Call
import retrofit2.http.GET

interface CursoService {
    @GET("cursos")
    fun getCursos(): Call<ListaCursos>
}
