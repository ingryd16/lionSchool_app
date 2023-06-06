package br.senai.sp.jandira.lionschoolapplication.model

data class Curso (
    val nome: String,
    val sigla: String,
    val icone: String,
    val carga: Long,
    val conclusao: Long,
    val disciplinas: List<Disciplinas>
)