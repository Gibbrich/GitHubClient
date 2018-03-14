package com.github.gibbrich.githubclient

/**
 * Created by Артур on 14.03.2018.
 */

interface IBasePresenter
{
    fun subscribe()
    fun unsubscribe()
}

interface IBaseView<T: IBasePresenter>
{
}