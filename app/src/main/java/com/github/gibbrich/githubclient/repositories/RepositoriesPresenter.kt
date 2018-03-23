package com.github.gibbrich.githubclient.repositories

import com.github.gibbrich.githubclient.base.BasePresenter
import com.github.gibbrich.githubclient.model.repo.Repo
import com.github.gibbrich.githubclient.repositories.domain.useCase.GetRepos
import com.github.gibbrich.githubclient.repositories.domain.useCase.GetReposRequestValue
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Dvurechenskiyi on 15.03.2018.
 */
class RepositoriesPresenter(
        private val view: IRepositoriesContract.View,
        private val getRepos: GetRepos,
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

        val disposable = getRepos.execute(GetReposRequestValue(userName))
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