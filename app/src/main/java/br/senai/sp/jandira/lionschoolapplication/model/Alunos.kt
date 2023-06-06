package br.senai.sp.jandira.lionschoolapplication.model

data class Alunos (
    val foto: String,
    val nome: String,
    val matricula: Long,
    val sexo: String,
    val curso: List<Curso>,
    val status: String
)
    