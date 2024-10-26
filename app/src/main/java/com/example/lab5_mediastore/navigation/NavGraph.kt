/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.lab5_mediastore.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
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
    NavHost(
        navController = navController,
        startDestination = "Start",
        modifier = modifier
    ) {
        composable(route = "Start") {
            StartView(
                navigateToImageView = {
                    navController.navigate("ImageView")
                }
            )
        }
        composable(route = "ImageView") {
            ImageView(
                navigateToSettings = {
                    navController.navigate("SettingsView")
                },
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }
        composable(route = "SettingsView") {
            SettingsView(
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}