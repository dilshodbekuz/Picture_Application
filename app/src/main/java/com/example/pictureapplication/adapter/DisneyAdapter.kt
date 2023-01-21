package com.example.pictureapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pictureapplication.R
import com.example.pictureapplication.databinding.ItemDisneyBinding
import com.example.pictureapplication.model.DataX

class DisneyAdapter(val item:List<DataX>):RecyclerView.Adapter<DisneyAdapter.ItemHolder>() {
    class ItemHolder(val binding:ItemDisneyBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(
            ItemDisneyBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val items = item[position]

        holder.binding.tvDisney.text = items.name
        Glide.with(holder.itemView.context).load(items.imageUrl)
            .placeholder(R.drawable.back).into(holder.binding.ivDisney)
    }

    override fun getItemCount(): Int {
        return  item.count()
    }
}