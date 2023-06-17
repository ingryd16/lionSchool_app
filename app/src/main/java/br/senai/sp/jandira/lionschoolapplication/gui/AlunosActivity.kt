package br.senai.sp.jandira.lionschoolapplication.gui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.lionschoolapplication.R
import br.senai.sp.jandira.lionschoolapplication.model.ListAlunos
import br.senai.sp.jandira.lionschoolapplication.service.RetrofitFactory
import br.senai.sp.jandira.lionschoolapplication.ui.theme.LionSchoolApplicationTheme
import coil.compose.AsyncImage
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AlunosActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LionSchoolApplicationTheme {
                AlunosScreen(intent.extras?.getString("sigla"),intent.extras?.getString("titulo"))
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
@Preview
fun AlunosScreen(curso : String?,titulo : String?) {

    val context = LocalContext.current
    var alunos by remember {
        mutableStateOf(listOf<br.senai.sp.jandira.lionschoolapplication.model.Alunos>())
    }

    //chamada pra API
    val call = RetrofitFactory().getCursosService().getAlunos(curso)

    call.enqueue(object : Callback<ListAlunos> {
        override fun onResponse(
            call: Call<ListAlunos>,
            response: Response<ListAlunos>
        ) {
            alunos = response.body()!!.alunos
        }

        override fun onFailure(call: Call<ListAlunos>, t: Throwable) {
            Log.i("ds2m", "onFailure: $t")
        }

    })

    Log.i("ds2m", "$alunos")
        Column(modifier = Modifier
            .fillMaxSize()
            .background(Color.White))
        {
            Card(
                modifier = Modifier
                    .height(height = 250.dp)
                    .fillMaxWidth()
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .height(120.dp),
                    shape = RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp),
                ) {

                    Column(
                        modifier = Modifier
                            .background(Color(51, 71, 176))
                            .fillMaxWidth(),
                        Arrangement.Center, Alignment.CenterHorizontally
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(30.dp),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = titulo.toString(),
                                textAlign = TextAlign.Center,
                                fontSize = 30.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                textDecoration = TextDecoration.Underline
                            )
                        }
                    }
                }
            }


            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.padding(27.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.circlea),
                        contentDescription = "",
                        Modifier.size(10.dp)
                    )

                    Spacer(modifier = Modifier.width(5.dp))

                    Text(
                        text = "Finalizado",
                        textAlign = TextAlign.Center,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(229,182,87),
                    )

                    Spacer(modifier = Modifier.width(20.dp))

                    Image(
                        painter = painterResource(id = R.drawable.circleb),
                        contentDescription = "",
                        Modifier.size(10.dp)
                    )

                    Spacer(modifier = Modifier.width(5.dp))
                    
                    Text(
                        text = "Cursando",
                        textAlign = TextAlign.Center,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(51,71,176),
                    )
                }


                LazyColumn(
                    content = {
                        items(alunos) {
                            Card(
                                onClick = {
                                    val intent = Intent(context, AlunoActivity::class.java)
                                    intent.putExtra("matricula", it.matricula)
                                    intent.putExtra("foto", it.foto)
                                    intent.putExtra("nome", it.nome)
                                    context.startActivity(intent)
                                },
                                modifier = Modifier
                                    .height(100.dp)
                                    .fillMaxWidth()
                                    .padding(20.dp, 0.dp),
                                shape = RoundedCornerShape(20.dp),
                                backgroundColor = if (it.status == "Cursando") Color(
                                    51,
                                    71,
                                    176
                                ) else Color(229, 182, 87),

                                ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.Center
                                ) {
                                    AsyncImage(
                                        modifier = Modifier.size(80.dp),
                                        model = it.foto, contentDescription = "AVATAR"
                                    )
                                    Spacer(modifier = Modifier.width(20.dp))
                                    Text(
                                        modifier = Modifier.width(180.dp),
                                        text = it.nome.uppercase(),
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Black,
                                        color = Color.White,
                                    )

                                }
                            }
                            Spacer(modifier = Modifier.height(20.dp))
                        }
                    }
                )
            }
        }

}




