package com.example.sheraz.repository.api

import androidx.lifecycle.LiveData
import com.example.sheraz.repository.api.network.Resource
import com.example.sheraz.repository.model.details.Images
import com.example.sheraz.repository.model.details.MovieDetail
import com.example.sheraz.repository.model.movies.MoviesSource
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiServices {

    @GET("/3/movie/upcoming?api_key=ff81711a9e9b79bceb508d9b9d8b6600")
    fun getNewsSource(): LiveData<Resource<MoviesSource>>

    @GET("/3/movie/{movieId}?api_key=ff81711a9e9b79bceb508d9b9d8b6600")
    fun getMoviesDetails(@Path("movieId") movieId : Int): LiveData<Resource<MovieDetail>>

    @GET("/3/movie/{movieId}/images?api_key=ff81711a9e9b79bceb508d9b9d8b6600")
    fun getImagesList(@Path("movieId") movieId : Int): LiveData<Resource<Images>>

}
