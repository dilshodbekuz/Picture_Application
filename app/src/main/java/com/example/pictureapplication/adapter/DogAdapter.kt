package com.example.pictureapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pictureapplication.R
import com.example.pictureapplication.databinding.ItemDogBinding
import com.example.pictureapplication.model.Test

/*
class DogAdapter(val item:List<Test>):RecyclerView.Adapter<DogAdapter.ItemHolder>() {
    class ItemHolder(val binding: ItemDogBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(
            ItemDogBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val items = item[position]

        Glide.with(holder.itemView.context).load(items.african)
            .placeholder(R.drawable.back).into(holder.binding.ivDog)
    }
    override fun getItemCount(): Int {
        return item.size
    }
}*/
