package br.senai.sp.jandira.lionschoolapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.lionschoolapplication.ui.theme.LionSchoolApplicationTheme

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
    //COLUNA PRINCIPAL
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(51, 71, 176)),
    )
    {
        // ROW 1: INFO ICON //
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(10.dp),
            horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.info_24),
                contentDescription = null,
            )
        }


        //ROW 2: LOGO IMAGE//
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(320.dp),
            horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.Bottom
        ) {
            Image(painter = painterResource(id = R.drawable.logo2), contentDescription = "")
        }


        //COLUMN 3: TEXTS//
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = stringResource(id = R.string.name),
                fontSize = 60.sp,
                fontWeight = FontWeight(800),
                color = Color.White,
                modifier = Modifier.height(80.dp)
            )
            Text(
                text = stringResource(id = R.string.since),
                fontSize = 16.sp,
                fontWeight = FontWeight(800),
                color = Color.White,
            )
            Text(
                text = stringResource(id = R.string.transforming),
                fontSize = 16.sp,
                fontWeight = FontWeight(800),
                color = Color.White
            )
        }


        //ROW 4: BUTTON//
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp),
            horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.Bottom
        ) {
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .width(120.dp)
                    .height(30.dp),
                colors = ButtonDefaults.buttonColors(Color.White),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.started),
                    fontWeight = FontWeight(800),
                    fontSize = 12.sp,
                    color = Color(51,71,176)
                )
            }
        }
    }
}