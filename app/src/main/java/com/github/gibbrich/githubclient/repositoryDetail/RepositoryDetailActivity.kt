package com.github.gibbrich.githubclient.repositoryDetail

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import com.github.gibbrich.githubclient.GitHubClientApplication
import com.github.gibbrich.githubclient.R
import com.github.gibbrich.githubclient.base.BaseActivity
import com.github.gibbrich.githubclient.model.user.User
import com.github.gibbrich.githubclient.repositoryDetail.di.RepositoryDetailModule
import javax.inject.Inject

class RepositoryDetailActivity : BaseActivity<IRepositoryDetailContract.Presenter>(), IRepositoryDetailContract.View
{
    @Inject override lateinit var presenter: IRepositoryDetailContract.Presenter

    @BindView(R.id.repositoryName) lateinit var repositoryName: TextView
    @BindView(R.id.privacy) lateinit var privacy: TextView
    @BindView(R.id.language) lateinit var language: TextView
    @BindView(R.id.issuesCount) lateinit var issuesCount: TextView
    @BindView(R.id.branchesCount) lateinit var branchesCount: TextView
    @BindView(R.id.calendar) lateinit var calendar: TextView
    @BindView(R.id.memory) lateinit var memory: TextView
    @BindView(R.id.owner) lateinit var owner: TextView

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repository_detail)

        val repositoryID = intent.extras.getInt(EXTRA_REPOSITORY_ID, DEFAULT_REPOSITORY_ID)
        if (repositoryID == DEFAULT_REPOSITORY_ID)
        {
            throw IllegalArgumentException("Intent must contain EXTRA_REPOSITORY_ID")
        }

        ButterKnife.bind(this)

        GitHubClientApplication
                .INSTANCE
                .appComponent
                .plusRepositoryDetailComponent(RepositoryDetailModule(this, repositoryID))
                .inject(this)

        presenter.loadRepoInfo()
    }

    override fun setPrivacy(privacy: String)
    {
        this.privacy.text = privacy
    }

    override fun setLanguage(language: String)
    {
        this.language.text = language
    }

    override fun setIssuesCount(issuesCount: Int)
    {
        this.issuesCount.text = issuesCount.toString()
    }

    override fun setBranchesCount(branchesCount: Int)
    {
        this.branchesCount.text = branchesCount.toString()
    }

    override fun setCreatedDate(createdDate: String)
    {
        this.calendar.text = createdDate
    }

    override fun setSize(size: Int)
    {
        this.memory.text = size.toString()
    }

    override fun setOwner(user: User)
    {
        this.owner.text = user.login
    }

    override fun setLoadingError(isVisible: Boolean)
    {
        Toast.makeText(this, "setLoadingError stub", Toast.LENGTH_SHORT).show()
    }

    override fun setLoadingIndicator(isVisible: Boolean)
    {
        Toast.makeText(this, "setLoadingIndicator stub", Toast.LENGTH_SHORT).show()
    }

    override fun setRepositoryName(repoName: String)
    {
        repositoryName.text = repoName
    }

    companion object
    {
        private const val EXTRA_REPOSITORY_ID = "EXTRA_REPOSITORY_ID"
        private const val DEFAULT_REPOSITORY_ID = -1

        fun getIntent(context: Context, repositoryId: Int): Intent
        {
            return Intent(context, RepositoryDetailActivity::class.java).apply {
                putExtra(EXTRA_REPOSITORY_ID, repositoryId)
            }
        }
    }
}