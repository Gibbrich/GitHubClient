package com.github.gibbrich.githubclient.model.repo

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.github.gibbrich.githubclient.api.APIRepo
import com.github.gibbrich.githubclient.model.base.SimpleIDObject
import java.util.*

/**
 * Created by Dvurechenskiyi on 15.03.2018.
 */

@Entity(tableName = "Repositories")
class Repo(
        id: Int,
        name: String
) : SimpleIDObject(id, name)
{
    var forksCount: Int = 0
    var watchersCount: Int = 0
    var isPrivate = false
    var openIssuesCount = 0
    var language: String? = null
    var size = 0
    lateinit var createdDate: String // todo move to date after switching APIRepo createdDate to Date

    companion object
    {
        fun createFromAPI(apiRepo: APIRepo): Repo
        {
            return Repo(apiRepo.id, apiRepo.name).apply {
                forksCount = apiRepo.forksCount
                watchersCount = apiRepo.watchersCount
                isPrivate = apiRepo.isPrivate
                openIssuesCount = apiRepo.openIssuesCount
                language = apiRepo.language
                size = apiRepo.size
                createdDate = apiRepo.createdDate
            }
        }
    }
}