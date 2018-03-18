package com.github.gibbrich.githubclient.repositories

import com.github.gibbrich.githubclient.base.IBasePresenter
import com.github.gibbrich.githubclient.base.IBaseView
import com.github.gibbrich.githubclient.base.ILoadingState
import com.github.gibbrich.githubclient.model.repo.Repo

/**
 * Created by Dvurechenskiyi on 15.03.2018.
 */
interface IRepositoriesContract
{
    interface Presenter: IBasePresenter
    {
        fun loadRepos()
        fun onRepositoryClick(repo: Repo)
    }

    interface View: IBaseView<Presenter>, ILoadingState
    {
        fun showRepos(repos: List<Repo>)
        fun setNoReposViewVisibile(isVisible: Boolean)
        fun showRepositoryDetails(repo: Repo)
    }
}