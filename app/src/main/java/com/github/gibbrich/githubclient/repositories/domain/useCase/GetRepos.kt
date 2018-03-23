package com.github.gibbrich.githubclient.repositories.domain.useCase

import com.github.gibbrich.githubclient.base.IRequestValue
import com.github.gibbrich.githubclient.base.UseCase
import com.github.gibbrich.githubclient.model.repo.Repo
import com.github.gibbrich.githubclient.model.repo.source.IReposSource
import io.reactivex.Flowable
import io.reactivex.Scheduler

/**
 * Created by Dvurechenskiyi on 23.03.2018.
 */
class GetRepos(executionScheduler: Scheduler,
               postExecutionScheduler: Scheduler,
               private val reposSource: IReposSource)
    : UseCase<GetReposRequestValue, List<Repo>>(executionScheduler, postExecutionScheduler)
{
    override fun buildUseCaseFlowable(requestValue: GetReposRequestValue): Flowable<List<Repo>>
    {
        return reposSource.getRepos(requestValue.userName)
    }
}

data class GetReposRequestValue(val userName: String): IRequestValue