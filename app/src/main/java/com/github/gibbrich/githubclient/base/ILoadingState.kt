package com.github.gibbrich.githubclient.base

/**
 * Created by Артур on 18.03.2018.
 */
interface ILoadingState
{
    fun setLoadingError(isVisible: Boolean)
    fun setLoadingIndicator(isVisible: Boolean)
}