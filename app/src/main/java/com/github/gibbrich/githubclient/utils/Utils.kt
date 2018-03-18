package com.github.gibbrich.githubclient.utils

import io.reactivex.Completable
import io.reactivex.schedulers.Schedulers

/**
 * Created by Артур on 18.03.2018.
 */

fun performActionOnIOScheduler(action: () -> Unit)
{
    Completable.fromAction(action)
            .subscribeOn(Schedulers.io())
            .subscribe()
}