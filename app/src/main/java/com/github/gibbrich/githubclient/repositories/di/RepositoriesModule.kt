package com.github.gibbrich.githubclient.repositories.di

import com.github.gibbrich.githubclient.GitHubAPI
import com.github.gibbrich.githubclient.di.ActivityScope
import com.github.gibbrich.githubclient.model.repo.source.IReposSource
import com.github.gibbrich.githubclient.model.repo.source.ReposRemoteSource
import com.github.gibbrich.githubclient.repositories.IRepositoriesContract
import com.github.gibbrich.githubclient.repositories.RepositoriesAdapter
import com.github.gibbrich.githubclient.repositories.RepositoriesPresenter
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 * Created by Dvurechenskiyi on 15.03.2018.
 */

@Module
class RepositoriesModule(
        private val view: IRepositoriesContract.View,
        private val userName: String
)
{
    @Provides
    @ActivityScope
    fun provideView(): IRepositoriesContract.View
    {
        return view
    }

    @Provides
    @ActivityScope
    fun providePresenter(reposSource: IReposSource): IRepositoriesContract.Presenter
    {
        return RepositoriesPresenter(view, reposSource, userName)
    }

    @Provides
    @ActivityScope
    fun provideRepositoriesAdapter() = RepositoriesAdapter(emptyList())
}