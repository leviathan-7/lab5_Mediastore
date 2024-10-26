package com.example.lab5_mediastore

import android.content.Context
import android.media.ExifInterface
import android.net.Uri
import java.io.IOException


class ExifRepo(
    private val uri: Uri,
    private val context: Context
) {
    private val noInf = "no information"
    private fun getExif(): ExifInterface{
        return ExifInterface(context.contentResolver.openInputStream(uri)!!)
    }
    fun getTAG_DATETIME(): String{
        return try {
            getExif().getAttribute(ExifInterface.TAG_DATETIME)!!
        } catch (e: IOException) { noInf }
    }
    fun getTAG_GPS_LATITUDE(): String{
        return try {
            getExif().getAttribute(ExifInterface.TAG_GPS_LATITUDE)!!
        } catch (e: IOException) { noInf }
    }
    fun getTAG_GPS_LONGITUDE(): String{
        return try {
            getExif().getAttribute(ExifInterface.TAG_GPS_LONGITUDE)!!
        } catch (e: IOException) { noInf }
    }
    fun getTAG_MAKE(): String{
        return try {
            getExif().getAttribute(ExifInterface.TAG_MAKE)!!
        } catch (e: IOException) { noInf }
    }
    fun getTAG_MODEL(): String{
        return try {
            getExif().getAttribute(ExifInterface.TAG_MODEL)!!
        } catch (e: IOException) { noInf }
    }
    fun saveNewTags(
        navigateBack: () -> Unit,
        TAG_DATETIME: String,
        TAG_GPS_LATITUDE: String,
        TAG_GPS_LONGITUDE: String,
        TAG_MAKE: String,
        TAG_MODEL: String
    ) {

        navigateBack()
    }
}