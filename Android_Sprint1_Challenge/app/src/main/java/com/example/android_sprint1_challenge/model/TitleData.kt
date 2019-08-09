package com.example.android_sprint1_challenge.model

import android.net.Uri
import java.io.Serializable

class TitleData (uri: Uri? = null, var movieTitle:String): Serializable{

    companion object{
        const val TITLE_TAG = "title"
    }
    private var uriString = uri.toString()

    fun getUri(): Uri{
        return Uri.parse(uriString)
    }

    fun setUri(uri: Uri?){
        uriString = uri.toString()
    }

}