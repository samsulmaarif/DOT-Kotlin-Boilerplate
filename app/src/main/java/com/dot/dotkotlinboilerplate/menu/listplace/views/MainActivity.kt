package com.dot.dotkotlinboilerplate.menu.listplace.views

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.dot.dotkotlinboilerplate.R
import com.dot.dotkotlinboilerplate.data.AppConstants
import com.dot.dotkotlinboilerplate.databinding.ActivityMainBinding
import com.dot.dotkotlinboilerplate.menu.listplace.models.ListPlaceModel
import com.dot.dotkotlinboilerplate.menu.listplace.repositories.ListPlaceRepository
import com.dot.dotkotlinboilerplate.menu.listplace.viewmodels.MainViewModel

class MainActivity: AppCompatActivity(), ListPlaceRepository {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBinding()
        setupSwipeRefresh()

        viewModel.requestListPlace()

    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.destroy()
    }

    private fun setupBinding(){
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = MainViewModel(this)
        binding.main = viewModel
    }

    private fun setupSwipeRefresh(){
        binding.swipeRefreshLayoutMain.setOnRefreshListener {
            binding.swipeRefreshLayoutMain.isRefreshing = false
            viewModel.requestListPlace()
        }
    }

    override fun onGetListPlaceSuccess(listPlaceModel: ListPlaceModel) {
        Log.d(AppConstants.TAG_DEBUG,"MainActivity # jumlah data : ${listPlaceModel.data?.size}")
    }

    override fun onGetListPlaceError() {

    }

}