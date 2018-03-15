package com.github.gibbrich.githubclient.repositories

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.github.gibbrich.githubclient.R
import com.github.gibbrich.githubclient.model.repo.Repo

/**
 * Created by Dvurechenskiyi on 15.03.2018.
 */
class RepositoriesAdapter(repos: List<Repo>) : RecyclerView.Adapter<RepositoryViewHolder>()
{
    var repos = repos
        set(value)
        {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = repos.size

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int)
    {
        holder.repositoryName.text = repos[position].name
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder
    {
        val root = LayoutInflater.from(parent.context).inflate(R.layout.repository_list_item_layout, parent, false)
        return RepositoryViewHolder(root)
    }
}

class RepositoryViewHolder(root: View) : RecyclerView.ViewHolder(root)
{
    val repositoryName: TextView = root.findViewById(R.id.repositoryName)
}