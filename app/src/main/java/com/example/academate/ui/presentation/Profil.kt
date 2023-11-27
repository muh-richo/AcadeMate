package com.example.academate.ui.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.academate.R
import com.example.academate.navigate.Route
import com.example.academate.navigate.onItemClick
import com.example.academate.ui.theme.AcadeMateTheme
import com.example.academate.ui.theme.Biru
import com.example.academate.ui.theme.Putih

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Profil(navController: NavController) {
    Box(
        modifier = Modifier
            .background(Biru)
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = "Profil", fontWeight = FontWeight.Bold) },
                    navigationIcon = {
                        IconButton(onClick = {
                            navController.navigate(Route.HOME)
                        }) {
                            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                        }
                    },
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
                        .size(width = 160.dp, height = 160.dp)
                        .clip(CircleShape)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "M Richo Abadinata",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold ,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Member",
                    fontSize = 12.sp,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(36.dp))
                ProfilMenu(navController)

            }
        }
    }
}

@Composable
fun ProfilMenu(navController: NavController) {
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

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .padding(8.dp)
            ) {
                Icon(
                    imageVector = Icons.Outlined.Star,
                    contentDescription = "be_a_mentor",
                    modifier = Modifier.size(32.dp),
                )
                ClickableText(
                    text = AnnotatedString("Be a Mentor"),
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontSize = 16.sp,
                    ),
                    onClick = {
                        navController.navigate(Route.FORMMENTOR)
                    }
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .padding(8.dp)
                    .height(IntrinsicSize.Min)
            ) {
                Icon(
                    imageVector = Icons.Outlined.Info,
                    contentDescription = "riwayat",
                    modifier = Modifier.size(32.dp)
                )
                ClickableText(
                    text = AnnotatedString("Riwayat"),
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontSize = 16.sp,
                    ),
                    onClick = {
                        navController.navigate(Route.RIWAYAT)
                    }
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .padding(8.dp)
            ) {
                Icon(
                    imageVector = Icons.Outlined.ExitToApp,
                    contentDescription = "logout",
                    modifier = Modifier.size(32.dp)
                )
                ClickableText(
                    text = AnnotatedString("Logout"),
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontSize = 16.sp,
                    ),
                    onClick = {
                        navController.navigate(Route.LOGIN)
                    }
                )
            }
        }
    }
}
