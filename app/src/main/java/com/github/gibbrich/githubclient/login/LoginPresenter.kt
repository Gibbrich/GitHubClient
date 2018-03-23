package com.github.gibbrich.githubclient.login

import com.github.gibbrich.githubclient.base.BasePresenter
import com.github.gibbrich.githubclient.login.domain.useCase.Login
import com.github.gibbrich.githubclient.login.domain.useCase.LoginRequestValue
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Артур on 14.03.2018.
 */

class LoginPresenter(
        private val view: ILoginContract.View,
        val login: Login
): BasePresenter(), ILoginContract.Presenter
{
    private lateinit var userName: String

    override fun subscribe()
    {
    }

    override fun onLoginChanged(login: String)
    {
        this.userName = login
        view.setButtonEnabled(!login.isBlank())
    }

    override fun onLogin()
    {
        val disposable = login.execute(LoginRequestValue(userName))
                .subscribe(
                        { view.showRepositories() },
                        { view.showLoginError() }
                )

        disposables.add(disposable)
    }
}