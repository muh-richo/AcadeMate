package com.example.academate.ui.presentation.onBoarding

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
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.academate.R
import com.example.academate.navigate.Route
import com.example.academate.ui.theme.Biru

@Composable
fun onBoarding1(navController: NavController) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.blue1))
            .padding(start = 16.dp, end = 10.dp, bottom = 45.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
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
                ClickableText(
                    text = AnnotatedString("Skip"),
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontSize = 16.sp,
                        color = Color.White
                    ),
                    modifier = Modifier
                        .align(Alignment.CenterVertically),
                    onClick = {
                        navController.navigate(Route.LOGIN)
                    }

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
                    tint = Color.White,
                    modifier = Modifier.size(12.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Icon(
                    painter = painterResource(id = R.drawable.circle),
                    contentDescription = null,
                    tint = Color.Gray,
                    modifier = Modifier.size(12.dp)
                )
            }
            Row {
                IconButton(
                    onClick = {
                            navController.navigate(Route.ONBOARDING2)
                    },
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