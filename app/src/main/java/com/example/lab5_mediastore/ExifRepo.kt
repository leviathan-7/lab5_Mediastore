package com.example.lab5_mediastore

import android.content.ContentValues
import android.content.Context
import androidx.exifinterface.media.ExifInterface
import android.net.Uri
import android.provider.MediaStore
import android.util.Log
import java.io.File
import java.io.IOException
import java.nio.charset.StandardCharsets
import java.util.Date


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
        navigateBackUri: (Uri) -> Unit,
        TAG_DATETIME: String,
        TAG_GPS_LATITUDE: String,
        TAG_GPS_LONGITUDE: String,
        TAG_MAKE: String,
        TAG_MODEL: String
    ) {
        val contentValues = ContentValues().apply {
            put(MediaStore.Images.Media.DISPLAY_NAME, "teg_maker_${Date()}.jpg")
            put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg")
        }
        val newUri = context.contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues)

        val file = File(context.getExternalFilesDir(null), "t")

        file.outputStream().use{output ->
            uri.let { context.contentResolver.openInputStream(it) }.use{input ->
                val t = input!!.copyTo(output)
                Log.d("long", "$t")
            }
        }

        val exif = ExifInterface(file)
        exif.setAttribute(ExifInterface.TAG_DATETIME, TAG_DATETIME)
        exif.setAttribute(ExifInterface.TAG_GPS_LATITUDE, TAG_GPS_LATITUDE)
        exif.setAttribute(ExifInterface.TAG_GPS_LONGITUDE, TAG_GPS_LONGITUDE)
        exif.setAttribute(ExifInterface.TAG_MAKE, TAG_MAKE)
        exif.setAttribute(ExifInterface.TAG_MODEL, TAG_MODEL)
        exif.saveAttributes()

        file.inputStream().use{input ->
            newUri.let { context.contentResolver.openOutputStream(it!!) }.use{output ->
                val t = input.copyTo(output!!)
                Log.d("long", "$t")
            }
        }

        file.delete()

        navigateBackUri(newUri!!)
    }
}