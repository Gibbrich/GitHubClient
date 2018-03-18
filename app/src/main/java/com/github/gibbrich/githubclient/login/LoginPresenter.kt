package com.github.gibbrich.githubclient.login

import com.github.gibbrich.githubclient.base.BasePresenter
import com.github.gibbrich.githubclient.model.user.User
import com.github.gibbrich.githubclient.model.user.source.IUserSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Артур on 14.03.2018.
 */

class LoginPresenter(
        private val view: ILoginContract.View,
        private val userSource: IUserSource
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
        val disposable = userSource.getUser(userName)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            view.showRepositories()
                        },
                        {
                            view.showLoginError()
                        }
                )

        disposables.add(disposable)
    }
}