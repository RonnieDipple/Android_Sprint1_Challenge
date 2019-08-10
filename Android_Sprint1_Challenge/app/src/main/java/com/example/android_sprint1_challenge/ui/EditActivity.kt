package com.example.android_sprint1_challenge.ui

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_sprint1_challenge.R
import com.example.android_sprint1_challenge.model.TitleData
import kotlinx.android.synthetic.main.activity_edit.*
import kotlinx.android.synthetic.main.activity_list.*

class EditActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)


        btn_save.setOnClickListener {
            val intent = Intent()
            intent.putExtra(TitleData.TITLE_TAG, creatMovieTitle())
            setResult(RESULT_OK, intent)
            finish()
        }


        var bundle: Bundle? = intent.extras
        if (bundle != null){
            loadMovieTitle(bundle!!.getSerializable(TitleData.TITLE_TAG) as TitleData)
        }

        //TODO need to fix this

       btn_delete.setOnClickListener {
           
        }


    }

    fun loadMovieTitle(movieTitle: TitleData){
        title_editText.setText(movieTitle.title)
    }

   fun creatMovieTitle(): TitleData{
       var newMovieTitle = TitleData(title_editText.text.toString())
       return newMovieTitle

   }


}
