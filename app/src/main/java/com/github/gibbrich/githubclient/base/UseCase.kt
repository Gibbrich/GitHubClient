package com.github.gibbrich.githubclient.base

import io.reactivex.Flowable
import io.reactivex.Scheduler

/**
 * Created by Dvurechenskiyi on 23.03.2018.
 */
abstract class UseCase<in Req: IRequestValue, Resp>
protected constructor(
        private val executionScheduler: Scheduler,
        private val postExecutionScheduler: Scheduler
)
{
    abstract fun buildUseCaseFlowable(requestValue: Req): Flowable<Resp>

    fun execute(requestValue: Req): Flowable<Resp>
    {
        return buildUseCaseFlowable(requestValue)
                .subscribeOn(executionScheduler)
                .observeOn(postExecutionScheduler)
    }
}

interface IRequestValue