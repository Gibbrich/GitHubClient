package com.github.gibbrich.githubclient

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.github.gibbrich.githubclient.model.repo.Repo
import com.github.gibbrich.githubclient.model.repo.source.RepoDao

/**
 * Created by Артур on 17.03.2018.
 */

@Database(entities = arrayOf(Repo::class), version = 1)
abstract class AppDatabase: RoomDatabase()
{
    abstract fun repoDao(): RepoDao
}