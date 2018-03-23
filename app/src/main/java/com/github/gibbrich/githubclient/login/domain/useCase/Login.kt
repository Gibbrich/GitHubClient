package com.github.gibbrich.githubclient.login.domain.useCase

import com.github.gibbrich.githubclient.base.IRequestValue
import com.github.gibbrich.githubclient.base.UseCase
import com.github.gibbrich.githubclient.model.user.User
import com.github.gibbrich.githubclient.model.user.source.IUserSource
import io.reactivex.Flowable
import io.reactivex.Scheduler

/**
 * Created by Dvurechenskiyi on 23.03.2018.
 */
class Login(
        executionScheduler: Scheduler,
        postExecutionScheduler: Scheduler,
        private val userSource: IUserSource
): UseCase<LoginRequestValue, User>(executionScheduler, postExecutionScheduler)
{
    override fun buildUseCaseFlowable(requestValue: LoginRequestValue): Flowable<User>
    {
        return userSource.getUser(requestValue.userName).toFlowable()
    }
}

data class LoginRequestValue(val userName: String): IRequestValue