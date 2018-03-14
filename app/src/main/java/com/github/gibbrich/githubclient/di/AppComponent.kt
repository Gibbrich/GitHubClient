package com.github.gibbrich.githubclient.di

import com.github.gibbrich.githubclient.login.di.LoginComponent
import com.github.gibbrich.githubclient.login.di.LoginModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Артур on 14.03.2018.
 */

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent
{
    fun plusLoginComponent(module: LoginModule): LoginComponent
}