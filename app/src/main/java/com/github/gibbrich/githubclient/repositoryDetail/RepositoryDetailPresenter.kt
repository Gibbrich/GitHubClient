package com.github.gibbrich.githubclient.repositoryDetail

import com.github.gibbrich.githubclient.base.BasePresenter
import com.github.gibbrich.githubclient.repositoryDetail.domain.useCase.GetRepo
import com.github.gibbrich.githubclient.repositoryDetail.domain.useCase.GetRepoRequestValue
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Артур on 18.03.2018.
 */
class RepositoryDetailPresenter(
        private val view: IRepositoryDetailContract.View,
        private val getRepo: GetRepo,
        private val repositoryId: Int
): BasePresenter(), IRepositoryDetailContract.Presenter
{
    override fun subscribe()
    {
    }

    override fun loadRepoInfo()
    {
        view.setLoadingIndicator(true)

        val disposable = getRepo.execute(GetRepoRequestValue(repositoryId))
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