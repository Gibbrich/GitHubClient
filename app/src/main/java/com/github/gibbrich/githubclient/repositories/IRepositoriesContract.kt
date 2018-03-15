package com.github.gibbrich.githubclient.repositories

import com.github.gibbrich.githubclient.IBasePresenter
import com.github.gibbrich.githubclient.IBaseView
import com.github.gibbrich.githubclient.model.repo.Repo

/**
 * Created by Dvurechenskiyi on 15.03.2018.
 */
interface IRepositoriesContract
{
    interface Presenter: IBasePresenter
    {
        fun loadRepos()
    }

    interface View: IBaseView<Presenter>
    {
        fun showRepos(repos: List<Repo>)
        fun setIndicatorLoading(isLoading: Boolean)
        fun setLoadingErrorVisibile(isVisible: Boolean)
        fun setNoReposViewVisibile(isVisible: Boolean)
    }
}