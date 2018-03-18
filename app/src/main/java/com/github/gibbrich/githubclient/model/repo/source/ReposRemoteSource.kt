package com.github.gibbrich.githubclient.model.repo.source

import com.github.gibbrich.githubclient.GitHubAPI
import com.github.gibbrich.githubclient.model.repo.Repo
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

/**
 * Created by Dvurechenskiyi on 15.03.2018.
 */

class ReposRemoteSource (private val gitHubAPI: GitHubAPI): IReposSource
{
    override fun getRepos(userName: String): Flowable<List<Repo>>
    {
        return gitHubAPI.getRepositories(userName)
                .flatMap {
                    Flowable.fromIterable(it)
                            .map {
                                Repo(it.id, it.name).apply {
                                    forksCount = it.forksCount
                                    watchersCount = it.watchersCount
                                }
                            }
                            .toList()
                            .toFlowable()
                }
    }

    override fun deleteAllRepos()
    {
        // do nothing
    }

    override fun saveAllRepos(repos: List<Repo>)
    {
        // do nothing
    }

    override fun invalidateData()
    {
        // do nothing
    }
}