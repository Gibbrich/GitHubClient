package com.github.gibbrich.githubclient.repositories

import com.github.gibbrich.githubclient.model.repo.source.IReposSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by Dvurechenskiyi on 15.03.2018.
 */
class RepositoriesPresenter(
        private val view: IRepositoriesContract.View,
        private val reposSource: IReposSource,
        private val userName: String
) : IRepositoriesContract.Presenter
{
    private val disposables: CompositeDisposable = CompositeDisposable()

    override fun subscribe()
    {
        loadRepos()
    }

    override fun unsubscribe()
    {
        disposables.clear()
    }

    override fun loadRepos()
    {
        view.setIndicatorLoading(true)

        val disposable = reposSource.getRepos(userName)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally { view.setIndicatorLoading(false) }
                .subscribe(
                        {
                            if (it.isEmpty())
                            {
                                view.setNoReposViewVisibile(true)
                            }
                            else
                            {
                                view.showRepos(it)
                            }
                        },
                        {
                            it.printStackTrace()
                            view.setLoadingErrorVisibile(true)
                        }
                )

        disposables.add(disposable)
    }
}