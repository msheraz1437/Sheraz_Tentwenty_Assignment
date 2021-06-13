package com.example.sheraz.ui.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.sheraz.repository.api.network.Resource
import com.example.sheraz.repository.model.details.Images
import com.example.sheraz.repository.model.details.MovieDetail
import com.example.sheraz.repository.repo.details.MoviesDetailsRepository
import javax.inject.Inject

/**
 * Created by Sheraz on 08,November,2019
 */

/**
 * A container for [MovieDetail] related data to show on the UI.
 */
class DetailsViewModel @Inject constructor(private val moviesDetailsRepository: MoviesDetailsRepository) :
    ViewModel() {
    private fun moviesDetail(movieId: Int): LiveData<Resource<MovieDetail>> =
            moviesDetailsRepository.getMoviesList(movieId)

    private fun imagesList(movieId: Int): LiveData<Resource<Images>> =
            moviesDetailsRepository.getImagesList(movieId)

    fun getMoviesList(movieId: Int) = moviesDetail(movieId)

    fun getImagesList(movieId: Int) = imagesList(movieId)
}