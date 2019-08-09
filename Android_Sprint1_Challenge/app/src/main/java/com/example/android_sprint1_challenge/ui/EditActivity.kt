package com.example.android_sprint1_challenge.ui

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_sprint1_challenge.R
import com.example.android_sprint1_challenge.model.TitleData
import kotlinx.android.synthetic.main.activity_edit.*

class EditActivity : AppCompatActivity() {
    companion object{
        const val TITL_REQUEST_CODE = 96
    }

    private var titleData = TitleData("")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)


        btn_save.setOnClickListener {
            titleData.getUri().toString()
            btn_toggle.textOn
            val intent = Intent()
            intent.putExtra(TitleData.TITLE_TAG, titleData)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

        btn_delete.setOnClickListener {
            val intent = Intent(Intent.ACTION_DELETE)
            intent.type = "text/plain"
            startActivityForResult(intent,
                TITL_REQUEST_CODE
            )
        }




    }



   /* override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == TITL_REQUEST_CODE && resultCode == Activity.RESULT_OK){
            titleData.setUri(data?.data)
        }
    }
    */


}
