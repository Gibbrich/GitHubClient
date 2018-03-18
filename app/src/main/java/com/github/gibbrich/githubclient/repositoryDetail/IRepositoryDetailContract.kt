package com.github.gibbrich.githubclient.repositoryDetail

import com.github.gibbrich.githubclient.base.IBasePresenter
import com.github.gibbrich.githubclient.base.IBaseView
import com.github.gibbrich.githubclient.base.ILoadingState
import com.github.gibbrich.githubclient.model.user.User

/**
 * Created by Артур on 18.03.2018.
 */
interface IRepositoryDetailContract
{
    interface Presenter: IBasePresenter
    {
        fun loadRepoInfo()
    }

    interface View: IBaseView<Presenter>, ILoadingState
    {
        fun setRepositoryName(repoName: String)
        fun setPrivacy(privacy: String)
        fun setLanguage(language: String)
        fun setIssuesCount(issuesCount: Int)
        fun setBranchesCount(branchesCount: Int)
        fun setCreatedDate(createdDate: String)
        fun setSize(size: Int)
        fun setOwner(user: User)
    }
}