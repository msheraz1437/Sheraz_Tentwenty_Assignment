package com.example.sheraz.di.modules

import com.example.sheraz.ui.details.DetailsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class FragmentModule {

    /**
     * Injecting Fragments
     */
    @ContributesAndroidInjector
    internal abstract fun contributeDetailsListFragment(): DetailsFragment
}