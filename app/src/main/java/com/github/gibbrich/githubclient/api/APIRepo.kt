package com.github.gibbrich.githubclient.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Dvurechenskiyi on 15.03.2018.
 */
class APIRepo
{
    @Expose
    @SerializedName("id")
    var id: Int = 0

    @Expose
    @SerializedName("name")
    lateinit var name: String

    @Expose
    @SerializedName("forks_count")
    var forksCount: Int = 0

    @Expose
    @SerializedName("watchers")
    var watchersCount: Int = 0
}