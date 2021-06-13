package com.example.sheraz.di.modules


import com.example.sheraz.ui.details.DetailsActivity
import com.example.sheraz.ui.movies.MoviesActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Sheraz on 04,November,2019
 */

/**
 * All your Activities participating in DI would be listed here.
 */
@Module(includes = [FragmentModule::class]) // Including Fragment Module Available For Activities
abstract class ActivityModule {

    /**
     * Marking Activities to be available to contributes for Android Injector
     */
    @ContributesAndroidInjector
    abstract fun contributeMoviesArticlesActivity(): MoviesActivity

    @ContributesAndroidInjector
    abstract fun contributeMoviesDetailsListingActivity(): DetailsActivity
}
