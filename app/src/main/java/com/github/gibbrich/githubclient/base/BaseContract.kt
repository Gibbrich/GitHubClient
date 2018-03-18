package com.github.gibbrich.githubclient.base

import io.reactivex.disposables.Disposable

/**
 * Created by Артур on 14.03.2018.
 */

interface IBasePresenter
{
    fun subscribe()
    fun unsubscribe()
    fun addDisposable(disposable: Disposable)
}

interface IBaseView<T: IBasePresenter>