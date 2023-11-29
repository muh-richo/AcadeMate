package com.example.academate.ui.presentation.home_screen

import android.content.ContentValues
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.academate.R
import com.example.academate.data.repository.MataKuliahRepository
import com.example.academate.data.model.MataKuliahModelResponse
import com.example.academate.navigate.Route
import com.example.academate.ui.presentation.login_screen.SignInViewModel
import com.example.academate.ui.presentation.login_screen.UserViewModel
import com.example.academate.ui.theme.Biru
import com.example.academate.ui.theme.Putih
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.example.academate.util.Resource
import kotlinx.coroutines.launch

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

    // pmatakuliah
    val mataKuliahRepository = MataKuliahRepository()
    val scope = rememberCoroutineScope()
    var matkul by remember {
        mutableStateOf<List<MataKuliahModelResponse>>(emptyList())
    }



    LaunchedEffect(key1 = true, block = {
        scope.launch {
            mataKuliahRepository.getMataKuliah().collect {
                when (it) {
                    is Resource.Error -> {}
                    is Resource.Loading -> {}
                    is Resource.Success -> matkul = it.data!!
                }
            }
        }
    })

    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                colors = listOf(
                    Biru,
                    Putih
                )
                )
            )
    ){
        val scrollState = rememberScrollState()

        Column(
        ) {
            Greet(username, navController)
            MentorTerbaik()

            val scrollState = rememberScrollState()
            LazyRow(
                modifier = Modifier
//                    .horizontalScroll(scrollState)
            ) {
                items(nameList.size){currentIndex ->
                    ListMentorTerbaik(painter = painterResource(id = R.drawable.foto_profil),
                        nama = nameList[currentIndex],
                        matakuliah = courseList[currentIndex],
                        navController = navController,
                        viewModelUser
                    )
                }
            }

            matakuliahDiminati()

            LazyColumn(){
                items(matkul){
                    DaftarMataKuliahDiminati(
                        painter = painterResource(id = R.drawable.matakuliah),
                        matakuliah = it.item!!.namaMatkul,
                        fakultas = it.item!!.fakultas,
                        navController = navController
                    )
                }
            }

        }
    }
}

@Composable
fun Greet(
    nama: String,
    navController: NavController
){
    Card(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 20.dp, bottom = 16.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .background(Color.Transparent)
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = "Selamat Datang $nama!",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(bottom = 5.dp)
            )
            Text(
                text = "Ayo bergabung dengan AcadeMate dan temukan mentor terbaik sesuai kebutuhanmu!",
                fontSize = 12.sp,
                modifier = Modifier
                    .padding(bottom = 10.dp)
            )
            ClickableText(
                text = AnnotatedString("Ayo Mulai >"),
                onClick = {
                    navController.navigate(Route.MATAKULIAH)
                }
            )
        }
    }
}

@Composable
fun MentorTerbaik(){
    Column(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 12.dp)
    ) {
        Text(
            text = "Mentor Terbaik Minggu Ini",
            fontSize = 20.sp,
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
    navController: NavController,
    viewModelUser: UserViewModel
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
                viewModelUser.setMentorname(nama)
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
fun matakuliahDiminati(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 18.dp, bottom = 12.dp)
    ) {
        Text(
            text = "Mata Kuliah Banyak Diminati",
            fontSize = 20.sp,
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
            .padding(bottom = 6.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Transparent)
                .padding(start = 20.dp, end = 20.dp, bottom = 5.dp),
            onClick = {
                navController.navigate(Route.INFORMASI_MATKUL)
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
                            contentDescription = null,
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
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.Black,
                            )
                            Text(
                                text = fakultas,
                                fontSize = 12.sp,
                                color = Color.Gray
                            )
                        }
                    }
                }
            }
        }
    }
}