package com.github.gibbrich.githubclient.model.repo

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.util.*

/**
 * Created by Dvurechenskiyi on 15.03.2018.
 */

@Entity(tableName = "Repositories")
class Repo(
        @PrimaryKey val id: Int,
        val name: String
)
{
    var forksCount: Int = 0
    var watchersCount: Int = 0

    override fun equals(other: Any?): Boolean
    {
        if (other == null)
        {
            return false
        }

        if (this === other)
        {
            return true
        }

        if (other !is Repo)
        {
            return false
        }

        return id == other.id
    }

    override fun hashCode(): Int
    {
        return Objects.hash(Repo::class.java.simpleName, id)
    }
}