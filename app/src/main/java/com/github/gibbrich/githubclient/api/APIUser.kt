package com.github.gibbrich.githubclient.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Артур on 18.03.2018.
 */
class APIUser
{
    @Expose
    @SerializedName("id")
    var id: Int = 0

    @Expose
    @SerializedName("login")
    lateinit var login: String

    @Expose
    @SerializedName("name")
    lateinit var name: String
}