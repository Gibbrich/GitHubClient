package com.github.gibbrich.githubclient.login.di

import com.github.gibbrich.githubclient.di.ActivityScope
import com.github.gibbrich.githubclient.login.LoginActivity
import com.github.gibbrich.githubclient.login.LoginPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by Артур on 14.03.2018.
 */
@Module
class LoginModule(private val activity: LoginActivity)
{
    @Provides
    @ActivityScope
    fun provideLoginActivity() = activity

    @Provides
    @ActivityScope
    fun provideLoginPresenter() = LoginPresenter(activity)
}