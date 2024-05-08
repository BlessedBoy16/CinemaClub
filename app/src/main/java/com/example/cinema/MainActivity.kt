package com.example.cinema

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.cinema.ui.theme.CinemaTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CinemaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    mainContent()
                 }
            }
        }
    }
}

@Composable
fun mainContent() {
    LazyColumn {
        item {
            cinemaTitle(name = "Однажды на марсе")
        }
        item {
            poster(url = "https://upload.wikimedia.org/wikipedia/ru/6/67/The_Martian.jpg")
        }
         item {
             description(
                 text = "«Марсиа́нин» (англ. The Martian) — фильм режиссёра Ридли Скотта с Мэттом Деймоном в главной роли. " +
                         "Сценарий написан Дрю Годдардом по мотивам книги Энди Вейера «Марсианин». " +
                         "Сюжет, который разворачивается в недалёком будущем, " +
                         "рассказывает историю американского астронавта Марка Уотни, члена исследовательской экспедиции на Марс."
             )
         }
        item {
            button() }
    }
}

@Composable
fun cinemaTitle(name: String) {
    Text(
        text = name,
        modifier = Modifier
            .padding(16.dp,32.dp),
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.ExtraBold
        )
    )
}

@Composable
fun poster(url: String) {
    AsyncImage(
        model = url,
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth(1f)
            .padding(16.dp),
    )
}

@Composable
fun description(text: String){
    Text(
        text = text,
        modifier = Modifier
            .padding(16.dp),
        style = TextStyle(
            fontSize = 16.sp
        )
    )
}

@Composable
fun button(){
    Column(
        modifier = Modifier.fillMaxWidth().fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { /*TODO*/ }) {

            Text("Записаться")

        }
    }
}
