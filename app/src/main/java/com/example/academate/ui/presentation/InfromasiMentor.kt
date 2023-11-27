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
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.academate.R
import com.example.academate.ui.theme.Biru
import com.example.academate.ui.theme.BiruMuda
import com.example.academate.ui.theme.Putih
import com.example.academate.ui.theme.matkul
import com.example.academate.ui.theme.matkul2
import com.example.academate.ui.theme.matkul3

@Composable
fun InformasiMentor(){
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
        HeaderMentor()

        val scrollState = rememberScrollState()
        Column(
            modifier = Modifier.verticalScroll(scrollState)
        ) {
            DeskripsiMentor()
            ButtonMentor()
        }
    }
}

@Composable
fun HeaderMentor(
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
            text = "Informasi Mentor",
            fontSize = 20.sp,
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
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(color = Color.White)
        ) {
            Column(
                modifier = Modifier
                    .padding(start = 15.dp, end = 15.dp)
            ) {
                Row(
                    verticalAlignment= Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .padding(top = 5.dp, bottom = 5.dp)
                ) {
                    Text(
                        text = "Aziz Purnomo",
                        fontSize = 20.sp
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

                Row(
                    modifier = Modifier
                        .padding(bottom = 10.dp)
                ) {
                    Text(
                        text = "Jaringan Saraf Tiruan",
                        fontSize = 11.sp,
                        color = matkul,
                        modifier = Modifier
                            .padding(end = 15.dp)
                    )
                    Text(
                        text = "Basis Data",
                        fontSize = 11.sp,
                        color = matkul2,
                        modifier = Modifier
                            .padding(end = 15.dp)
                    )
                    Text(
                        text = "Jaringan Komputer",
                        fontSize = 11.sp,
                        color = matkul3
                    )
                }

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
    modifier: Modifier = Modifier
){
    var showDialog by remember { mutableStateOf(false) }
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(top = 20.dp, start = 15.dp, end = 15.dp, bottom = 20.dp),
        colors = ButtonDefaults.buttonColors(Color.Blue),
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
                        border = BorderStroke(2.dp, BiruMuda)
                    ),
                title = {
                    Text(
                        text = "Konfirmasi Pesanan?",
                        color = Color.Blue
                    )
                },

                confirmButton = {
                    Button(
                        onClick = {
                            showDialog = false
                        },
                        modifier = Modifier
                            .height(35.dp)
                            .width(120.dp),
                        colors = ButtonDefaults.buttonColors(Color.Blue)
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
                            color = Color.Blue
                        )
                    }
                }
            )
        }
    }

}