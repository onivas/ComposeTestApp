package com.savinoordine.cardlayoutcomposeapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.savinoordine.cardlayoutcomposeapp.UserListScreen
import com.savinoordine.cardlayoutcomposeapp.detail.UserDetailScreen
import com.savinoordine.cardlayoutcomposeapp.model.UserProfile
import com.savinoordine.cardlayoutcomposeapp.model.userProfileList

@Composable
fun UserNavigation(userProfiles: List<UserProfile> = userProfileList) {
    val navController: NavHostController = rememberNavController()
    NavHost(navController = navController, startDestination = "user_list") {
        composable("user_list") {
            UserListScreen(userProfiles = userProfiles, navController)
        }
        composable(
            route = "user_detail/{userId}",
            arguments = listOf(navArgument("userId") {
                type = NavType.IntType
            })
        ) {
            UserDetailScreen(it.arguments!!.getInt("userId"))
        }
    }
}