package com.dot.dotkotlinboilerplate.views

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.dot.dotkotlinboilerplate.R
import com.dot.dotkotlinboilerplate.databinding.ActivityMainBinding
import com.dot.dotkotlinboilerplate.viewmodels.MainViewModel

class MainActivity: AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = MainViewModel(this)
        binding.main = viewModel
    }

}