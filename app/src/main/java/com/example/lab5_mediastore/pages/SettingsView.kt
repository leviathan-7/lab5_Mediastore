package com.example.lab5_mediastore.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.lab5_mediastore.navigation.TopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsView(
    modifier: Modifier = Modifier,
    navigateBack: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth().fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        TopAppBar(
            title = "Настройка тегов",
            canNavigateBack = true,
            navigateUp = navigateBack
        )
        Text(
            text = "SettingsView",
            modifier = modifier
        )
    }

}