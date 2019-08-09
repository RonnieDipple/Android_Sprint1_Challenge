package com.example.android_sprint1_challenge

import android.net.Uri
import java.io.Serializable

class TitleData (uri: Uri? = null): Serializable{

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