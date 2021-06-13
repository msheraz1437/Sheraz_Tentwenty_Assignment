package com.example.sheraz.ui.movies

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.sheraz.R
import com.example.sheraz.di.modules.AppModule
import com.example.sheraz.repository.model.movies.Movies
import com.example.sheraz.utils.extensions.inflate
import kotlinx.android.synthetic.main.row_movie_list.view.*

/**
 * Created by Sheraz on 04,November,2019
 */

class MoviesAdapter : RecyclerView.Adapter<MoviesAdapter.NewsHolder>() {


    private var moviesArticles: List<Movies> = emptyList()


    var onMoviesClicked: ((Movies) -> Unit)? = null

    /**
     * Inflate the view
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        NewsHolder(parent.inflate(R.layout.row_movie_list))

    /**
     * Bind the view with the data
     */
    override fun onBindViewHolder(newsHolder: NewsHolder, position: Int) =
        newsHolder.bind(moviesArticles[position])

    /**
     * Number of items in the list to display
     */
    override fun getItemCount() = moviesArticles.size

    /**
     * View Holder Pattern
     */
    inner class NewsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        /**
         * Binds the UI with the data and handles clicks
         */
        fun bind(moviesArticle: Movies) = with(itemView) {
            tvMovieReleaseDate.text = moviesArticle.releaseDate
            tvMovieName.text = moviesArticle.title
            //TODO: need to format date
            if(moviesArticle.adult == true)
            tvMovieAdult.text = "Adult"
            else
                tvMovieAdult.text = "Non adult"

            Glide.with(context)
                .load(AppModule.BASE_URL+moviesArticle.url)
                .apply(
                    RequestOptions()
                        .placeholder(R.drawable.dummy)
                        .error(R.drawable.dummy)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                )
                .into(ivMoviesImage)

            itemView.setOnClickListener {
                onMoviesClicked?.invoke(moviesArticle)
            }

        }
    }

    /**
     * Swap function to set new data on updating
     */
    fun replaceItems(items: List<Movies>) {
        moviesArticles = items
        notifyDataSetChanged()
    }
}