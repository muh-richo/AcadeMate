package com.example.academate.ui.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.academate.R
import com.example.academate.navigate.Route
import com.example.academate.ui.theme.Biru
import com.example.academate.ui.theme.Putih

@Composable
fun InformasiPembayaran(navController: NavController){
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
        HeaderInfromasi()

        val name1 = "Arif Rama Putra"
        val matakuliah1 = "Jaringan Saraf Tiruan"
        val tanggal1 =  "9 November 2023"
        val waktuMulai1 = "16.00"
        val waktuSelesai1 = "17.00"
        val tempat1 = "Gedung Kreasi Kemahasiswaan"
        val harga1 = "50.000"
        Invoice(
            name = name1,
            matakuliah = matakuliah1,
            tanggal = tanggal1,
            waktuMulai = waktuMulai1,
            waktuSelesai = waktuSelesai1,
            tempat = tempat1,
            harga = harga1
        )

        ButtonSelesai(navController)
    }

}

@Composable
fun HeaderInfromasi(
    modifier: Modifier = Modifier
){
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.Top,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Icon(painter = painterResource(id = R.drawable.arrowleft),
            contentDescription = "Back",
            modifier = Modifier
                .size(29.dp)
                .padding(end = 8.dp),
            tint = Color.Black)

        Text(
            text = "Informasi Pembayaran",
            fontSize = 20.sp,
            fontStyle = FontStyle.Normal
        )
    }
}

@Composable
fun Invoice(
    name: String,
    matakuliah: String,
    tanggal: String,
    waktuMulai: String,
    waktuSelesai: String,
    tempat: String,
    harga: String
){
    Column(
        modifier = Modifier
            .padding(start = 15.dp, end = 15.dp, top = 15.dp, bottom = 50.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Box {
            Column {
                Text(
                    text = "Nama Mentor",
                    fontSize = 20.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(bottom = 5.dp)
                )
                Text(
                    text = name,
                    fontSize = 15.sp,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(bottom = 10.dp)
                )
            }
        }

        Box {
            Column {
                Text(
                    text = "Mata Kuliah Yang Dipilih",
                    fontSize = 20.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(bottom = 5.dp)
                )
                Text(
                    text = matakuliah,
                    fontSize = 15.sp,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(bottom = 10.dp)
                )
            }
        }

        Box {
            Column {
                Text(
                    text = "Set Waktu Pertemuan",
                    fontSize = 20.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(bottom = 5.dp)
                )
                Text(
                    text = "Tanggal      $tanggal",
                    fontSize = 15.sp,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(bottom = 5.dp)
                )
                Text(
                    text = "Waktu         $waktuMulai - $waktuSelesai",
                    fontSize = 15.sp,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(bottom = 10.dp)
                )
            }

        }

        Box {
            Column {
                Text(
                    text = "Tempat Pertemuan",
                    fontSize = 20.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(bottom = 5.dp)
                )
                Text(
                    text = tempat,
                    fontSize = 15.sp,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(bottom = 10.dp)
                )
            }
        }

        Box {
            Column {
                Text(
                    text = "Harga",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(bottom = 5.dp)
                )
                Text(
                    text = "Rp $harga",
                    fontSize = 15.sp,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(bottom = 10.dp)
                )
            }
        }
    }
}

@Composable
fun ButtonSelesai(navController: NavController){
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp, start = 15.dp, end = 15.dp, bottom = 20.dp),
        colors = ButtonDefaults.buttonColors(Color.Blue),
        onClick = {
            navController.navigate(Route.RIWAYAT)
        }) {
        Text(
            text = "Sewa Mentor",
            color = Color.White
        )
    }
}