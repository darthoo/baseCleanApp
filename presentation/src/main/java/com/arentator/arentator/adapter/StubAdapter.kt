package com.arentator.arentator.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arentator.arentator.R

/**
 * Created by Nikolay on 22.02.2018.
 */
class StubAdapter : RecyclerView.Adapter<StubAdapter.ViewHolder>() {

    var data :MutableList<String> = mutableListOf()

    fun setNewData(data:MutableList<String>){
        this.data = data
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {}

    override fun getItemCount(): Int {
        return data.size
    }

    class ViewHolder(view:View):RecyclerView.ViewHolder(view){}
}