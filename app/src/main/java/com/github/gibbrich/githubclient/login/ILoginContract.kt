package com.github.gibbrich.githubclient.login

import com.github.gibbrich.githubclient.IBasePresenter
import com.github.gibbrich.githubclient.IBaseView
import io.reactivex.disposables.Disposable

/**
 * Created by Артур on 14.03.2018.
 */
interface ILoginContract
{
    interface Presenter: IBasePresenter
    {
        fun addDisposable(disposable: Disposable)
        fun onLoginChanged(login: String)
        fun onLogin()
    }

    interface View: IBaseView<IBasePresenter>
    {
        fun setButtonEnabled(isEnabled: Boolean)
        fun showRepositories()
    }
}