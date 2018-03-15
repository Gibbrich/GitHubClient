package com.github.gibbrich.githubclient.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Dvurechenskiyi on 15.03.2018.
 */
class APIRepository
{
    @Expose
    @SerializedName("name")
    lateinit var name: String
}