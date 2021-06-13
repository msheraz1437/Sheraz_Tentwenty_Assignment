package com.example.sheraz.ui.movies

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sheraz.R
import com.example.sheraz.ui.BaseActivity
import com.example.sheraz.ui.details.DetailsActivity
import com.example.sheraz.utils.ToastUtil
import com.example.sheraz.utils.extensions.load
import kotlinx.android.synthetic.main.activity_movie_list.*
import kotlinx.android.synthetic.main.empty_layout_movie_list.*
import kotlinx.android.synthetic.main.progress_layout_news_article.*

/**
 * Created by Sheraz on 04,November,2019
 */

class MoviesActivity : BaseActivity() {


    companion object {
        val Movie_ID: String = "Movie_ID"
    }

    private lateinit var adapter: MoviesAdapter

    private val moviesArticleViewModel: MoviesViewModel by viewModels {
        viewModelFactory
    }

    /**
     * On Create Of Activity
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list)

        movie_list.setEmptyView(empty_view)
        movie_list.setProgressView(progress_view)

        adapter = MoviesAdapter()
        adapter.onMoviesClicked = {
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra(MoviesActivity.Movie_ID, it.id)
            startActivity(intent)
        }

        movie_list.adapter = adapter
        movie_list.layoutManager = LinearLayoutManager(this)

        getMoviesOfCountry();
    }

    private fun getMoviesOfCountry() {
        moviesArticleViewModel.getMoviesArticles().observe(this, Observer {
            when {
                it.status.isLoading() -> {
                    movie_list.showProgressView()
                }
                it.status.isSuccessful() -> {
                    it?.load(movie_list) { movies ->
                        adapter.replaceItems(movies!!)
                    }
                }
                it.status.isError() -> {
                    if (it.errorMessage != null)
                        ToastUtil.showCustomToast(this, it.errorMessage.toString())
                }
            }
        })
    }
}
