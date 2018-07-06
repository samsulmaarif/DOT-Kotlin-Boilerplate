package com.dot.dotkotlinboilerplate.menu.listplace.adapters

import android.app.Activity
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dot.dotkotlinboilerplate.R
import com.dot.dotkotlinboilerplate.databinding.ItemListPlaceBinding
import com.dot.dotkotlinboilerplate.menu.listplace.models.ListPlaceModel
import com.dot.dotkotlinboilerplate.menu.listplace.viewmodels.ItemListPlaceViewModel

class ListPlaceAdapter(private val activity: Activity, private var listPlace: MutableList<ListPlaceModel.ListPlace>): RecyclerView.Adapter<ListPlaceAdapter.ItemListPlaceViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ItemListPlaceViewHolder {
        val binding: ItemListPlaceBinding = DataBindingUtil.inflate(LayoutInflater.from(activity), R.layout.item_list_place, parent, false)
        return ItemListPlaceViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listPlace.size
    }

    override fun onBindViewHolder(holder: ItemListPlaceViewHolder, position: Int) {
        val fixPosition = holder.adapterPosition
        holder.bindData(listPlace[fixPosition])
    }

    class ItemListPlaceViewHolder(private val binding: ItemListPlaceBinding) : RecyclerView.ViewHolder(binding.root) {

        private val viewModel = ItemListPlaceViewModel()

        fun bindData(model: ListPlaceModel.ListPlace){
            binding.itemListPlace = viewModel
            viewModel.setupData(model)

        }
    }
}