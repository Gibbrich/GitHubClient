package com.github.gibbrich.githubclient.repositories.di

import com.github.gibbrich.githubclient.di.ActivityScope
import com.github.gibbrich.githubclient.repositories.RepositoriesActivity
import dagger.Subcomponent

/**
 * Created by Dvurechenskiyi on 15.03.2018.
 */

@ActivityScope
@Subcomponent(modules = arrayOf(RepositoriesModule::class))
interface RepositoriesComponent
{
    fun inject(repositoriesActivity: RepositoriesActivity)
}