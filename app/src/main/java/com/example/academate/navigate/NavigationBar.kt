package com.example.academate.navigate

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.academate.R
import com.example.academate.component.SearchScreen
import com.example.academate.ui.presentation.DaftarMentor
import com.example.academate.ui.presentation.FormMentor
import com.example.academate.ui.presentation.HomeScreen
import com.example.academate.ui.presentation.InformasiMentor
import com.example.academate.ui.presentation.InformasiRPL
import com.example.academate.ui.presentation.InputReviewMentor
import com.example.academate.ui.presentation.Login
import com.example.academate.ui.presentation.MataKuliah
import com.example.academate.ui.presentation.PemberitahuanBeMentor
import com.example.academate.ui.presentation.Profil
import com.example.academate.ui.presentation.ReviewMentor
import com.example.academate.ui.presentation.Riwayat
import com.example.academate.ui.presentation.SignUp
import com.example.academate.ui.presentation.SplashScreen
import com.example.academate.ui.presentation.onBoarding1
import com.example.academate.ui.presentation.onBoarding2
import com.example.academate.ui.theme.BiruMuda

@Composable
fun NavigasiBar(
//    items: List<BottomNavItem>,
    navController: NavController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavItem) -> Unit
) {

    val bottomBarList = listOf(
        BottomNavItem(
            name = "Home",
            route = Route.HOME,
            icon = painterResource(id = R.drawable.navigation_home)
        ),
        BottomNavItem(
            name = "Matkul",
            route = Route.MATAKULIAH,
            icon = painterResource(id = R.drawable.navigation_book_open)
        ),
        BottomNavItem(
            name = "Search",
            route = Route.SEARCH,
            icon = painterResource(id = R.drawable.navigation_search)
        ),
        BottomNavItem(
            name = "Profile",
            route = Route.PROFILE,
            icon = painterResource(id = R.drawable.navigation_user)
        ),
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val backStackEntry = navController.currentBackStackEntryAsState()
        NavigationBar(
            modifier = modifier,
            containerColor = Color.White,
            tonalElevation = 5.dp
        ) {
            bottomBarList.forEach { item ->
                val selected = item.route == backStackEntry.value?.destination?.route
                NavigationBarItem(
                    selected = selected,
//                    onClick = { onItemClick(item.route) },
                    { onItemClick(item.route, navController = navController) },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color.Blue,
                        unselectedIconColor = Color.Gray
                    ),
                    icon = {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(
                                painter = item.icon,
                                contentDescription = item.name,
                                modifier = modifier
                                    .size(30.dp)
                            )
                        }
                        if (selected) {
                            Text(
                                text = item.name,
                                textAlign = TextAlign.Center,
                                fontSize = 10.sp,
                                modifier = Modifier
                                    .padding(top = 25.dp, start = 2.dp)
                            )
                        }
                    }
                )
            }
        }
    }
}

fun onItemClick(route: String, navController: NavController) {
    navController.navigate(route)

}

@Composable
fun Navigasi(
    navController: NavHostController
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
        composable(Route.INFORMASIRPL) {
            InformasiRPL(navController)
        }
        composable(Route.DAFTARMENTORRPL){
            DaftarMentor(navController)
        }
        composable(Route.INFORMASIMENTOR) {
            InformasiMentor()
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