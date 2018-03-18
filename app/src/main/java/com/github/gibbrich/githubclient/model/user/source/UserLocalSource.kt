package com.github.gibbrich.githubclient.model.user.source

import com.github.gibbrich.githubclient.model.user.User
import com.github.gibbrich.githubclient.utils.performActionOnIOScheduler

/**
 * Created by Артур on 18.03.2018.
 */
class UserLocalSource(private val userDao: UserDao): IUserSource
{
    override fun invalidateData()
    {
        // do nothing
    }

    override fun getUser(userName: String) = userDao.getUser(userName)

    override fun saveUser(user: User)
    {
        performActionOnIOScheduler { userDao.saveUser(user) }
    }
}