package com.example.sheraz.app

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import com.example.sheraz.di.components.DaggerAppComponent

/**
 * Created by Sheraz on 04,November,2019
 */

class App : DaggerApplication() {

    private val applicationInjector = DaggerAppComponent.builder().application(this).build()

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = applicationInjector

}