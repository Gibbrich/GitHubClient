package com.github.gibbrich.githubclient.model.user.source

import com.github.gibbrich.githubclient.model.base.BaseRepository
import com.github.gibbrich.githubclient.model.user.User
import io.reactivex.Maybe

/**
 * Created by Артур on 18.03.2018.
 */
class UserRepository(
        localSource: UserLocalSource,
        remoteSource: UserRemoteSource
): BaseRepository<User, IUserSource>(localSource, remoteSource), IUserSource
{
    override fun getUser(userName: String): Maybe<User>
    {
        return remoteSource.getUser(userName)
                .doOnSuccess { saveUser(it) }
    }

    override fun saveUser(user: User)
    {
        cache.put(user.hashCode(), user)
        localSource.saveUser(user)
    }
}