package br.senai.sp.jandira.lionschoolapplication.gui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.lionschoolapplication.model.ListDisciplinas
import br.senai.sp.jandira.lionschoolapplication.service.RetrofitFactory
import coil.compose.AsyncImage
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AlunoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlunoScreen(
                intent.extras?.getString("nome"),
                intent.extras?.getString("foto"),
                intent.extras?.getString("matricula")
            )
        }
    }
}


@Composable
fun AlunoScreen(nome :String?,foto :String?,matricula : String?) {

    var materias by remember {
        mutableStateOf(listOf<br.senai.sp.jandira.lionschoolapplication.model.Disciplinas>())
    }
    //Hamad para a API
    val call = RetrofitFactory().getCursosService().getInfoAluno(matricula)

    call.enqueue(object : Callback<ListDisciplinas> {
        override fun onResponse(
            call: Call<ListDisciplinas>,
            response: Response<ListDisciplinas>

        ) {
            Log.i("ds2m","$response")
            materias = response.body()!!.disciplinas

        }

        override fun onFailure(call: Call<ListDisciplinas>, t: Throwable) {
            Log.i("ds2m","onFailure: $t")
        }

    })
    Log.i("ds2m","$materias")

    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Informações do aluno:",
                    textAlign = TextAlign.Center,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(229, 182, 87),
                )
                AsyncImage(
                    modifier = Modifier.size(200.dp),
                    model = foto,
                    contentDescription = "logo"
                )
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = nome.toString(),
                    textAlign = TextAlign.Center,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(51,71,176),
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(243,244,248),
                        shape = RoundedCornerShape(30.dp, 30.dp, 0.dp, 0.dp)),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                LazyColumn(
                    content = {
                        items(materias) {
                            Column(
                                Modifier.padding(10.dp)
                            ) {
                                if (it.media.toInt() >= 70) {
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceBetween
                                    ) {

                                        Text(
                                            modifier = Modifier
                                                .padding(20.dp, 0.dp),
                                            text = it.nome,
                                            fontSize = 20.sp,
                                            fontWeight = FontWeight.Black,
                                            color = Color(51, 71, 176)
                                        )
                                        Text(
                                            modifier = Modifier
                                                .padding(20.dp, 5.dp),
                                            text = it.media,
                                            fontSize = 20.sp,
                                            fontWeight = FontWeight.Black,
                                            color = Color(51, 71, 176)
                                        )
                                    }
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(20.dp)
                                            .padding(20.dp, 0.dp)
                                            .background(Color(0, 0, 0, 25))
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .fillMaxWidth((it.media.toFloat() * 0.01).toFloat())
                                                .height(25.dp)
                                                .background(Color(51, 71, 176))
                                        ) {

                                        }
                                    }

                                } else if (it.media.toInt() in 50..69) {
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceBetween
                                    ) {

                                        Text(
                                            modifier = Modifier
                                                .padding(20.dp, 0.dp),
                                            text = it.nome,
                                            fontSize = 20.sp,
                                            fontWeight = FontWeight.Black,
                                            color = Color(229, 182, 87)
                                        )
                                        Text(
                                            modifier = Modifier
                                                .padding(20.dp, 5.dp),
                                            text = it.media,
                                            fontSize = 20.sp,
                                            fontWeight = FontWeight.Black,
                                            color = Color(229, 182, 87)
                                        )
                                    }
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(20.dp)
                                            .padding(20.dp, 0.dp)
                                            .background(Color(0, 0, 0, 25))
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .fillMaxWidth((it.media.toFloat() * 0.01).toFloat())
                                                .height(25.dp)
                                                .background(Color(229, 182, 87))
                                        )
                                    }

                                } else{
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceBetween
                                    ) {

                                        Text(
                                            modifier = Modifier
                                                .padding(20.dp, 0.dp),
                                            text = it.nome,
                                            fontSize = 20.sp,
                                            fontWeight = FontWeight.Black,
                                            color = Color(193, 16, 16)
                                        )
                                        Text(
                                            modifier = Modifier
                                                .padding(20.dp, 5.dp),
                                            text = it.media,
                                            fontSize = 20.sp,
                                            fontWeight = FontWeight.Black,
                                            color = Color(193, 16, 16)
                                        )
                                    }
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(20.dp)
                                            .padding(20.dp, 0.dp)
                                            .background(Color(0, 0, 0, 25))
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .fillMaxWidth((it.media.toFloat() * 0.01).toFloat())
                                                .height(25.dp)
                                                .background(Color(193, 16, 16))
                                        ) {

                                        }
                                    }

                                }

                                Spacer(modifier = Modifier.height(20.dp))
                            }

                        }
                    }
                )
            }
        }
    }
}
