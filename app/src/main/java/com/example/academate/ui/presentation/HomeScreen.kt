package com.example.academate.ui.presentation

import android.content.ContentValues
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.academate.R
import com.example.academate.navigate.Route
import com.example.academate.ui.presentation.login_screen.SignInViewModel
import com.example.academate.ui.presentation.login_screen.UserViewModel
import com.example.academate.ui.theme.Biru
import com.example.academate.ui.theme.BiruMuda
import com.example.academate.ui.theme.Putih
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController, viewModelUser: UserViewModel, viewModel: SignInViewModel = hiltViewModel()){

    val name by viewModelUser.nameList.collectAsState()
    val course by viewModelUser.courseList.collectAsState()

    val nameList = name.toList()
    val courseList = course.toList()

    // inisialisasi untuk username yang sudah di dapatkan di login
    val username by viewModelUser.username.collectAsState()
    Log.w("username", username)

    // count mentor
    var mentorCount = name.size
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        colorResource(id = R.color.blue1),
                        Putih
                    ),
                    startY = 300f
                )
            )
    ){
        val scrollState = rememberScrollState()

        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
        ) {
            Greet(username)
            Text(text = mentorCount.toString())
            Log.w("ukurang", mentorCount.toString())
            MentorTerbaik()

            val scrollState = rememberScrollState()
            LazyRow(
                modifier = Modifier
//                    .horizontalScroll(scrollState)
            ) {
                items(nameList.size){currentIndex ->
                    ListMentorTerbaik(painter = painterResource(id = R.drawable.profile_mentor),
                        nama = nameList[currentIndex],
                        matakuliah = courseList[currentIndex],
                        navController = navController
                    )
                }
//                ListMentorTerbaik(painter = painterResource(id = R.drawable.profile_mentor),
//                    nama = "Arif Rama Putra Sa’id",
//                    matakuliah = "Jaringan Saraf Tiruan",
//                    navController = navController
//                )
//                ListMentorTerbaik(painter = painterResource(id = R.drawable.profile_mentor3),
//                    nama = "M Richo Abadinata",
//                    matakuliah = "Pemrograman Dasar",
//                    navController = navController
//                )
//                ListMentorTerbaik(painter = painterResource(id = R.drawable.profile_mentor2),
//                    nama = "Aziz Purnomo",
//                    matakuliah = "Rekayasa Perangkat Lunak",
//                    navController = navController
//                )
            }

            matakuiliahDiminati()

            val painter = painterResource(id = R.drawable.matakuliah_rpl)
            val matakuliah = "Rekayasa Perangkat Lunak"
            val fakultas = "Fakultas Ilmu Komputer"
            DaftarMataKuliahDiminati(painter = painter, matakuliah = matakuliah, fakultas = fakultas, navController = navController)

            val painter2 = painterResource(id = R.drawable.matakuliah_jst)
            val matakuliah2= "Jaringan Saraf Tiruan"
            val fakultas2 = "Fakultas Ilmu Komputer"
            DaftarMataKuliahDiminati(painter = painter2, matakuliah = matakuliah2, fakultas = fakultas2,navController = navController)

            val painter3 = painterResource(id = R.drawable.matakuliah_pemdas)
            val matakuliah3 = "Pemrograman Dasar"
            val fakultas3 = "Fakultas Ilmu Komputer"
            DaftarMataKuliahDiminati(painter = painter3, matakuliah = matakuliah3, fakultas = fakultas3, navController = navController)

            val painter4 = painterResource(id = R.drawable.matakuliah_pemweb)
            val matakuliah4 = "Pemrograman Web"
            val fakultas4 = "Fakultas Ilmu Komputer"
            DaftarMataKuliahDiminati(painter = painter4, matakuliah = matakuliah4, fakultas = fakultas4, navController = navController)

        }
    }
}

@Composable
fun Greet(
    nama: String
){
    Card(
        modifier = Modifier
            .padding(start = 15.dp, end = 15.dp, top = 20.dp, bottom = 15.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .background(
                    Color.Transparent
//                    Brush.horizontalGradient(
//                        colors = listOf(
//                            BiruMuda,
//                            Putih
//                        )
//                    )
                )
                .fillMaxWidth()
                .padding(15.dp)

        ) {
            Text(
                text = "Selamat Datang $nama!",
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(bottom = 5.dp)
            )
            Text(
                text = "Ayo bergabung dengan AcadeMate dan temukan mentor terbaik sesuai kebutuhanmu!",
                fontSize = 12.sp,
                modifier = Modifier
                    .padding(bottom = 10.dp)
            )
            Text(text = "Ayo Mulai >")
        }
    }
}

@Composable
fun MentorTerbaik(){
    Column(
        modifier = Modifier
            .padding(15.dp, 5.dp)
    ) {
        Text(
            text = "Mentor terbaik minggu ini",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListMentorTerbaik(
    painter: Painter,
    nama: String,
    matakuliah: String,
    navController: NavController
){
    Column(
        modifier = Modifier
            .padding(start = 12.dp)
    ) {
        Card(
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier
                .width(140.dp)
                .height(210.dp),
            onClick = {
                navController.navigate(Route.INFORMASIMENTOR)
            }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 16.dp)
                    .background(
                        Color.Transparent
                    )
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    roundImage(painter)
                    Text(
                        text = nama,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                            .padding(bottom = 3.dp)
                    )
                    Text(
                        text = matakuliah,
                        fontSize = 10.sp,
                        modifier = Modifier
                            .padding(bottom = 6.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun roundImage(
    painter: Painter,
    modifier: Modifier = Modifier
){
    Image(
        painter = painter,
        contentDescription = null,
        modifier = modifier
            .aspectRatio(1f)
            .padding(15.dp)
            .clip(CircleShape)
    )
}

@Composable
fun matakuiliahDiminati(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp, 5.dp)
    ) {
        Text(
            text = "Mata kuliah banyak diminati",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DaftarMataKuliahDiminati(
    painter: Painter,
    matakuliah: String,
    fakultas: String,
    modifier: Modifier = Modifier,
    navController: NavController
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Transparent)
                .padding(start = 20.dp, end = 20.dp, bottom = 5.dp),
            onClick = {
                navController.navigate(Route.INFORMASIRPL)
            }
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Row {
                    Box(modifier = Modifier
                        .height(80.dp)

                    ){
                        Image(
                            painter = painter,
                            contentDescription = "RPL",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxWidth(0.3f)
                        )

                    }

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 15.dp, top = 10.dp)
                    ){
                        Column {
                            Text(
                                text = matakuliah,
                                fontSize = 14.sp,
                                color = Color.Black,
                                modifier = Modifier
                                    .clickable {

                                    }
                            )
                            Text(
                                text = fakultas,
                                fontSize = 10.sp,
                                color = Color.Gray
                            )
                        }
                    }
                }
            }
        }
    }
}