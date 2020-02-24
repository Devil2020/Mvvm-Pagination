package com.geeks.paging.ui

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.number_layout.*

class NumberAdapter (diffUtil: DiffUtil.ItemCallback<Int>): PagedListAdapter<Int,NumberAdapter.NumberViewHolder> (diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberViewHolder {
       return NumberViewHolder(LayoutInflater.from(parent.context).inflate(com.geeks.paging.R.layout.number_layout , parent , false))
    }

    override fun onBindViewHolder(holder: NumberViewHolder, position: Int) {
        holder.bind(getItem(position)!!)
        Log.i("nnnnnn","the item number ${getItem(position)} is called for Binding")
    }

    class NumberViewHolder(override val containerView: View?) : RecyclerView.ViewHolder(containerView!!),
        LayoutContainer {

        fun bind (num:Int){
            numberId.text = num.toString()
        }

    }

}