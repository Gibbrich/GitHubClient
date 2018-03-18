package com.github.gibbrich.githubclient.model.repo.source

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.github.gibbrich.githubclient.model.repo.Repo
import io.reactivex.Flowable
import io.reactivex.Maybe

/**
 * Created by Артур on 17.03.2018.
 */

@Dao
interface RepoDao
{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRepo(repo: Repo)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRepos(repos: List<Repo>)

    @Query("SELECT * FROM Repositories")
    fun getRepos(): Flowable<List<Repo>>

    @Query("DELETE FROM Repositories")
    fun deleteAllRepos()

    @Query("SELECT * FROM Repositories WHERE id = :id")
    fun getRepo(id: Int): Maybe<Repo>
}