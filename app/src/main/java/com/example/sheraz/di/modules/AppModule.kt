package com.example.sheraz.di.modules

import android.content.Context
import android.content.res.Resources
import androidx.room.Room
import com.example.sheraz.repository.api.ApiServices
import com.example.sheraz.repository.db.AppDatabase
import com.example.sheraz.repository.db.movies.MoviesDao
import com.example.sheraz.app.App
import com.example.sheraz.repository.api.network.LiveDataCallAdapterFactoryForRetrofit
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by Sheraz on 04,November,2019
 */

@Module(includes = [PreferencesModule::class, ActivityModule::class, ViewModelModule::class])
class AppModule {

    /**
     * Static variables to hold base url's etc.
     */
    companion object {
        const val BASE_URL = "https://api.themoviedb.org";
    }


    /**
     * Provides ApiServices client for Retrofit
     */
    @Singleton
    @Provides
    fun provideNewsService(): ApiServices {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(LiveDataCallAdapterFactoryForRetrofit())
            .build()
            .create(ApiServices::class.java)
    }


    /**
     * Provides app AppDatabase
     */
    @Singleton
    @Provides
    fun provideDb(context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "movies-db")
            .fallbackToDestructiveMigration().build()


    /**
     * Provides NewsArticlesDao an object to access NewsArticles table from Database
     */
    @Singleton
    @Provides
    fun provideUserDao(db: AppDatabase): MoviesDao = db.moviesDao()

    /**
     * Application application level context.
     */
    @Singleton
    @Provides
    fun provideContext(application: App): Context = application.applicationContext


    /**
     * Application resource provider, so that we can get the Drawable, Color, String etc at runtime
     */
    @Provides
    @Singleton
    fun providesResources(application: App): Resources = application.resources
}
