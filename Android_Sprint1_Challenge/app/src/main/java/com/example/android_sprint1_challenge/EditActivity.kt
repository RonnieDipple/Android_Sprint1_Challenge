package com.example.android_sprint1_challenge

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit.*
import kotlinx.android.synthetic.main.activity_list.*

class EditActivity : AppCompatActivity() {

    private var titleData = TitleData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)


        btn_save.setOnClickListener {
            titleData.getUri().toString()
            val intent = Intent()
            intent.putExtra(TitleData.TITLE_TAG, titleData)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }



    }


}
