package com.github.gibbrich.githubclient.base

import android.support.v7.app.AppCompatActivity

/**
 * Created by Артур on 18.03.2018.
 */
abstract class BaseActivity<out T: IBasePresenter>: AppCompatActivity()
{
    abstract val presenter: T

    override fun onResume()
    {
        super.onResume()

        presenter.subscribe()
    }

    override fun onPause()
    {
        super.onPause()

        presenter.unsubscribe()
    }
}