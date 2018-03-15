package com.github.gibbrich.githubclient.login.di

import com.github.gibbrich.githubclient.di.ActivityScope
import com.github.gibbrich.githubclient.login.ILoginContract
import com.github.gibbrich.githubclient.login.LoginPresenter
import dagger.Module
import dagger.Provides

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
    fun provideLoginPresenter() = LoginPresenter(view)
}