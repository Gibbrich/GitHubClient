package com.github.gibbrich.githubclient.model.repo.source

import com.github.gibbrich.githubclient.model.base.BaseRepository
import com.github.gibbrich.githubclient.model.repo.Repo
import io.reactivex.Flowable
import io.reactivex.Maybe

/**
 * Created by Артур on 17.03.2018.
 */
class RepoRepository(
        localSource: IReposSource,
        remoteSource: IReposSource
): BaseRepository<Repo, IReposSource>(localSource, remoteSource), IReposSource
{
    override fun getRepo(id: Int): Maybe<Repo>
    {
        // todo consider using cache and remote
        return localSource.getRepo(id)
    }

    override fun getRepos(userName: String): Flowable<List<Repo>>
    {
        if (!isCacheDirty)
        {
            if (!cache.isEmpty())
            {
                return Flowable.fromIterable(cache.values).toList().toFlowable()
            }
            else
            {
                return localSource.getRepos(userName)
            }
        }

        deleteAllRepos()

        return remoteSource.getRepos(userName)
                .doOnNext { saveAllRepos(it) }
                .doOnComplete { isCacheDirty = false }
    }

    override fun deleteAllRepos()
    {
        cache.clear()
        localSource.deleteAllRepos()
    }

    override fun saveAllRepos(repos: List<Repo>)
    {
        repos.forEach { cache.put(it.hashCode(), it) }
        localSource.saveAllRepos(repos)
    }
}