package com.github.gibbrich.githubclient.login.di

import com.github.gibbrich.githubclient.di.ActivityScope
import com.github.gibbrich.githubclient.login.ILoginContract
import com.github.gibbrich.githubclient.login.LoginPresenter
import com.github.gibbrich.githubclient.login.domain.useCase.Login
import com.github.gibbrich.githubclient.model.user.source.IUserSource
import dagger.Module
import dagger.Provides
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Артур on 14.03.2018.
 */
@Module
class LoginModule(private val view: ILoginContract.View)
{
    @Provides
    @ActivityScope
    fun provideLoginView() = view

    @Provides
    @ActivityScope
    fun provideLoginPresenter(userSource: IUserSource): ILoginContract.Presenter
    {
        val login = Login(Schedulers.computation(), AndroidSchedulers.mainThread(), userSource)
        return LoginPresenter(view, login)
    }
}