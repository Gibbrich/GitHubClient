package com.github.gibbrich.githubclient

import android.app.Application
import android.arch.persistence.room.Room
import com.facebook.stetho.Stetho
import com.github.gibbrich.githubclient.di.AppComponent
import com.github.gibbrich.githubclient.di.AppModule
import com.github.gibbrich.githubclient.di.DaggerAppComponent
import com.github.gibbrich.githubclient.di.DatabaseModule

/**
 * Created by Артур on 14.03.2018.
 */
class GitHubClientApplication : Application()
{
    lateinit var appComponent: AppComponent
    private lateinit var db: AppDatabase

    override fun onCreate()
    {
        super.onCreate()

        INSTANCE = this
        db = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "GitHubClientAppDB.db3").build()
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .databaseModule(DatabaseModule(db))
                .build()

        Stetho.initializeWithDefaults(this)
    }

    companion object
    {
        lateinit var INSTANCE: GitHubClientApplication
            private set
    }
}