package com.example.lab5_mediastore.pages

import android.net.Uri
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.lab5_mediastore.ExifRepo
import com.example.lab5_mediastore.navigation.TopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ImageView(
    modifier: Modifier = Modifier,
    navigateToSettings: () -> Unit,
    navigateBack: () -> Unit,
    uri: Uri
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
        AsyncImage(
            model = uri,
            contentDescription = uri.toString()
        )
        val repo = ExifRepo(uri, LocalContext.current)
        Text(
            text = "\n",
            fontSize = 10.sp
        )
        Text(
            text = "Время = " + repo.getTAG_DATETIME(),
            fontSize = 25.sp
        )
        Text(
            text = "Широта = " + repo.getTAG_GPS_LATITUDE(),
            fontSize = 25.sp
        )
        Text(
            text = "Долгота = " + repo.getTAG_GPS_LONGITUDE(),
            fontSize = 25.sp
        )
        Text(
            text = "Устройство = " + repo.getTAG_MAKE(),
            fontSize = 25.sp
        )
        Text(
            text = "Модель = " + repo.getTAG_MODEL(),
            fontSize = 25.sp
        )
        Text(
            text = "\n",
            fontSize = 10.sp
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