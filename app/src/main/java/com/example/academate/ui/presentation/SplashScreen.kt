package com.example.academate.ui.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.academate.R
import com.example.academate.ui.theme.AcadeMateTheme

@Composable
fun Splash1() {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.blue1)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "logo",
            modifier = Modifier.size(120.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "AcadeMate",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold ,
            color = colorResource(id = R.color.white)
        )
    }
}

//@Preview(showBackground = true)
//@Composable
//fun SplashPreview() {
//    AcadeMateTheme {
//        Splash1()
//    }
//}

@Composable
fun Splash2(onNextClick: () -> Unit) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.blue1))
            .padding(start = 16.dp, end = 10.dp, bottom = 42.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
//        modifier = Modifier
//            .fillMaxSize()
//            .background(colorResource(id = R.color.blue1))
//            .padding(horizontal = 16.dp),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
    ){
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "logo",
            modifier = Modifier
                .padding(top = 150.dp)
                .size(175.dp)
        )
        Spacer(modifier = Modifier.height(150.dp))
        Text(
            text = "Welcome to AcadeMate",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold ,
            color = colorResource(id = R.color.white)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Aplikasi penyedia layanan penyewaan mentor segala jenis mata kuliah untuk mahasiswa Universitas Brawijaya",
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            color = colorResource(id = R.color.white),
            lineHeight = 18.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 24.dp)
        )
        Spacer(modifier = Modifier.height(50.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
                .padding(horizontal = 30.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ){
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxHeight()
            ) {
                Text(
                    text = "Skip",
                    fontSize = 16.sp,
                    color = Color.White,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                )
            }
            Row (
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxHeight()
                    .width(IntrinsicSize.Min)
            ){
                Icon(
                    painter = painterResource(id = R.drawable.circle),
                    contentDescription = null,
                    tint = Color.Gray,
                    modifier = Modifier.size(12.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Icon(
                    painter = painterResource(id = R.drawable.circle),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(12.dp)
                )
            }
            Row {
//                Text(
//                    text = "Next",
//                    fontSize = 16.sp,
//                    color = Color.White,
//                    modifier = Modifier
//                        .align(Alignment.CenterVertically)
//                )
                IconButton(
                    onClick = onNextClick,
                    modifier = Modifier.size(32.dp),
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = "Next",
                        tint = Color.White,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun Splash2Preview() {
    AcadeMateTheme {
        Splash2(onNextClick = {

        })
    }
}

@Composable
fun Splash3(onNextClick: () -> Unit) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.blue1))
            .padding(start = 16.dp, end = 10.dp, bottom = 42.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ){
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "logo",
            modifier = Modifier
                .padding(top = 140.dp)
                .size(175.dp)
        )
        Spacer(modifier = Modifier.height(150.dp))
        Text(
            text = "Perlihatkan Potensi Anda",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold ,
            color = colorResource(id = R.color.white)
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = "AcadeMate membuka pintu menuju pengetahuan dan pemahaman yang lebih dalam. Jembatani kesuksesanmu dengan mentor terbaik untuk mewujudkan impianmu!",
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            color = colorResource(id = R.color.white),
            lineHeight = 18.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 24.dp)
        )
        Spacer(modifier = Modifier.height(50.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
                .padding(horizontal = 30.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Row {
                IconButton(
                    onClick = onNextClick,
                    modifier = Modifier.size(32.dp),
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.White,
                        modifier = Modifier.size(24.dp)
                    )
                }
                Text(
                    text = "Back",
                    fontSize = 16.sp,
                    color = Color.White,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                )
            }
            Row (
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxHeight()
                    .width(IntrinsicSize.Min)
            ){
                Icon(
                    painter = painterResource(id = R.drawable.circle),
                    contentDescription = null,
                    tint = Color.Gray,
                    modifier = Modifier.size(12.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Icon(
                    painter = painterResource(id = R.drawable.circle),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(12.dp)
                )
            }
            Row {
                Text(
                    text = "Login",
                    fontSize = 16.sp,
                    color = Color.White,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                )
                IconButton(
                    onClick = onNextClick,
                    modifier = Modifier.size(32.dp),
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = "Next",
                        tint = Color.White,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun Splash3Preview() {
    AcadeMateTheme {
        Splash3(onNextClick = {

        })
    }
}