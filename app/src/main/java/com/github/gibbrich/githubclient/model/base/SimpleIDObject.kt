package com.github.gibbrich.githubclient.model.base

import android.arch.persistence.room.PrimaryKey

import java.util.*

/**
 * Created by Артур on 18.03.2018.
 */
abstract class SimpleIDObject(
        @PrimaryKey val id: Int,
        val name: String
)
{
    override fun equals(other: Any?): Boolean
    {
        if (other == null)
        {
            return false
        }

        if (this === other)
        {
            return true
        }

        if (other !is SimpleIDObject)
        {
            return false
        }

        return id == other.id
    }

    override fun hashCode(): Int
    {
        return Objects.hash(SimpleIDObject::class.java.simpleName, id)
    }
}