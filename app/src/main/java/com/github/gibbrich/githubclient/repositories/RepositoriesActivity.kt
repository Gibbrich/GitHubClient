package com.github.gibbrich.githubclient.repositories

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import com.github.gibbrich.githubclient.GitHubClientApplication
import com.github.gibbrich.githubclient.R
import com.github.gibbrich.githubclient.model.repo.Repo
import com.github.gibbrich.githubclient.repositories.di.RepositoriesModule
import javax.inject.Inject

class RepositoriesActivity : AppCompatActivity(), IRepositoriesContract.View
{
    @Inject lateinit var presenter: IRepositoriesContract.Presenter
    @Inject lateinit var adapter: RepositoriesAdapter
    @BindView(R.id.repositoriesList) lateinit var repositoriesList: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repositories)

        val userName = intent.extras.getString(EXTRA_USER_NAME) ?: throw IllegalStateException("Intent must contain EXTRA_USER_NAME")

        GitHubClientApplication
                .INSTANCE
                .appComponent
                .plusRepositoriesComponent(RepositoriesModule(this, userName))
                .inject(this)

        ButterKnife.bind(this)

        repositoriesList.setHasFixedSize(true)
        repositoriesList.isClickable = true
        repositoriesList.layoutManager = LinearLayoutManager(this)
        repositoriesList.adapter = adapter
    }

    override fun onResume()
    {
        super.onResume()

        val disposable = adapter.itemViewClickSubject
                .subscribe { presenter.onRepositoryClick(it) }
        presenter.addDisposable(disposable)

        presenter.subscribe()
    }

    override fun onPause()
    {
        super.onPause()

        presenter.unsubscribe()
    }

    override fun showRepos(repos: List<Repo>)
    {
        adapter.data = repos
    }

    override fun setIndicatorLoading(isLoading: Boolean)
    {
        Toast.makeText(this, "setIndicatorLoading stub", Toast.LENGTH_SHORT).show()
    }

    override fun setLoadingErrorVisibile(isVisible: Boolean)
    {
        Toast.makeText(this, "setLoadingErrorVisibile stub", Toast.LENGTH_SHORT).show()
    }

    override fun setNoReposViewVisibile(isVisible: Boolean)
    {
        Toast.makeText(this, "setNoReposViewVisibile stub", Toast.LENGTH_SHORT).show()
    }

    override fun showRepositoryDetails(repo: Repo)
    {
        Toast.makeText(this, "${repo.name} clicked", Toast.LENGTH_SHORT).show()
    }

    companion object
    {
        private const val EXTRA_USER_NAME = "EXTRA_USER_NAME"

        fun getInstance(context: Context, userName: String): Intent
        {
            return Intent(context, RepositoriesActivity::class.java).apply {
                putExtra(EXTRA_USER_NAME, userName)
            }
        }
    }
}