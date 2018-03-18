package com.github.gibbrich.githubclient

import com.github.gibbrich.githubclient.api.APIRepo
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Dvurechenskiyi on 15.03.2018.
 */
interface GitHubAPI
{
    @GET("/users/{user}/repos")
    fun getRepositories(@Path("user") userName: String): Flowable<List<APIRepo>>
}