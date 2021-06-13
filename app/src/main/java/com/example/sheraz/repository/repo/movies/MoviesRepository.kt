package com.example.sheraz.repository.repo.movies

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.sheraz.app.AppExecutors
import com.example.sheraz.repository.api.ApiServices
import com.example.sheraz.repository.api.network.NetworkAndDBBoundResource
import com.example.sheraz.repository.api.network.Resource
import com.example.sheraz.repository.db.movies.MoviesDao
import com.example.sheraz.repository.model.movies.Movies
import com.example.sheraz.repository.model.movies.MoviesSource
import com.example.sheraz.utils.ConnectivityUtil
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Sheraz on 04,November,2019
 */

@Singleton
class MoviesRepository @Inject constructor(
    private val moviesDao: MoviesDao,
    private val apiServices: ApiServices, private val context: Context,
    private val appExecutors: AppExecutors = AppExecutors()
) {

    fun getMoviesList(): LiveData<Resource<List<Movies>?>> {


        return object : NetworkAndDBBoundResource<List<Movies>, MoviesSource>(appExecutors) {
            override fun saveCallResult(item: MoviesSource) {
                if (item.results.isNotEmpty()) {
                    moviesDao.deleteAllMovies()
                    moviesDao.insertMoviesData(item.results)
                }
            }

            override fun shouldFetch(data: List<Movies>?) =
                (ConnectivityUtil.isConnected(context))

            override fun loadFromDb() = moviesDao.getMoviesList()

            override fun createCall() =
                apiServices.getNewsSource()

        }.asLiveData()
    }



}