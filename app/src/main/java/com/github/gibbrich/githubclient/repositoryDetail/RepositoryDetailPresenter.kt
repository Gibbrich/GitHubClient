package com.github.gibbrich.githubclient.repositoryDetail

import com.github.gibbrich.githubclient.base.BasePresenter
import com.github.gibbrich.githubclient.model.repo.source.IReposSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Артур on 18.03.2018.
 */
class RepositoryDetailPresenter(
        private val view: IRepositoryDetailContract.View,
        private val repositorySource: IReposSource,
        private val repositoryId: Int
): BasePresenter(), IRepositoryDetailContract.Presenter
{
    override fun subscribe()
    {
    }

    override fun loadRepoInfo()
    {
        view.setLoadingIndicator(true)

        val disposable = repositorySource.getRepo(repositoryId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally { view.setLoadingIndicator(false) }
                .subscribe(
                        {
                            view.setRepositoryName(it.name)
                            val privacy = if (it.isPrivate) "Private" else "Public"
                            view.setPrivacy(privacy)
                            view.setLanguage(it.language ?: "-")
                            view.setIssuesCount(it.openIssuesCount)
                            view.setCreatedDate(it.createdDate)
                            view.setSize(it.size)
                            view.setBranchesCount(0) // todo change to parametrized value
                            // todo setOwner
                        },
                        {
                            view.setLoadingError(true)
                        }
                )

        disposables.add(disposable)
    }
}