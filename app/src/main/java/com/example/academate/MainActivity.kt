package com.example.academate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.academate.ui.presentation.LoginScreen
import com.example.academate.ui.presentation.ProfilScreen
import com.example.academate.ui.presentation.SignUpScreen
import com.example.academate.ui.presentation.Splash1
import com.example.academate.ui.presentation.Splash2
import com.example.academate.ui.presentation.Splash3
import com.example.academate.ui.theme.AcadeMateTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AcadeMateTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    MyApp(navController = navController)
                }
            }
        }
    }
}

@Composable
fun MyApp(navController: NavHostController) {
    var isLoading by remember {
        mutableStateOf(true)
    }

    LaunchedEffect(isLoading){
        delay(3000)
        isLoading = false
    }

    if (isLoading){
        Splash1()
    }else{
        NavHost(navController = navController, startDestination = "splash2") {
            composable("splash2") {
                Splash2(onNextClick = {
                    navController.navigate("splash3")
                })
            }
            composable("splash3") {
                Splash3(onNextClick = {
                    navController.navigate("login")
                })
            }
            composable("login"){
                LoginScreen(onNextClick = {
                    navController.navigate("signUp")
                })
            }
            composable("signUp"){
                SignUpScreen(onNextClick = {
                    navController.navigate("profil")
                })
            }
            composable("profil"){
                ProfilScreen()
            }
        }
    }
}

//@Preview
//@Composable
//fun MyAppPreview() {
//    AcadeMateTheme {
//        MyApp(navController = navController)
//    }
//}