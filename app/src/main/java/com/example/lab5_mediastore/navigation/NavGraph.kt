package com.example.lab5_mediastore.navigation

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.lab5_mediastore.pages.ImageView
import com.example.lab5_mediastore.pages.SettingsView
import com.example.lab5_mediastore.pages.StartView

/**
 * Provides Navigation graph for the application.
 */
@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    var imageUri: Uri? by rememberSaveable { mutableStateOf(null) }

    NavHost(
        navController = navController,
        startDestination = "Start",
        modifier = modifier
    ) {
        composable(route = "Start") {
            StartView(
                navigateToImageView = {
                    imageUri = it
                    navController.navigate("ImageView")
                }
            )
        }
        composable(
            route = "ImageView"
        ) {
            ImageView(
                navigateToSettings = {
                    navController.navigate("SettingsView")
                },
                navigateBack = {
                    navController.popBackStack()
                },
                uri = imageUri!!
            )
        }
        composable(route = "SettingsView") {
            SettingsView(
                navigateBack = {
                    navController.popBackStack()
                },
                navigateBackUri = {
                    imageUri = it
                    navController.popBackStack()
                },
                uri = imageUri!!
            )
        }
    }
}
