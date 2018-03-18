package com.github.gibbrich.githubclient.base

import android.support.v7.widget.RecyclerView
import com.jakewharton.rxbinding2.view.RxView
import io.reactivex.subjects.PublishSubject

/**
 * Created by Артур on 16.03.2018.
 */
abstract class BaseAdapter<T, VH : RecyclerView.ViewHolder>(data: List<T>): RecyclerView.Adapter<VH>()
{
    val itemViewClickSubject: PublishSubject<T> = PublishSubject.create()
    var data = data
        set(value)
        {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: VH, position: Int)
    {
        RxView.clicks(holder.itemView)
                .map { data[position] }
                .subscribe(itemViewClickSubject)
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView?)
    {
        super.onDetachedFromRecyclerView(recyclerView)
        itemViewClickSubject.onComplete()
    }
}