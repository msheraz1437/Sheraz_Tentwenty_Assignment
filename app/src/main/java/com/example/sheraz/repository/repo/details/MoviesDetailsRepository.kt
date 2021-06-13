package com.example.sheraz.repository.repo.details

import androidx.lifecycle.LiveData
import com.example.sheraz.repository.api.ApiServices
import com.example.sheraz.repository.api.network.NetworkResource
import com.example.sheraz.repository.api.network.Resource
import com.example.sheraz.repository.model.details.Images
import com.example.sheraz.repository.model.details.MovieDetail
import javax.inject.Inject
import javax.inject.Singleton



@Singleton
class MoviesDetailsRepository @Inject constructor(
    private val apiServices: ApiServices,
) {

    fun getMoviesList(movieId: Int):
            LiveData<Resource<MovieDetail>> {

        return object : NetworkResource<MovieDetail>() {
            override fun createCall(): LiveData<Resource<MovieDetail>> {
                return apiServices.getMoviesDetails(movieId = movieId)
            }

        }.asLiveData()
    }
    fun getImagesList(movieId: Int):
            LiveData<Resource<Images>> {


        return object : NetworkResource<Images>() {
            override fun createCall(): LiveData<Resource<Images>> {
                return apiServices.getImagesList(movieId = movieId)
            }

        }.asLiveData()
    }

}