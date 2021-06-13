package com.example.sheraz.repository.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.sheraz.repository.db.movies.MoviesDao
import com.example.sheraz.repository.model.movies.Movies

/**
 * Created by Sheraz on 04,November,2019
 */

/**
 * App Database
 * Define all entities and access doa's here/ Each entity is a table.
 */
@Database(entities = [Movies::class], version = 3, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    /**
     * Get DAO's
     */
    abstract fun moviesDao(): MoviesDao

}