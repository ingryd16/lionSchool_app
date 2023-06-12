package br.senai.sp.jandira.lionschoolapplication.gui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.lionschoolapplication.R
import br.senai.sp.jandira.lionschoolapplication.model.ListCursos
import br.senai.sp.jandira.lionschoolapplication.service.RetrofitFactory
import br.senai.sp.jandira.lionschoolapplication.ui.theme.LionSchoolApplicationTheme
import coil.compose.AsyncImage
import okhttp3.internal.wait
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LionSchoolApplicationTheme {
                DefaultPreview()
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun DefaultPreview() {
    val context = LocalContext.current
    var cursos by remember {
        mutableStateOf(listOf<br.senai.sp.jandira.lionschoolapplication.model.Cursos>())
    }
    val call = RetrofitFactory().getCursosService().getCursos()

    call.enqueue(object : Callback<ListCursos> {
        override fun onResponse(
            call: Call<ListCursos>,
            response: Response<ListCursos>
        ) {
            cursos = response.body()!!.cursos
        }

        override fun onFailure(call: Call<ListCursos>, t: Throwable) {
            Log.i("ds2m", "onFailure: $t")
        }

    })
    Log.i("ds2m", " $cursos")

    Surface(//abrange tudo
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    )
    {
        Column(//coluna principal
            modifier = Modifier.fillMaxSize()
        )
        {
            Card(
                modifier = Modifier
                    .height(height = 200.dp)
                    .fillMaxWidth()
                    .background(Color(51, 71, 176)),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.quadruplo),
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )
            }

            //CARD COM TEXTS
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
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
                            .fillMaxWidth(),
                        Arrangement.Center
                    ) {
                        Text(
                            text = "Lion School is",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = "practice.",
                            color = Color(229, 182, 87),
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        Arrangement.Center
                    ) {
                        Text(
                            text = "Choose one course to",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = "start.",
                            color = Color(229, 182, 87),
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                    }
                }
            }


            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = R.string.cursos),
                    color = Color(51, 71, 176),
                    fontWeight = FontWeight.Black,
                    fontSize = 30.sp,
                    modifier = Modifier.padding(top=50.dp, bottom = 30.dp),
                    textDecoration = TextDecoration.Underline

                )
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    items(cursos) { curso ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp)
                                .clickable {
                                    val intent = Intent(context, AlunosActivity::class.java)
                                    intent.putExtra("sigla", curso.sigla)
                                    intent.putExtra("titulo", curso.nome)
                                    context.startActivity(intent)
                                },
                            shape = RoundedCornerShape(20.dp),
                            backgroundColor = Color.White,
                            border = BorderStroke(3.dp, Color(51, 71, 176))
                        ) {
                            Column(
                                modifier = Modifier.fillMaxSize(),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = curso.sigla,
                                    fontSize = 30.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(51, 71, 176),
                                )
                            }
                        }
                    }
                }
            }
        } //fim da coluna principal
    } //fim da surface

}