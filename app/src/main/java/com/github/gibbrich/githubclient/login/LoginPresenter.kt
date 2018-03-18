package com.github.gibbrich.githubclient.login

import com.github.gibbrich.githubclient.base.BasePresenter
import com.github.gibbrich.githubclient.di.ActivityScope
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject

/**
 * Created by Артур on 14.03.2018.
 */

class LoginPresenter(private val view: ILoginContract.View): BasePresenter(), ILoginContract.Presenter
{
    override fun subscribe()
    {
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