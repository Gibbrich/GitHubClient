package com.github.gibbrich.githubclient

import com.github.gibbrich.githubclient.api.APIRepo
import com.github.gibbrich.githubclient.api.APIUser
import io.reactivex.Flowable
import io.reactivex.Maybe
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Dvurechenskiyi on 15.03.2018.
 */
interface GitHubAPI
{
    @GET("/users/{user}/repos")
    fun getRepositories(@Path("user") userName: String): Flowable<List<APIRepo>>

    @GET("/users/{user}")
    fun getUser(@Path("user") userName: String): Maybe<APIUser>

    @GET("/repos/{owner}/{repo}")
    fun getRepo(@Path("owner") userName: String, @Path("repo") repoName: String)
}