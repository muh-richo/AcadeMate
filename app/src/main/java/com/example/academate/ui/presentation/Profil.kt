package com.example.academate.ui.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.ExitToApp
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.academate.R
import com.example.academate.ui.theme.AcadeMateTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfilScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Profil", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = { /* Handle back navigation */ }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                modifier = Modifier.background(colorResource(id = R.color.biru))
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(paddingValues)
                .fillMaxWidth()
                .fillMaxHeight()
            ,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.foto_profil),
                contentDescription = "profil",
                modifier = Modifier
                    .size(width = 170.dp, height = 190.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Bagus Satrio",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold ,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(36.dp))
            ProfilMenu()

        }
    }
}

@Composable
fun ProfilMenu() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .padding(24.dp),
        shape = RoundedCornerShape(32.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
//            Row(
//                verticalAlignment = Alignment.CenterVertically,
//                horizontalArrangement = Arrangement.spacedBy(8.dp),
//                modifier = Modifier
//                    .padding(8.dp)
//                    .clickable { /* Handle button click */ }
//            ) {
//                Icon(
//                    imageVector = Icons.Outlined.Person,
//                    contentDescription = "myProfil",
//                    modifier = Modifier.size(36.dp)
//                )
//                Text(
//                    text = "My Profile",
//                    fontSize = 18.sp
//                )
//            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .padding(8.dp)
                    .clickable { /* Handle button click */ }
            ) {
                Icon(
                    imageVector = Icons.Outlined.Star,
                    contentDescription = "be_a_mentor",
                    modifier = Modifier.size(36.dp)
                )
                Text(
                    text = "Be a Mentor",
                    fontSize = 18.sp
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .padding(8.dp)
                    .height(IntrinsicSize.Min)
                    .clickable { /* Handle button click */ }
            ) {
                Icon(
                    imageVector = Icons.Outlined.Info,
                    contentDescription = "riwayat",
                    modifier = Modifier.size(36.dp)
                )
                Text(
                    text = "Riwayat",
                    fontSize = 18.sp
                )
            }
//            Row(
//                verticalAlignment = Alignment.CenterVertically,
//                horizontalArrangement = Arrangement.spacedBy(8.dp),
//                modifier = Modifier
//                    .padding(8.dp)
//                    .clickable { /* Handle button click */ }
//            ) {
//                Icon(
//                    imageVector = Icons.Outlined.Settings,
//                    contentDescription = "setting",
//                    modifier = Modifier.size(36.dp)
//                )
//                Text(
//                    text = "Setting",
//                    fontSize = 18.sp
//                )
//            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .padding(8.dp)
                    .clickable { /* Handle button click */ }
            ) {
                Icon(
                    imageVector = Icons.Outlined.ExitToApp,
                    contentDescription = "logout",
                    modifier = Modifier.size(36.dp)
                )
                Text(
                    text = "Logout",
                    fontSize = 18.sp
                )
            }
        }
    }
}

@Preview (showBackground = true)
@Composable
fun ProfileScreenPreview() {
    AcadeMateTheme {
        ProfilScreen()
    }
}