package com.github.gibbrich.githubclient.login.di

import com.github.gibbrich.githubclient.di.ActivityScope
import com.github.gibbrich.githubclient.login.LoginActivity
import dagger.Subcomponent

/**
 * Created by Артур on 14.03.2018.
 */

@ActivityScope
@Subcomponent(modules = arrayOf(LoginModule::class))
interface LoginComponent
{
    fun inject(activity: LoginActivity)
}