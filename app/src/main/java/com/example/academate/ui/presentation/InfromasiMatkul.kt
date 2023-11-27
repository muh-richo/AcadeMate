package com.example.academate.ui.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.academate.R
import com.example.academate.navigate.Route
import com.example.academate.ui.theme.Biru
import com.example.academate.ui.theme.Putih

@Composable
fun InformasiRPL(navController: NavController){
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
        HeaderInformasiRPL()
        DeskripsiRPL()
        ButtonRPL(navController = navController)
    }
}


@Composable
fun HeaderInformasiRPL(
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
            text = "Rekayasa Perangkat Lunak",
            fontSize = 20.sp,
            fontStyle = FontStyle.Normal
        )
    }
}

@Composable
fun DeskripsiRPL(
    modifier: Modifier = Modifier
){
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.deskripsi_rpl),
                contentDescription = "RPL",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp, 10.dp)
        ){
            Column {
                Text(
                    text = "Rekayasa Perangkat Lunak",
                    color = Color.Black,
                    fontSize = 20.sp
                )
                Text(
                    text = "Fakultas Ilmu Komputer",
                    color = Color.DarkGray,
                    fontSize = 10.sp
                )

                Text(
                    text = "Deskripsi",
                    color = Color.Black,
                    fontSize = 18.sp,
                    modifier = Modifier
                        .padding(top = 10.dp)
                )
                Text(
                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do " +
                            "eiusmod tempor incididunt ut labore et dolore magna aliqua. Fames " +
                            "ac turpis egestas maecenas pharetra convallis. Aenean euismod elementum " +
                            "nisi quis eleifend quam adipiscing. Nisi est sit amet facilisis magna " +
                            "etiam tempor. Augue lacus viverra vitae congue eu.",
                    color = Color.DarkGray,
                    fontSize = 12.sp
                )
                Spacer(modifier = Modifier.height(50.dp))
            }

        }
    }
}

@Composable
fun ButtonRPL(
    modifier: Modifier = Modifier,
    navController: NavController
){
    Button(
        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.blue1)),
        onClick = {
            navController.navigate(Route.DAFTARMENTORRPL)
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, end = 15.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(
            text = "Cari Mentor",
            color = Color.White
        )
    }
}