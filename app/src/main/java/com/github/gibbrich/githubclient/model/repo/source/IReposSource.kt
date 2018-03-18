package com.github.gibbrich.githubclient.model.repo.source

import com.github.gibbrich.githubclient.model.base.IBaseSource
import com.github.gibbrich.githubclient.model.repo.Repo
import io.reactivex.Flowable
import io.reactivex.Maybe

/**
 * Created by Dvurechenskiyi on 15.03.2018.
 */
interface IReposSource: IBaseSource
{
    fun getRepo(id: Int): Maybe<Repo>
    fun getRepos(userName: String): Flowable<List<Repo>>
    fun deleteAllRepos()
    fun saveAllRepos(repos: List<Repo>)
}