package com.example.android_sprint1_challenge.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.android_sprint1_challenge.R
import com.example.android_sprint1_challenge.model.TitleData
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {

    companion object{
        const val ADD_TITLE_CODE = 69
    }

    private val titleList = mutableListOf<TitleData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        btn_add_movie.setOnClickListener {
            val intent = Intent (this, EditActivity::class.java)
            startActivityForResult(intent,
                ADD_TITLE_CODE
            )
        }
    }

    fun createTextView(titleData: TitleData, index: Int): TextView{
        val textView = TextView(this)
        textView.textSize = 15f
        //TODO may display title wrong
        textView.text = titleData.movieTitle

        return textView
    }

    fun populateList(index: Int){
        movie_list_layout.removeAllViews()
        for (titleData in titleList){
            movie_list_layout.addView(createTextView(titleData, index))
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == ADD_TITLE_CODE && resultCode == Activity.RESULT_OK){
            val titleData = data?.getSerializableExtra(TitleData.TITLE_TAG) as TitleData
            titleList.add(titleData)
            populateList(titleList.size-1)
        }
    }
}
