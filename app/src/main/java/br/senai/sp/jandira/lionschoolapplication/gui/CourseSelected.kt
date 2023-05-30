package br.senai.sp.jandira.lionschoolapplication.gui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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

class CourseSelectedActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LionSchoolApplicationTheme {
                CourseSelectedPreview()
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun CourseSelectedPreview() {
    //COLUNA PRINCIPAL
    Column(
        modifier = Modifier
            .fillMaxSize()
    )
    {
        Row(
            modifier = Modifier
                .height(300.dp)
                .fillMaxWidth()
                .background(Color.Yellow)
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                backgroundColor = Color.Red,
                shape = RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp)
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

