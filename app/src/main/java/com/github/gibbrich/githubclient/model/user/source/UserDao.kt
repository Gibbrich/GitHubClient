package com.github.gibbrich.githubclient.model.user.source

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.github.gibbrich.githubclient.model.user.User
import io.reactivex.Maybe

/**
 * Created by Артур on 18.03.2018.
 */

@Dao
interface UserDao
{
    @Query("SELECT * FROM Users WHERE id = :id")
    fun getUser(id: Int): Maybe<User>

    @Query("SELECT * FROM Users WHERE name = :name")
    fun getUser(name: String): Maybe<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveUser(user: User)
}