package com.github.gibbrich.githubclient.di

import com.github.gibbrich.githubclient.login.di.LoginComponent
import com.github.gibbrich.githubclient.login.di.LoginModule
import com.github.gibbrich.githubclient.repositories.di.RepositoriesComponent
import com.github.gibbrich.githubclient.repositories.di.RepositoriesModule
import com.github.gibbrich.githubclient.repositoryDetail.di.RepositoryDetailComponent
import com.github.gibbrich.githubclient.repositoryDetail.di.RepositoryDetailModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Артур on 14.03.2018.
 */

@Singleton
@Component(modules = arrayOf(AppModule::class, DatabaseModule::class))
interface AppComponent
{
    fun plusLoginComponent(module: LoginModule): LoginComponent
    fun plusRepositoriesComponent(module: RepositoriesModule): RepositoriesComponent
    fun plusRepositoryDetailComponent(module: RepositoryDetailModule): RepositoryDetailComponent
}