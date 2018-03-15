package com.github.gibbrich.githubclient

import android.app.Application
import com.github.gibbrich.githubclient.di.AppComponent
import com.github.gibbrich.githubclient.di.DaggerAppComponent

/**
 * Created by Артур on 14.03.2018.
 */
class GitHubClientApplication : Application()
{
    lateinit var appComponent: AppComponent

    override fun onCreate()
    {
        super.onCreate()

        INSTANCE = this
        appComponent = DaggerAppComponent.create()
    }

    companion object
    {
        lateinit var INSTANCE: GitHubClientApplication
            private set
    }
}