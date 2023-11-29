package com.example.academate.ui.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.academate.R
import com.example.academate.navigate.Route
import kotlin.math.cos
import kotlin.math.min
import kotlin.math.pow
import kotlin.math.sin
import kotlin.math.sqrt

@Composable
fun DaftarMentor(navController: NavController){
    var riwayat = arrayOf(1,2,3,4)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .drawBehind {
                // Setting the angle in radians
                val angleRad = 90f / 180f * 3.14f

                // Fractional x
                val x = cos(angleRad).toFloat()

                // Fractional y
                val y = sin(angleRad).toFloat()

                // Set the Radius and offset as shown below
                val radius = sqrt(size.width.pow(2) + size.height.pow(2)) / 2f
                val offset = center + Offset(x * radius, y * radius)

                // Setting the exact offset
                val exactOffset = Offset(
                    x = min(offset.x.coerceAtLeast(0f), size.width),
                    y = size.height - min(
                        offset.y.coerceAtLeast(0f),
                        size.height
                    )
                )

                // Draw a rectangle with the above values
                drawRect(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color(0xFFFFFFFF),
                            Color(0xFFB2D1FF), // Warna 2: Biru Muda (#B2D1FF)
                            Color(0xFFB2D1FF), // Warna 2: Biru Muda (#B2D1FF)
                            Color(0xFFB2D1FF), // Warna 2: Biru Muda (#B2D1FF)
                            Color(0xFF0065FF), // Warna 1: Biru (#0065FF)
                        ),
                        start = Offset(size.width, size.height) - exactOffset,
                        end = exactOffset
                    ),
                    size = size
                )
            }
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 8.dp)
        ){
            Row (
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(16.dp)
            ){
                IconButton(onClick = {
                    navController.popBackStack()
                }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back"
                    )
                }
                Text(
                    text = "Rekayasa Perangkat Lunak",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Text(
                text = "Menampilkan Mentor Rekayasa Perangkat Lunak:",
                modifier = Modifier
                    .alpha(0.5f)
                    .padding(start = 15.dp, bottom = 20.dp),
                fontSize = 12.sp,
            )
            MentorListView(riwayat = riwayat, navController = navController)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MentorListView(riwayat: Array<Int>, navController: NavController){
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(riwayat) { currentRiwayat ->
            Row(
                modifier = Modifier
                    .background(
                        color = Color(0xFFEAEAEA),
                        shape = RoundedCornerShape(corner = CornerSize(10.dp))
                    )
                    .border(1.dp, Color(0xF222222))
                    .padding(horizontal = 7.dp, vertical = 11.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
//                Card(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .background(color = Color.Transparent)
//                        .padding(start = 20.dp, end = 20.dp, bottom = 5.dp),
//                    onClick = {
//                        navController.navigate(Route.INFORMASI_MATKUL)
//                    }
//                ) {
//                    Box(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                    ) {
//                        Row {
//                            Box(modifier = Modifier
//                                .height(80.dp)
//                            ){
//                                Image(
//                                    painter = painterResource(id = R.drawable.foto_profil),
//                                    contentDescription = null,
//                                    contentScale = ContentScale.Crop,
//                                    modifier = Modifier.size(70.dp)
//                                )
//                            }
//                            Box(
//                                modifier = Modifier
//                                    .fillMaxWidth()
//                                    .padding(start = 15.dp, top = 10.dp)
//                            ){
//                                Column {
//                                    Text(
//                                        text = "Rekayasa Perangkat Lunak",
//                                        fontSize = 18.sp,
//                                        fontWeight = FontWeight.Medium
//                                    )
//                                    Text(
//                                        text = "Arif Rama Putra Said",
//                                        fontSize = 12.sp,
//                                        lineHeight = 15.sp,
//                                        modifier = Modifier.padding(top = 8.dp, bottom = 6.dp)
//                                    )
//                                }
//                            }
//                        }
//                    }
//                }


                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(Color.Green)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.foto_profil),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.size(85.dp)
                    )
                }

                Spacer(modifier = Modifier.width(8.dp))
                Column {
                    Text(
                        text = "Rekayasa Perangkat Lunak",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium
                    )
                    Text(
                        text = "Arif Rama Putra Said",
                        fontSize = 12.sp,
                        lineHeight = 15.sp,
                        modifier = Modifier.padding(top = 8.dp, bottom = 6.dp)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(
                        onClick = {
                                  navController.navigate(Route.INFORMASIMENTOR)
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent
                        ),
                        contentPadding = PaddingValues(0.dp),
                        modifier = Modifier.height(15.dp),
                        shape = RoundedCornerShape(0.dp)
                    ) {
                        Text(
                            text = "Lihat Mentor",
                            fontSize = 12.sp,
                            color = Color.Black,
                        )
                        Icons.Default.KeyboardArrowRight
                    }
                }
            }
            Spacer(modifier = Modifier.height(15.dp))
        }
    }
}