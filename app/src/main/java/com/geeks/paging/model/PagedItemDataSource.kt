package com.geeks.paging.model

import androidx.paging.PageKeyedDataSource



class PagedItemDataSource : PageKeyedDataSource<Int, Int>() {

    var pageIndex = 1
    var numbers = arrayListOf<Int>(1,2,3,4,5,6,7,8,9,10,1,12,3,14,5,16,7,18,9,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50)
    var start = 0
    var end= 9

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Int>
    ) {
        callback.onResult(numbers.slice(start .. end) ,null, 1)
        start +=10
        end +=10
       }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Int>) {
        if (params.key >= 41) {

        } else {
            callback.onResult(numbers.slice(start..if (end == 60) 59 else end), params.key + 10)
            start += 10
            end += 10
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Int>) {
        var key = if (pageIndex < 5 && pageIndex >= 0) pageIndex + 1 else 0
        start -=10
        end -=10
        callback.onResult(numbers.slice(start .. end) , key )
    }
}