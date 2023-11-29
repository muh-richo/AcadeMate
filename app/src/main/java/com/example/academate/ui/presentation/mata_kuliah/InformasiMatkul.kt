package com.example.academate.ui.presentation.mata_kuliah

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.academate.R
import com.example.academate.data.model.MataKuliahModelResponse
import com.example.academate.data.repository.MataKuliahRepository
import com.example.academate.navigate.Route
import com.example.academate.ui.theme.Biru
import com.example.academate.ui.theme.Putih
import com.example.academate.util.Resource
import kotlinx.coroutines.launch

@Composable
fun InformasiMatkul(
    navController: NavController,
//    idMatkul: String,
//    viewModel: InformasiMatkulViewModel = hiltViewModel()
){

//    LaunchedEffect(key1 = true, block = {
//        viewModel.getMatkulDetail(idMatkul)
//    })
//
//    val matkul by viewModel.matkul

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
        LazyColumn() {
            items(matkul) {
                HeaderInformasiMatkul(
                    namaMatkul = it.item!!.namaMatkul,
                    navController = navController
                )
                DeskripsiMatkul(
                    namaMatkul = it.item!!.namaMatkul,
                    fakultas = it.item!!.fakultas,
                    desc = it.item!!.desc
                )
                ButtonCariMentor(navController = navController)
                Spacer(modifier = Modifier.height(50.dp))
            }
        }
    }
}


@Composable
fun HeaderInformasiMatkul(
    namaMatkul: String,
    navController: NavController,
    modifier: Modifier = Modifier
){
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, top = 6.dp, end = 10.dp, bottom = 6.dp)
    ) {
        IconButton(onClick = {
            navController.popBackStack()
        }) {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
        }
        Text(
            text = namaMatkul,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal
        )
    }
}

@Composable
fun DeskripsiMatkul(
    namaMatkul: String,
    fakultas: String,
    desc: String,
    modifier: Modifier = Modifier
){
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.matakuliah),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .shadow(8.dp)
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp, 10.dp)
        ){
            Column {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = namaMatkul,
                    color = Color.Black,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = fakultas,
                    color = Color.DarkGray,
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "Deskripsi",
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                )
                Text(
                    text = desc,
                    color = Color.DarkGray,
                    fontSize = 12.sp
                )
                Spacer(modifier = Modifier.height(80.dp))
            }
        }
    }
}

@Composable
fun ButtonCariMentor(
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