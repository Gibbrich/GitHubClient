package com.github.gibbrich.githubclient

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.github.gibbrich.githubclient.model.repo.Repo
import com.github.gibbrich.githubclient.model.repo.source.RepoDao
import com.github.gibbrich.githubclient.model.user.User
import com.github.gibbrich.githubclient.model.user.source.UserDao

/**
 * Created by Артур on 17.03.2018.
 */

@Database(entities = arrayOf(Repo::class, User::class), version = 1)
abstract class AppDatabase: RoomDatabase()
{
    abstract fun repoDao(): RepoDao
    abstract fun userDao(): UserDao
}