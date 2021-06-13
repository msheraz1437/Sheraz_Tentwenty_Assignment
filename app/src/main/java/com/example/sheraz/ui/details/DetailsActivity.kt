package com.example.sheraz.ui.details

import android.os.Bundle
import com.example.sheraz.R
import com.example.sheraz.ui.BaseActivity
import com.example.sheraz.ui.movies.MoviesActivity


/**
 * Created by Sheraz on 08,November,2019
 */
class DetailsActivity : BaseActivity() {

    /**
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, DetailsFragment.newInstance(intent.getIntExtra(
                    MoviesActivity.Movie_ID,0)))
                .commit()
        }
    }
}
