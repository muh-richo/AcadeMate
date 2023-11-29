package com.example.academate.navigate

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.academate.component.SearchScreen
import com.example.academate.ui.presentation.DaftarMentor
import com.example.academate.ui.presentation.FormMentor
import com.example.academate.ui.presentation.home_screen.HomeScreen
import com.example.academate.ui.presentation.InformasiMentor
import com.example.academate.ui.presentation.InputReviewMentor
import com.example.academate.ui.presentation.login_screen.Login
import com.example.academate.ui.presentation.mata_kuliah.MataKuliah
import com.example.academate.ui.presentation.PemberitahuanBeMentor
import com.example.academate.ui.presentation.Profil
import com.example.academate.ui.presentation.ReviewMentor
import com.example.academate.ui.presentation.Riwayat
import com.example.academate.ui.presentation.signup_screen.SignUp
import com.example.academate.ui.presentation.SplashScreen
import com.example.academate.ui.presentation.mata_kuliah.InformasiMatkul
import com.example.academate.ui.presentation.onBoarding.onBoarding1
import com.example.academate.ui.presentation.onBoarding.onBoarding2

@Composable
fun Navigasi(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Route.SPLASHSCREEN) {
        composable(Route.SPLASHSCREEN) {
            SplashScreen(navController)
        }
        composable(Route.ONBOARDING1) {
            onBoarding1(navController)
        }
        composable(Route.ONBOARDING2) {
            onBoarding2(navController)
        }
        composable(Route.LOGIN){
            Login(navController)
        }
        composable(Route.SIGNUP){
            SignUp(navController)
        }

        composable(Route.HOME) {
            HomeScreen(navController)
        }
        composable(Route.MATAKULIAH) {
            MataKuliah(navController)
        }
        composable(Route.INFORMASI_MATKUL) {
            InformasiMatkul(navController = navController)
        }
//        composable(
//            Route.INFORMASI_MATKUL + "?idMatkul={id}",
//            arguments = listOf(
//                navArgument(name = "id") {
//                    type = NavType.StringType
//                }
//            )
//        ){
//            val idMatkul = it.arguments?.getString("id")
//            idMatkul?.let {
//                InformasiMatkul(navController = navController, idMatkul = idMatkul)
//            }
//        }
        composable(Route.DAFTARMENTORRPL){
            DaftarMentor(navController)
        }
        composable(Route.INFORMASIMENTOR) {
            InformasiMentor(navController)
        }
        composable(Route.SEARCH) {
            SearchScreen(navController)
        }
        composable(Route.PROFILE) {
            Profil(navController)
        }
        composable(Route.FORMMENTOR){
            FormMentor(navController)
        }
        composable(Route.PEMBERITAHUANBEMENTOR){
            PemberitahuanBeMentor(navController)
        }
        composable(Route.RIWAYAT){
            Riwayat(navController)
        }
        composable(Route.REVIEWMENTOR){
            ReviewMentor(navController)
        }
        composable(Route.INPUTREVIEWMENTOR){
            InputReviewMentor(navController)
        }
    }
}