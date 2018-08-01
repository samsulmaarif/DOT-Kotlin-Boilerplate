package com.dot.dotkotlinboilerplate.menu.listplace.views

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.dot.dotkotlinboilerplate.R
import com.dot.dotkotlinboilerplate.data.AppConstants
import com.dot.dotkotlinboilerplate.databinding.ActivityMainBinding
import com.dot.dotkotlinboilerplate.menu.listplace.AdapterOnClickListener
import com.dot.dotkotlinboilerplate.menu.listplace.adapters.ListPlaceAdapter
import com.dot.dotkotlinboilerplate.menu.listplace.models.ListPlaceModel
import com.dot.dotkotlinboilerplate.menu.listplace.models.ListPlaceResponseModel
import com.dot.dotkotlinboilerplate.menu.listplace.viewmodels.ItemListPlaceViewModel
import com.dot.dotkotlinboilerplate.menu.listplace.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity: AppCompatActivity(), AdapterOnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    private lateinit var adapter: ListPlaceAdapter
    private var listPlace: MutableList<ItemListPlaceViewModel> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBinding()
        setupToolbar()
        setupSwipeRefresh()
        setupRecycler()

        viewModel.requestListPlace()

    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.destroy()
    }

    private fun setupBinding(){
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        binding.main = viewModel

        viewModel.listDataResponse.observe(this, Observer {
            onListDataChange(it!!)
        })
    }

    private fun setupToolbar(){
        setSupportActionBar(binding.toolbarMain)
    }

    private fun setupSwipeRefresh(){
        binding.swipeRefreshLayoutMain.setOnRefreshListener {
            binding.swipeRefreshLayoutMain.isRefreshing = false
            viewModel.requestListPlace()
        }
    }

    private fun setupRecycler(){
        val lManager = LinearLayoutManager(this)
        binding.recyclerViewMain.layoutManager = lManager
        binding.recyclerViewMain.setHasFixedSize(true)

        adapter = ListPlaceAdapter(this, listPlace)
        binding.recyclerViewMain.adapter = adapter
    }

    private fun onListDataChange(listPlaceResponseModel: ListPlaceResponseModel){
        listPlace.clear()
        for(i: Int in 0 until listPlaceResponseModel.data?.size!!){
            val vm = ItemListPlaceViewModel(listPlaceResponseModel.data[i], this)
            listPlace.add(vm)
        }
        recyclerViewMain.post {
            adapter.notifyDataSetChanged()
        }
    }

    override fun onItemClickListener(listPlaceModel: ListPlaceModel) {
        Log.d(AppConstants.TAG_DEBUG,"MainActivity # $listPlaceModel")
    }

}