package com.github.gibbrich.githubclient.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

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
    var forksCount = 0

    @Expose
    @SerializedName("watchers")
    var watchersCount = 0

    @Expose
    @SerializedName("private")
    var isPrivate = false

    @Expose
    @SerializedName("open_issues_count")
    var openIssuesCount = 0

    @Expose
    @SerializedName("language")
    var language: String? = null

    @Expose
    @SerializedName("size")
    var size = 0

    @Expose
    @SerializedName("created_at")
    lateinit var createdDate: String // todo add adapter to Gson and move to Date

    @Expose
    @SerializedName("owner")
    lateinit var owner: APIUser
}