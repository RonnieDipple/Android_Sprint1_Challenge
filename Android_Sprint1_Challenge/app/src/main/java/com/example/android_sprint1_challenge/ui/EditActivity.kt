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
    companion object{
        const val TITLE_REQUEST_CODE = 96
    }

    private var titleData = TitleData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)


        btn_save.setOnClickListener {
            val intent = Intent()
            titleData.getUri().toString()
            intent.putExtra(TitleData.TITLE_TAG, titleData)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

        btn_delete.setOnClickListener {
            val intent = Intent(Intent.ACTION_DELETE)
            movie_list_layout.removeViewAt(ListActivity.ADD_TITLE_CODE)
            intent.type = "text/plain"
            startActivityForResult(intent,
                TITLE_REQUEST_CODE
            )
        }




    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == TITLE_REQUEST_CODE && resultCode == Activity.RESULT_OK){
            titleData.setUri(data?.data)
        }
    }



}
