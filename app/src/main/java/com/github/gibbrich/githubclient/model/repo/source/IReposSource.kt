package com.github.gibbrich.githubclient.model.repo.source

import com.github.gibbrich.githubclient.model.repo.Repo
import io.reactivex.Flowable

/**
 * Created by Dvurechenskiyi on 15.03.2018.
 */
interface IReposSource
{
    fun getRepos(userName: String): Flowable<List<Repo>>
}