package com.github.gibbrich.githubclient.base

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by Артур on 17.03.2018.
 */
abstract class BasePresenter: IBasePresenter
{
    protected val disposables: CompositeDisposable = CompositeDisposable()

    override fun unsubscribe()
    {
        disposables.clear()
    }

    override fun addDisposable(disposable: Disposable)
    {
        disposables.add(disposable)
    }
}