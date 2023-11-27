package com.example.academate

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.academate.navigate.CustomScaffold
import com.example.academate.navigate.Navigasi
import com.example.academate.navigate.Route
import com.example.academate.ui.presentation.DaftarMentor

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {

    val showBar = listOf(
        Route.HOME,
        Route.MATAKULIAH,
        Route.SEARCH,
        Route.PROFILE
    )
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            val backStackEntry by navController.currentBackStackEntryAsState()
            val currPage = backStackEntry?.destination?.route

            Surface {
                CustomScaffold(
                    navController = navController,
                    showBottomBar = currPage in showBar
                ) {
                    Navigasi(navController = navController)
                }
            }
        }
    }

}