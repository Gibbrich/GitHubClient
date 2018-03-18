package com.github.gibbrich.githubclient.login

import com.github.gibbrich.githubclient.base.IBasePresenter
import com.github.gibbrich.githubclient.base.IBaseView

/**
 * Created by Артур on 14.03.2018.
 */
interface ILoginContract
{
    interface Presenter: IBasePresenter
    {
        fun onLoginChanged(login: String)
        fun onLogin()
    }

    interface View: IBaseView<IBasePresenter>
    {
        fun setButtonEnabled(isEnabled: Boolean)
        fun showRepositories()
    }
}