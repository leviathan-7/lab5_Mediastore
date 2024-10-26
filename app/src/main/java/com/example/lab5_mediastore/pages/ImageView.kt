package com.example.lab5_mediastore.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.example.lab5_mediastore.navigation.TopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ImageView(
    modifier: Modifier = Modifier,
    navigateToSettings: () -> Unit,
    navigateBack: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth().fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        TopAppBar(
            title = "Данные изображения",
            canNavigateBack = true,
            navigateUp = navigateBack
        )
        Text(
            text = "ImageView",
            modifier = modifier
        )
        Button(
            onClick = {navigateToSettings()},
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xffff9115)
            )
        ) { Text(
            text = "Изменить теги",
            fontSize = 25.sp
        ) }
    }

}