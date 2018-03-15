package com.github.gibbrich.githubclient.login

import com.github.gibbrich.githubclient.di.ActivityScope
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject

/**
 * Created by Артур on 14.03.2018.
 */

class LoginPresenter(private val view: ILoginContract.View): ILoginContract.Presenter
{
    private val disposables: CompositeDisposable = CompositeDisposable()

    override fun subscribe()
    {
    }

    override fun unsubscribe()
    {
        disposables.clear()
    }

    override fun addDisposable(disposable: Disposable)
    {
        disposables.add(disposable)
    }

    override fun onLoginChanged(login: String)
    {
        view.setButtonEnabled(!login.isBlank())
    }

    override fun onLogin()
    {
        view.showRepositories()
    }
}