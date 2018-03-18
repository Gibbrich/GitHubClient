package com.github.gibbrich.githubclient.repositoryDetail.di

import com.github.gibbrich.githubclient.di.ActivityScope
import com.github.gibbrich.githubclient.model.repo.source.IReposSource
import com.github.gibbrich.githubclient.repositoryDetail.IRepositoryDetailContract
import com.github.gibbrich.githubclient.repositoryDetail.RepositoryDetailPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by Артур on 18.03.2018.
 */

@Module
class RepositoryDetailModule(
        private val view: IRepositoryDetailContract.View,
        private val repositoryID: Int
)
{
    @ActivityScope
    @Provides
    fun providePresenter(repoSource: IReposSource): IRepositoryDetailContract.Presenter
    {
        return RepositoryDetailPresenter(view, repoSource, repositoryID)
    }
}