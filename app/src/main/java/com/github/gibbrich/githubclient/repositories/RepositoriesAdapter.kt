package com.github.gibbrich.githubclient.repositories

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.github.gibbrich.githubclient.R
import com.github.gibbrich.githubclient.base.BaseAdapter
import com.github.gibbrich.githubclient.model.repo.Repo

/**
 * Created by Dvurechenskiyi on 15.03.2018.
 */
class RepositoriesAdapter(repos: List<Repo>) : BaseAdapter<Repo, RepositoryViewHolder>(repos)
{
    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int)
    {
        super.onBindViewHolder(holder, position)

        val repo = data[position]

        holder.repositoryName.text = repo.name
        holder.forksCount.text = repo.forksCount.toString()
        holder.watchersCount.text = repo.watchersCount.toString()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder
    {
        val root = LayoutInflater.from(parent.context).inflate(R.layout.repository_list_item_layout, parent, false)
        return RepositoryViewHolder(root)
    }
}

class RepositoryViewHolder(root: View) : RecyclerView.ViewHolder(root)
{
    @BindView(R.id.repositoryName) lateinit var repositoryName: TextView
    @BindView(R.id.forksCount) lateinit var forksCount: TextView
    @BindView(R.id.watchersCount) lateinit var watchersCount: TextView

    init
    {
        ButterKnife.bind(this, root)
    }
}