package com.github.gibbrich.githubclient.di

import com.github.gibbrich.githubclient.AppDatabase
import com.github.gibbrich.githubclient.GitHubAPI
import com.github.gibbrich.githubclient.model.repo.source.IReposSource
import com.github.gibbrich.githubclient.model.repo.source.RepoLocalSource
import com.github.gibbrich.githubclient.model.repo.source.RepoRepository
import com.github.gibbrich.githubclient.model.repo.source.ReposRemoteSource
import com.github.gibbrich.githubclient.model.user.source.IUserSource
import com.github.gibbrich.githubclient.model.user.source.UserLocalSource
import com.github.gibbrich.githubclient.model.user.source.UserRemoteSource
import com.github.gibbrich.githubclient.model.user.source.UserRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Артур on 17.03.2018.
 */

@Module
class DatabaseModule(private val db: AppDatabase)
{
    @Provides
    @Singleton
    fun provideRepoRepository(gitHubAPI: GitHubAPI): IReposSource
    {
        val repoLocalSource = RepoLocalSource(db.repoDao())
        val repoRemoteSource = ReposRemoteSource(gitHubAPI)
        return RepoRepository(repoLocalSource, repoRemoteSource)
    }

    @Provides
    @Singleton
    fun provideUserRepository(gitHubAPI: GitHubAPI): IUserSource
    {
        val userRemoteSource = UserRemoteSource(gitHubAPI)
        val userLocalSource = UserLocalSource(db.userDao())
        return UserRepository(userLocalSource, userRemoteSource)
    }
}