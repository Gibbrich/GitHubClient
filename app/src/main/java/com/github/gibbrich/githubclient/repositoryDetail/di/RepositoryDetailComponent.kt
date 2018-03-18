package com.github.gibbrich.githubclient.repositoryDetail.di

import com.github.gibbrich.githubclient.di.ActivityScope
import com.github.gibbrich.githubclient.repositoryDetail.RepositoryDetailActivity
import dagger.Subcomponent

/**
 * Created by Артур on 18.03.2018.
 */

@Subcomponent(modules = arrayOf(RepositoryDetailModule::class))
@ActivityScope
interface RepositoryDetailComponent
{
    fun inject(repositoryDetailActivity: RepositoryDetailActivity)
}