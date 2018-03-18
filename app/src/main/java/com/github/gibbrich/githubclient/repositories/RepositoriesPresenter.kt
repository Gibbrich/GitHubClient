package com.github.gibbrich.githubclient.repositories

import com.github.gibbrich.githubclient.base.BasePresenter
import com.github.gibbrich.githubclient.model.repo.Repo
import com.github.gibbrich.githubclient.model.repo.source.IReposSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by Dvurechenskiyi on 15.03.2018.
 */
class RepositoriesPresenter(
        private val view: IRepositoriesContract.View,
        private val reposSource: IReposSource,
        private val userName: String
) : BasePresenter(), IRepositoriesContract.Presenter
{
    override fun subscribe()
    {
        loadRepos()
    }

    override fun loadRepos()
    {
        view.setLoadingIndicator(true)

        val disposable = reposSource.getRepos(userName)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally { view.setLoadingIndicator(false) }
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
                            view.setLoadingError(true)
                        }
                )

        disposables.add(disposable)
    }

    override fun onRepositoryClick(repo: Repo)
    {
        view.showRepositoryDetails(repo)
    }
}