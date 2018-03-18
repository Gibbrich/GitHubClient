package com.github.gibbrich.githubclient.di

import android.arch.persistence.room.Room
import android.content.Context
import com.github.gibbrich.githubclient.AppDatabase
import com.github.gibbrich.githubclient.GitHubAPI
import com.github.gibbrich.githubclient.model.repo.source.RepoDao
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by Артур on 14.03.2018.
 */

@Module
class AppModule(private val context: Context)
{
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit
    {
        return Retrofit
                .Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    @Provides
    @Singleton
    fun provideApplicationContext(): Context
    {
        return context
    }

    @Provides
    @Singleton
    fun provideGitHubAPI(retrofit: Retrofit): GitHubAPI
    {
        return retrofit.create(GitHubAPI::class.java)
    }
}