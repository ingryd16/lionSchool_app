package br.senai.sp.jandira.lionschoolapplication.gui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.lionschoolapplication.R
import br.senai.sp.jandira.lionschoolapplication.ui.theme.LionSchoolApplicationTheme

class CoursesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LionSchoolApplicationTheme {
                CoursesPreview()
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun CoursesPreview() {
    //COLUNA PRINCIPAL
    Column(
        modifier = Modifier
            .fillMaxSize()
    )
    {
        // IMAGE AREA //
        Card(
            modifier = Modifier
                .height(height = 250.dp)
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

        Spacer(modifier = Modifier.height(30.dp))

        //RESTO
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            Arrangement.Center
        ) {
            Text(
                text = "Courses",
                color = Color(51, 71, 176),
                fontWeight = FontWeight.Bold,
                fontSize = 35.sp
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Column(
            modifier = Modifier
                .fillMaxSize(),
            Arrangement.Top,Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
            ) {
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .width(350.dp)
                        .height(130.dp),
                    colors = ButtonDefaults.buttonColors(Color.White),
                    border= BorderStroke(2.dp,Color(51, 71, 176)),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Text(
                        text = "RDS",
                        fontWeight = FontWeight(800),
                        fontSize = 25.sp,
                        color = Color(51, 71, 176)
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier
            ) {
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .width(350.dp)
                        .height(130.dp),
                    colors = ButtonDefaults.buttonColors(Color.White),
                    border= BorderStroke(2.dp,Color(51, 71, 176)),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Text(
                        text = "DS",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 25.sp,
                        color = Color(51, 71, 176)
                    )
                }
            }

        }
    }
}
