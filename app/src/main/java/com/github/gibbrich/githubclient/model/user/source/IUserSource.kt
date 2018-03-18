package com.github.gibbrich.githubclient.model.user.source

import com.github.gibbrich.githubclient.model.base.IBaseSource
import com.github.gibbrich.githubclient.model.user.User
import io.reactivex.Maybe

/**
 * Created by Артур on 18.03.2018.
 */
interface IUserSource: IBaseSource
{
    fun getUser(userName: String): Maybe<User>
    fun saveUser(user: User)
}