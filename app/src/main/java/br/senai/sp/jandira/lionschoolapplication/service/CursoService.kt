package br.senai.sp.jandira.lionschoolapplication.service

import br.senai.sp.jandira.lionschoolapplication.model.ListAlunos
import br.senai.sp.jandira.lionschoolapplication.model.ListCursos
import br.senai.sp.jandira.lionschoolapplication.model.ListDisciplinas
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CursoService {

    @GET("cursos")
    fun getCursos(): Call<ListCursos>

    @GET("alunos")
    fun getAlunos(@Query("curso") curso: String?): Call<ListAlunos>

    @GET("alunos")
    fun getAlunosByStatus(@Query("curso") curso: String?, @Query("status") status: String?): Call<ListAlunos>

    @GET("alunos-disciplinas")
    fun getInfoAluno(@Query("matricula") matricula: String?): Call<ListDisciplinas>

}
