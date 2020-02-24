package com.geeks.paging.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PageKeyedDataSource
import androidx.paging.PagedList
import com.geeks.paging.domain.PagedItemDataSourceFactory

class NumbersViewModel  : ViewModel() {
    lateinit var pagedList : LiveData<PagedList<Int>>
    lateinit var dataSourceList : MutableLiveData<PageKeyedDataSource<Int, Int>>

    public fun loadNumbers(){
        var factory = PagedItemDataSourceFactory()
        dataSourceList= factory.getMutableLiveDataOfDataSource()
        val config = PagedList.Config.Builder().setEnablePlaceholders(false).setPageSize(10).build()
        pagedList = LivePagedListBuilder<Int , Int>(factory!!
            ,config!!).build()
    }



}