package com.example.academate.ui.presentation

import android.content.ContentValues
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.academate.R
import com.example.academate.navigate.Route
import com.example.academate.ui.presentation.login_screen.UserViewModel
import com.example.academate.ui.theme.BiruMuda
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlin.math.cos
import kotlin.math.min
import kotlin.math.pow
import kotlin.math.sin
import kotlin.math.sqrt

@Composable
fun Riwayat(navController: NavController, viewModel: UserViewModel){

    val username by viewModel.username.collectAsState()

    // inisialisasi database
    val database = FirebaseDatabase.getInstance()
    val user = database.getReference("users").child(username)// pointer ke root users

    // inisialisasi variabel riwayat
    var namaMentor = remember { mutableStateListOf<String>() }
    var matkul = remember { mutableStateListOf<String>() }
    var waktu = remember { mutableStateListOf<String>() }
    var count by remember { mutableIntStateOf(0) }

    user.addValueEventListener(object : ValueEventListener {
        override fun onDataChange(snapshot: DataSnapshot) {
            if(snapshot.hasChild("riwayat")){
                user.child("riwayat").addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        count = snapshot.childrenCount.toInt()
                        snapshot.children.forEach{idRiwayat ->
                            val map: Map<String, Any>? = idRiwayat.getValue() as? Map<String, Any>

                            namaMentor.add(map?.get("namaMentor").toString())
                            matkul.add(map?.get("course").toString())
                            waktu.add(map?.get("waktu").toString())
                        }

//                        val snapshotValue = snapshot.getValue() // Mengambil nilai dari snapshot
//                        val map: Map<String, Any>? = snapshotValue as? Map<String, Any>
//
//                        namaMentor.add(map?.get("namaMentor").toString())
//                        matkul.add(map?.get("course").toString())
//                        waktu.add(map?.get("waktu").toString())
                    }

                    override fun onCancelled(error: DatabaseError) {
                        Log.w(ContentValues.TAG, "Failed to read value.", error.toException())
                    }
                })
            }
        }
        override fun onCancelled(error: DatabaseError) {
            Log.w(ContentValues.TAG, "Failed to read value.", error.toException())
        }
    })


    Column(
        modifier = Modifier
            .fillMaxSize()
            .drawBehind {
                // Setting the angle in radians
                val angleRad = 60f / 180f * 3.14f

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
//                .padding(start = 20.dp, end = 20.dp)
        ){
            Row (
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, top = 6.dp, end = 10.dp, bottom = 6.dp)
            ){
                IconButton(onClick = {
                    navController.popBackStack()
                }) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                }
                Text(
                    text = "Riwayat",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Normal
                )
            }
            Text(
                text = "Menampilkan Riwayat:",
                modifier = Modifier
                    .alpha(0.5f)
                    .padding(horizontal = 20.dp, vertical = 25.dp),
                fontSize = 12.sp,
            )
            Text(text = "ini adalah count = $count")
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                items(count){currentRiwayat ->
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                color = Color(0xFFEAEAEA),
                                shape = RoundedCornerShape(corner = CornerSize(10.dp))
                            )
                            .border(1.dp, Color(0xF222222))
                            .padding(horizontal = 7.dp, vertical = 11.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Box(
                            modifier = Modifier
                                .clip(CircleShape)
                                .background(Color.Green)
                        ){
                            Image(
                                painter = painterResource(id = R.drawable.matakuliah),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                            )
                        }

                        Spacer(modifier = Modifier.width(7.dp))
                        Column {
                            Text(text = matkul[currentRiwayat], fontSize = 18.sp, fontWeight = FontWeight.Medium)
                            Text(
                                text = namaMentor[currentRiwayat],
                                fontSize = 12.sp,
                                lineHeight = 15.sp,
                                modifier = Modifier.padding(top = 8.dp, bottom = 6.dp)
                            )
                            Row (
                                verticalAlignment = Alignment.CenterVertically
                            ){
//                                Image(painter = painterResource(id = R.drawable.heart), contentDescription = null)
                                Spacer(modifier = Modifier.width(5.dp))
                                Text(text = waktu[currentRiwayat], fontSize = 10.sp)
                            }

                            Spacer(modifier = Modifier.height(8.dp))

                            Button(
                                onClick = { /*TODO*/ },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.Transparent
                                ),
                                contentPadding = PaddingValues(0.dp),
                                modifier = Modifier.height(15.dp),
                                shape = RoundedCornerShape(0.dp)
                            ) {
//                                ClickableText(
//                                    text = AnnotatedString("Rating & Review"),
//                                    style = MaterialTheme.typography.bodySmall.copy(
//                                        fontSize = 12.sp,
//                                        color = BiruMuda
//                                    ),
//                                    onClick = {
//                                        navController.navigate(Route.REVIEWMENTOR)
//                                    }
//
//                                )
//                                Spacer(modifier = Modifier.width(5.dp))

                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                }
            }
        }
    }
}