package com.dot.dotkotlinboilerplate.menu.listplace.adapters

import android.app.Activity
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dot.dotkotlinboilerplate.R

class ListPlaceAdapter(private val activity: Activity): RecyclerView.Adapter<ListPlaceAdapter.ItemListPlaceViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ItemListPlaceViewHolder {
        val view: View = LayoutInflater.from(activity).inflate(R.layout.item_list_place, p0, false)
        return ItemListPlaceViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(p0: ItemListPlaceViewHolder, p1: Int) {

    }

    class ItemListPlaceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}