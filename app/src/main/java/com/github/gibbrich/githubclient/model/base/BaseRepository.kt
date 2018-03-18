package com.github.gibbrich.githubclient.model.base

/**
 * Created by Артур on 18.03.2018.
 */
abstract class BaseRepository<T, out S: IBaseSource>(
        protected val localSource: S,
        protected val remoteSource: S
): IBaseSource
{
    protected val cache: MutableMap<Int, T> = HashMap()
    protected var isCacheDirty = true

    override fun invalidateData()
    {
        isCacheDirty = true
    }
}