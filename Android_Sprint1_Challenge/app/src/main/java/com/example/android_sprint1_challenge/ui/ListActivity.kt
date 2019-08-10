package com.example.android_sprint1_challenge.ui

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.android_sprint1_challenge.R
import com.example.android_sprint1_challenge.model.TitleData
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {
    var movieList = mutableListOf<TitleData>()

    companion object{
        const val REQUEST_CODE_EDIT_MOVIE_TITLE = 2
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        btn_add_movie.setOnClickListener {
            val intent = Intent (this, EditActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE_EDIT_MOVIE_TITLE)
        }


    }

    fun refreshMovieTitleList(){
        movie_list_layout.removeAllViews()
        for((counter, movieTitle) in movieList.withIndex()){
            movie_list_layout.addView(createTextView(movieTitle, counter))
        }

    }

    override fun onPostResume() {

        refreshMovieTitleList()
        super.onPostResume()
    }

    fun createTextView(titleData: TitleData, index: Int): TextView{
        val newMovieTitleView = TextView(this)
        newMovieTitleView.textSize = 15f
        newMovieTitleView.id = index
        newMovieTitleView.text = titleData.title
        movie_list_layout.setBackgroundColor(Color.CYAN)
        newMovieTitleView.setOnClickListener {
            var intent = Intent(this, EditActivity::class.java)
            intent.putExtra(TitleData.TITLE_TAG, movieList[newMovieTitleView.id])
            movieList.removeAt(newMovieTitleView.id)
            startActivityForResult(intent, REQUEST_CODE_EDIT_MOVIE_TITLE)

        }
        return newMovieTitleView
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_CODE_EDIT_MOVIE_TITLE && resultCode == Activity.RESULT_OK) {
            val newResultMovie = data?.getSerializableExtra(TitleData.TITLE_TAG) as TitleData
            movieList.add(newResultMovie)
        }
    }

}
