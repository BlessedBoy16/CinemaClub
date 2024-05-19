package com.example.cinema

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.cinema.data.User
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
                    mainContent(users = listOf())
                 }
            }
        }
    }
}
@Composable
fun mainContent(users: List<User>) {
    var users by remember { mutableStateOf(users) }
    Column {
        LazyColumn {
            item {
                cinemaTitle(name = "Однажды на марсе")
            }
            item {
                poster(url = "https://avatars.mds.yandex.net/get-kinopoisk-image/1600647/e1f881aa-20c4-4fe5-b6dd-8b8b69c4e639/1920x")
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
                Column(modifier = Modifier
                    .fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally) {
                Button(onClick = {
                    users = users.toMutableList().also {
                        it.add(0, User(123, "123"))
                    }
                },
                    colors = ButtonDefaults.buttonColors(Color.DarkGray)) {
                    Text(text = "Записаться")
                        }
                    }
                }
            item {
                Text(
                    text = "Участники",
                    modifier = Modifier
                        .padding(16.dp, 32.dp, 0.dp, 0.dp)
                        .fillMaxWidth(),
                    style = TextStyle(
                        fontSize = 24.sp,
                    )
                )
            }
            item{
                LazyRow(modifier = Modifier
                    .padding(16.dp,24.dp)) {
                        items(users) {
                            user ->
                            Spacer(modifier = Modifier.width(4.dp))
                            PersonView(name = user.name)
                    }
                }
                Spacer(modifier = Modifier.height(32.dp))
            }
        }
    }
}


@Composable
fun cinemaTitle(name: String) {
    Text(
        text = name,
        modifier = Modifier
            .padding(16.dp,32.dp,0.dp,0.dp),
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.ExtraBold,
        )
    )
}

@Composable
fun poster(url: String) {
    AsyncImage(
        model = url,
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),

    )
}

@Composable
fun description(text: String){
    Text(
        text = text,
        modifier = Modifier
            .padding(16.dp,0.dp,0.dp,32.dp),
        style = TextStyle(
            fontSize = 16.sp
        )
    )
}

//@Composable
//fun button(users: List<User>){
//    var users by remember { mutableStateOf(users) }
//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .fillMaxHeight(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Button(onClick = { users = users.toMutableList().also {
//            it.add(0, User(123, "123"))
//        } },
//            colors = ButtonDefaults.buttonColors(Color.DarkGray)) {
//            Text("Записаться")
//        }
//    }
//}
@Composable
fun PersonView(name: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(6.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Person",
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)

            )
            Text(
                text = name,
                fontSize = 20.sp,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
            )
        }
    }
}



