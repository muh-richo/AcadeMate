package com.example.academate.ui.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.academate.R
import com.example.academate.ui.theme.Biru
import com.example.academate.ui.theme.Putih

@Composable
fun MataKuliah(navController: NavController){
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
    ) {
        Header()

        val scrollState = rememberScrollState()
        Column(
            modifier = Modifier.verticalScroll(scrollState)
        ) {
            val painter = painterResource(id = R.drawable.matakuliah_rpl)
            val matakuliah = "Rekayasa Perangkat Lunak"
            val fakultas = "Fakultas Ilmu Komputer"
            DaftarMataKuliah(painter = painter, matakuliah = matakuliah, fakultas = fakultas, navController=navController)

            val painter2 = painterResource(id = R.drawable.matakuliah_jst)
            val matakuliah2= "Jaringan Saraf Tiruan"
            val fakultas2 = "Fakultas Ilmu Komputer"
            DaftarMataKuliah(painter = painter2, matakuliah = matakuliah2, fakultas = fakultas2, navController=navController)

            val painter3 = painterResource(id = R.drawable.matakuliah_pemdas)
            val matakuliah3 = "Pemrograman Dasar"
            val fakultas3 = "Fakultas Ilmu Komputer"
            DaftarMataKuliah(painter = painter3, matakuliah = matakuliah3, fakultas = fakultas3, navController=navController)

            val painter4 = painterResource(id = R.drawable.matakuliah_pemweb)
            val matakuliah4 = "Pemrograman Web"
            val fakultas4 = "Fakultas Ilmu Komputer"
            DaftarMataKuliah(painter = painter4, matakuliah = matakuliah4, fakultas = fakultas4, navController=navController)

            val painter5 = painterResource(id = R.drawable.matakuliah_jarkom)
            val matakuliah5 = "Jaringan Komputer"
            val fakultas5 = "Fakultas Ilmu Komputer"
            DaftarMataKuliah(painter = painter5, matakuliah = matakuliah5, fakultas = fakultas5, navController=navController)

            val painter6 = painterResource(id = R.drawable.matakuliah_ki)
            val matakuliah6 = "Keamanan Informasi"
            val fakultas6 = "Fakultas Ilmu Komputer"
            DaftarMataKuliah(painter = painter6, matakuliah = matakuliah6, fakultas = fakultas6, navController=navController)

            val painter7 = painterResource(id = R.drawable.matakuliah_sismul)
            val matakuliah7 = "Sistem Multimedia"
            val fakultas7 = "Fakultas Ilmu Komputer"
            DaftarMataKuliah(painter = painter7, matakuliah = matakuliah7, fakultas = fakultas7, navController=navController)

            DaftarMataKuliah(painter = painter6, matakuliah = matakuliah6, fakultas = fakultas6, navController=navController)
        }
    }
}

@Composable
fun Header(
    modifier: Modifier = Modifier
){
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.Top,
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        Icon(painter = painterResource(id = R.drawable.arrowleft),
            contentDescription = "Back",
            modifier = Modifier
                .size(29.dp)
                .padding(end = 8.dp),
            tint = Color.Black)

        Text(
            text = "Mata Kuliah",
            fontSize = 20.sp,
            fontStyle = FontStyle.Normal
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DaftarMataKuliah(
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
                navController.navigate("informasiRPL")
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