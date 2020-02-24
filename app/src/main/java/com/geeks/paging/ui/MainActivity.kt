package com.geeks.paging.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.paging.PagedList
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.geeks.paging.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var ourViewModel : NumbersViewModel
    lateinit var ourNumberAdapter : NumberAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var diffUtill = object : DiffUtil.ItemCallback<Int>() {
                override fun areItemsTheSame(oldItem: Int, newItem: Int): Boolean {
                    Log.i("getEquality" , "areItems are the Same")
                    return oldItem == newItem
                }

                override fun areContentsTheSame(oldItem: Int, newItem: Int): Boolean {
                    Log.i("getEquality" , "are Contents are the Same")
                    return oldItem == newItem
                }
        }
        ourNumberAdapter = NumberAdapter(diffUtill)
        ourViewModel = ViewModelProviders.of(this).get(NumbersViewModel::class.java)
        ourViewModel.loadNumbers()
        ourViewModel.pagedList.observe(this ,
            object : Observer<PagedList<Int>>{
                override fun onChanged(t: PagedList<Int>?) {
                       recyclerView.adapter = ourNumberAdapter
                        recyclerView.layoutManager = LinearLayoutManager(baseContext)
                       ourNumberAdapter.submitList(t)
                }

            } )
    }
}
