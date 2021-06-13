package com.example.sheraz.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.sheraz.repository.api.network.Resource
import com.example.sheraz.repository.model.movies.Movies
import com.example.sheraz.repository.repo.movies.MoviesRepository
import javax.inject.Inject

/**
 * Created by Sheraz on 04,November,2019
 */

/**
 * A container for [Movies] related data to show on the UI.
 */
class MoviesViewModel @Inject constructor(
    private val moviesRepository: MoviesRepository
) : ViewModel() {

    private fun moviesArticles(): LiveData<Resource<List<Movies>?>> =
        moviesRepository.getMoviesList()


    fun getMoviesArticles() = moviesArticles()

}