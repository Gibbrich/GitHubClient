package com.github.gibbrich.githubclient.model.repo.source

import com.github.gibbrich.githubclient.model.repo.Repo
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers

/**
 * Created by Артур on 17.03.2018.
 */
class RepoLocalSource (private val repoDao: RepoDao): IReposSource
{
    override fun deleteAllRepos()
    {
        performActionOnBackground { repoDao.deleteAllRepos() }
    }

    override fun getRepos(userName: String) = repoDao.getRepos()

    override fun saveAllRepos(repos: List<Repo>)
    {
        performActionOnBackground { repoDao.insertRepos(repos) }
    }

    override fun invalidateData()
    {
        // do nothing
    }

    private fun performActionOnBackground(action: () -> Unit)
    {
        Completable.fromAction(action)
                .subscribeOn(Schedulers.io())
                .subscribe()
    }
}