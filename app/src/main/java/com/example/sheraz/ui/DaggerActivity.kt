package com.example.sheraz.ui

import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

/**
 * Created by Sheraz on 04,November,2019
 * Updated to dagger 2.27, 29, September 2020
 */

// Referring this class as BaseActivity

typealias BaseActivity = DaggerActivity

/**
 * Activity providing Dagger support and [ViewModel] support
 */
abstract class DaggerActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
}
