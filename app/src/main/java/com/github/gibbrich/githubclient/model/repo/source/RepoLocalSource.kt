package com.github.gibbrich.githubclient.model.repo.source

import com.github.gibbrich.githubclient.model.repo.Repo
import com.github.gibbrich.githubclient.utils.performActionOnIOScheduler
import io.reactivex.Maybe

/**
 * Created by Артур on 17.03.2018.
 */
class RepoLocalSource (private val repoDao: RepoDao): IReposSource
{
    override fun getRepo(id: Int) = repoDao.getRepo(id)

    override fun deleteAllRepos()
    {
        performActionOnIOScheduler { repoDao.deleteAllRepos() }
    }

    override fun getRepos(userName: String) = repoDao.getRepos()

    override fun saveAllRepos(repos: List<Repo>)
    {
        performActionOnIOScheduler { repoDao.insertRepos(repos) }
    }

    override fun invalidateData()
    {
        // do nothing
    }
}