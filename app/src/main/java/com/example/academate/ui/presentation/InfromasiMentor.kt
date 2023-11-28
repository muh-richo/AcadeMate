package com.example.academate.ui.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.academate.R
import com.example.academate.navigate.Route
import com.example.academate.ui.theme.Biru
import com.example.academate.ui.theme.BiruMuda
import com.example.academate.ui.theme.Putih
import com.example.academate.ui.theme.matkul
import com.example.academate.ui.theme.matkul2
import com.example.academate.ui.theme.matkul3

@Composable
fun InformasiMentor(navController: NavController){
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
                    ),
                    startY = 300f
                )
            )
    ){
        HeaderMentor(navController)

        val scrollState = rememberScrollState()
        Column(
            modifier = Modifier.verticalScroll(scrollState)
        ) {
            DeskripsiMentor()
            ButtonMentor(navController = navController)
        }
    }
}

@Composable
fun HeaderMentor(
    navController: NavController
){
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        IconButton(
            onClick = { navController.navigate(Route.HOME) },
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack, contentDescription = "Back"
            )
        }
        Text(
            text = "Informasi Mentor",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal
        )
    }
}

@Composable
fun DeskripsiMentor(){
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()

        ) {
            Image(
                painter = painterResource(id = R.drawable.foto_mentor),
                contentDescription = "RPL",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.5f)
                    .shadow(8.dp)
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
//                .background(color = Color.White)
        ) {
            Column(
                modifier = Modifier
                    .padding(15.dp)
            ) {
                Row(
                    verticalAlignment= Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .padding(top = 5.dp, bottom = 5.dp)
                ) {
                    Text(
                        text = "Aziz Purnomo",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = "40.000 IDR / per section",
                        fontSize = 12.sp,
                        modifier = Modifier
                            .padding(start = 170.dp))
                }
                Row(
                    modifier = Modifier
                        .padding(bottom = 5.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.heart),
                        contentDescription = "heart",
                        modifier = Modifier
                            .size(18.dp)
                            .padding(end = 5.dp, top = 2.dp)
                    )
                    Text(text = "4.2/5")
                }
                Text(
                    text = "About",
                    fontSize = 16.sp
                )
                Text(
                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod " +
                            "tempor incididunt ut labore et dolore magna aliqua. Fames ac turpis egestas " +
                            "maecenas pharetra convallis. Aenean euismod elementum nisi quis eleifend quam " +
                            "adipiscing. Nisi est sit amet facilisis magna etiam tempor. Augue lacus viverra " +
                            "vitae congue eu.",
                    fontSize = 12.sp,
                    modifier = Modifier
                        .padding(bottom = 10.dp)
                )

                Text(
                    text = "Tempat",
                    fontSize = 16.sp,
                    modifier = Modifier
                        .padding(bottom = 5.dp)
                )
                Text(
                    text = "Gedung Kreativitas Mahasiswa Lt. 1",
                    fontSize = 11.sp,
                    modifier = Modifier
                        .padding(bottom = 10.dp)
                )

                Text(
                    text = "Review",
                    fontSize = 16.sp,
                    modifier = Modifier
                        .padding(bottom = 5.dp)
                )
                Text(
                    text = "Rendy Bayu",
                    fontSize = 9.sp
                )

                Row(
                    modifier = Modifier
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.heart),
                        contentDescription = "heart",
                        modifier = Modifier
                            .size(18.dp)
                            .padding(end = 5.dp)
                    )
                    Text(
                        text = "4.5/5",
                        fontSize = 8.sp,
                        modifier = Modifier
                            .padding(top = 3.dp)
                    )
                }

                Text(
                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod " +
                            "tempor incididunt ut labore et dolore magna aliqua. Fames ac turpis egestas ",
                    fontSize = 8.sp
                )
            }
        }
    }
}

@Composable
fun ButtonMentor(
    modifier: Modifier = Modifier,
    navController: NavController
){
    var showDialog by remember { mutableStateOf(false) }
    Button(
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.blue1)),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp, start = 15.dp, end = 15.dp, bottom = 20.dp),
        onClick = {
            showDialog = true
        }) {
        Text(
            text = "Sewa Mentor",
            color = Color.White
        )
    }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        if (showDialog) {
            AlertDialog(
                onDismissRequest = {
                    showDialog = false
                },
                modifier = Modifier
                    .border(
                        shape = RoundedCornerShape(22.dp),
                        border = BorderStroke(1.dp, colorResource(id = R.color.blue1))
                    ),
                title = {
                    Text(
                        text = "Konfirmasi Pesanan?",
                        textAlign = TextAlign.Center,
                        color = colorResource(id = R.color.blue1)
                    )
                },

                confirmButton = {
                    Button(
                        onClick = {
                            navController.navigate(Route.INFORMASIPEMBAYARAN)
                        },
                        modifier = Modifier
                            .height(35.dp)
                            .width(120.dp),
                        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.blue1))
                    ) {
                        Text(
                            text = "Konfirmasi",
                            color = Color.White
                        )
                    }
                },
                dismissButton = {
                    Button(
                        onClick = {
                            showDialog = false
                        },
                        modifier = Modifier
                            .height(35.dp)
                            .width(120.dp),
                        colors = ButtonDefaults.buttonColors(Color.White)
                    ) {
                        Text(
                            text = "Batal",
                            color = colorResource(id = R.color.blue1)
                        )
                    }
                }
            )
        }
    }

}