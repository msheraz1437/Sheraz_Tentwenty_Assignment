package com.example.sheraz.repository.db.movies

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.sheraz.repository.model.movies.Movies

/**
 * Created by Sheraz on 04,November,2019
 */

@Dao
interface MoviesDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMoviesData(articles: List<Movies>): List<Long>

    @Query("SELECT * FROM movies_table")
    fun getMoviesList(): LiveData<List<Movies>>

    @Query("DELETE FROM movies_table")
    abstract fun deleteAllMovies()
}