package com.geeks.paging.domain

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import androidx.paging.PageKeyedDataSource
import com.geeks.paging.model.PagedItemDataSource

class PagedItemDataSourceFactory : DataSource.Factory<Int, Int>() {
    private var dataSourceFactory = MutableLiveData<PageKeyedDataSource<Int, Int>>()

    override fun create(): DataSource<Int, Int> {
        return PagedItemDataSource().apply {
            dataSourceFactory.postValue(this)
        }
    }

    public fun getMutableLiveDataOfDataSource () : MutableLiveData<PageKeyedDataSource<Int, Int>>{
        return dataSourceFactory
    }
}