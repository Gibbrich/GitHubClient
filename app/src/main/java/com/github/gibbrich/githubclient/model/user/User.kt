package com.github.gibbrich.githubclient.model.user

import android.arch.persistence.room.Entity
import com.github.gibbrich.githubclient.api.APIUser
import com.github.gibbrich.githubclient.model.base.SimpleIDObject

/**
 * Created by Артур on 17.03.2018.
 */

@Entity(tableName = "Users")
class User(
        id: Int,
        name: String
): SimpleIDObject(id, name)
{
    lateinit var login: String

    companion object
    {
        fun createFromAPI(apiUser: APIUser): User
        {
            return User(apiUser.id, apiUser.name).apply {
                login = apiUser.login
            }
        }
    }
}