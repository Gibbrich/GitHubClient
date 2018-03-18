package com.github.gibbrich.githubclient.model.user.source

import com.github.gibbrich.githubclient.GitHubAPI
import com.github.gibbrich.githubclient.model.user.User
import io.reactivex.Maybe

/**
 * Created by Артур on 18.03.2018.
 */
class UserRemoteSource(private val gitHubAPI: GitHubAPI): IUserSource
{
    override fun getUser(userName: String): Maybe<User>
    {
        return gitHubAPI.getUser(userName)
                .map { User.createFromAPI(it) }
    }

    override fun invalidateData()
    {
        // do nothing
    }

    override fun saveUser(user: User)
    {
        // do nothing
    }
}