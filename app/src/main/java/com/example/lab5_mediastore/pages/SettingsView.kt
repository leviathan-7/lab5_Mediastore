package com.example.lab5_mediastore.pages

import android.content.ContentValues
import android.net.Uri
import android.provider.MediaStore
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.sp
import com.example.lab5_mediastore.ExifRepo
import com.example.lab5_mediastore.navigation.TopAppBar
import java.util.Date

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsView(
    modifier: Modifier = Modifier,
    navigateBack: () -> Unit,
    navigateBackUri: (Uri) -> Unit,
    uri: Uri
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
        val repo = ExifRepo(uri, LocalContext.current)

        var TAG_DATETIME by remember { mutableStateOf(repo.getTAG_DATETIME()) }
        OutlinedTextField(
            value = TAG_DATETIME,
            onValueChange = { TAG_DATETIME = it },
            label = { Text("Время", fontSize = 20.sp) },
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                unfocusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer,
            ),
            modifier = Modifier.fillMaxWidth(),
            enabled = true,
            singleLine = true
        )
        var TAG_GPS_LATITUDE by remember { mutableStateOf(repo.getTAG_GPS_LATITUDE()) }
        OutlinedTextField(
            value = TAG_GPS_LATITUDE,
            onValueChange = { TAG_GPS_LATITUDE = it },
            label = { Text("Широта", fontSize = 20.sp) },
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                unfocusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer,
            ),
            modifier = Modifier.fillMaxWidth(),
            enabled = true,
            singleLine = true
        )
        var TAG_GPS_LONGITUDE by remember { mutableStateOf(repo.getTAG_GPS_LONGITUDE()) }
        OutlinedTextField(
            value = TAG_GPS_LONGITUDE,
            onValueChange = { TAG_GPS_LONGITUDE = it },
            label = { Text("Долгота", fontSize = 20.sp) },
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                unfocusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer,
            ),
            modifier = Modifier.fillMaxWidth(),
            enabled = true,
            singleLine = true
        )
        var TAG_MAKE by remember { mutableStateOf(repo.getTAG_MAKE()) }
        OutlinedTextField(
            value = TAG_MAKE,
            onValueChange = { TAG_MAKE = it },
            label = { Text("Устройство", fontSize = 20.sp) },
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                unfocusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer,
            ),
            modifier = Modifier.fillMaxWidth(),
            enabled = true,
            singleLine = true
        )
        var TAG_MODEL by remember { mutableStateOf(repo.getTAG_MODEL()) }
        OutlinedTextField(
            value = TAG_MODEL,
            onValueChange = { TAG_MODEL = it },
            label = { Text("Модель", fontSize = 20.sp) },
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                unfocusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer,
            ),
            modifier = Modifier.fillMaxWidth(),
            enabled = true,
            singleLine = true
        )
        Text(
            text = "\n",
            fontSize = 10.sp
        )
        Button(
            onClick = {
                repo.saveNewTags(
                    navigateBackUri = navigateBackUri,
                    TAG_DATETIME = TAG_DATETIME,
                    TAG_GPS_LATITUDE = TAG_GPS_LATITUDE,
                    TAG_GPS_LONGITUDE = TAG_GPS_LONGITUDE,
                    TAG_MAKE = TAG_MAKE,
                    TAG_MODEL = TAG_MODEL
                )
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xffff9115)
            )
        ) { Text(
            text = "Сохранить",
            fontSize = 25.sp
        ) }
    }

}