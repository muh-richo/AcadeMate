package com.example.academate.navigate

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
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
import com.example.academate.ui.presentation.login_screen.UserViewModel
import com.example.academate.ui.presentation.onBoarding.onBoarding1
import com.example.academate.ui.presentation.onBoarding.onBoarding2

@Composable
fun Navigasi(
    navController: NavHostController,
    userViewModel: UserViewModel = viewModel()
) {
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
            Login(navController, userViewModel)
        }
        composable(Route.SIGNUP){
            SignUp(navController)
        }

        composable(Route.HOME) {
            HomeScreen(navController, userViewModel)
        }
        composable(Route.MATAKULIAH) {
            MataKuliah(navController)
        }
        composable(Route.INFORMASI_MATKUL) {
            InformasiMatkul(navController = navController)
        }
        composable(Route.DAFTARMENTORRPL){
            DaftarMentor(navController)
        }
        composable(Route.INFORMASIMENTOR) {
            InformasiMentor(navController, userViewModel)
        }
        composable(Route.SEARCH) {
            SearchScreen(navController)
        }
        composable(Route.PROFILE) {
            Profil(navController, userViewModel)
        }
        composable(Route.FORMMENTOR){
            FormMentor(navController, userViewModel)
        }
        composable(Route.PEMBERITAHUANBEMENTOR){
            PemberitahuanBeMentor(navController)
        }
        composable(Route.RIWAYAT){
            Riwayat(navController, userViewModel)
        }
        composable(Route.REVIEWMENTOR){
            ReviewMentor(navController)
        }
        composable(Route.INPUTREVIEWMENTOR){
            InputReviewMentor(navController)
        }
    }
}