package com.github.gibbrich.githubclient.repositoryDetail.domain.useCase

import com.github.gibbrich.githubclient.base.IRequestValue
import com.github.gibbrich.githubclient.base.UseCase
import com.github.gibbrich.githubclient.model.repo.Repo
import com.github.gibbrich.githubclient.model.repo.source.IReposSource
import io.reactivex.Flowable
import io.reactivex.Scheduler

/**
 * Created by Dvurechenskiyi on 23.03.2018.
 */
class GetRepo(
        executionScheduler: Scheduler,
        postExecutionScheduler: Scheduler,
        private val reposSource: IReposSource
): UseCase<GetRepoRequestValue, Repo>(executionScheduler, postExecutionScheduler)
{
    override fun buildUseCaseFlowable(requestValue: GetRepoRequestValue): Flowable<Repo>
    {
        return reposSource.getRepo(requestValue.repoID).toFlowable()
    }
}

data class GetRepoRequestValue(val repoID: Int): IRequestValue